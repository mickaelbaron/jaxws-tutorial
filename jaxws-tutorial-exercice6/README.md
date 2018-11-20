# Exercice 6 (JAX-WS) : déployer des services web étendus

Dans cet exercice nous allons réaliser deux types de déploiement d'un service web étendu : un déploiement pour des tests (exécuter depuis un jar) et un déploiement sur le serveur d'applications Tomcat (déployer un fichier war). Nous ferons abstraction de l'environnement de développement Eclipse afin d'être le plus proche de l'environnement de production.

## But

* Déployer pour des tests.
* Packager un service web dans une archive War.
* Déployer un service web sur le serveur d'applications Java Tomcat.
* Gérer les problèmes de dépendances.

## Étapes à suivre pour effectuer un déploiement pour des tests (utilisation de la classe Endpoint)

> Remarquez que le contenu des fichiers Java est identique au projet *jaxws-tutorial-exercice1*.

* Saisir la ligne de commande suivante depuis la racine du projet pour compiler et construire le fichier jar du projet.

```bash
mvn clean package
```

* Saisir la ligne de commande suivante pour démarrer le projet.

```bash
$ java -cp "target/ws.jar" fr.mickaelbaron.jaxwstutorialexercice6.NotebookWebServicePublisher
Exception in thread "main" java.lang.NoClassDefFoundError: javax/xml/ws/Endpoint
        at fr.mickaelbaron.jaxwstutorialexercice6.NotebookWebServicePublisher.main(NotebookWebServicePublisher.java:10)
Caused by: java.lang.ClassNotFoundException: javax.xml.ws.Endpoint
    at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:582)
    at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:190)
    at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:499)
    ... 1 more
```

Vous remarquerez que le projet de démarre pas du fait de l'absence de certaines dépendances. Il est donc nécessaire de fournir lors de l'exécution (dans le classpath) les dépendances nécessaires.

* Modifier le fichier _pom.xml_ afin d'ajouter le plugin **maven-dependency-plugin** qui permettra de lister toutes les bibliothèques nécessaires.

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-dependency-plugin</artifactId>
    <version>${maven.dependency.version}</version>
    <executions>
        <execution>
            <id>copy-dependencies</id>
            <phase>package</phase>
            <goals>
                <goal>copy-dependencies</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

* Saisir les lignes de commande suivantes pour compiler, construire et démarrer le projet.

```bash
mvn clean package
...
$ java -cp "target/classes:target/dependency/*" fr.mickaelbaron.jaxwstutorialexercice6.NotebookWebServicePublisher
```

## Étapes à suivre pour effectuer un déploiement sur le serveur d'applications Tomcat

Le fichier *web.xml* est utilisé pour configurer le déploiement de l'application web. Ainsi pour accéder à l'application vous devrez utiliser le contexte suivant */notebookservice*.

* Compléter le fichier *web.xml* à partir de la configuration donnée ci-dessous.

```xml
...
<web-app>
    <display-name>jaxws-tutorial-exercice6</display-name>
    <listener>
        <listener-class>com.sun.xml.ws.transport.http.servlet.WSServletContextListener</listener-class>
    </listener>
    <servlet>
        <display-name>notebookservice</display-name>
        <servlet-name>notebookservice</servlet-name>
        <servlet-class>com.sun.xml.ws.transport.http.servlet.WSServlet</servlet-class>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>notebookservice</servlet-name>
        <url-pattern>/notebookservice</url-pattern>
    </servlet-mapping>
    <session-config>
        <session-timeout>60</session-timeout>
    </session-config>
</web-app>
```

Le fichier *sun-jaxws.xml* est utilisé pour configurer l'accès au service web SOAP. Il permet de mapper le contexte */notebookservice* avec la classe qui implémente le service web étendue `NotebookServiceImpl`.

* Compléter le fichier à partir de la configuration donnée ci-dessous.

```xml
<?xml version="1.0" encoding="UTF-8"?>

<endpoints xmlns='http://java.sun.com/xml/ns/jax-ws/ri/runtime' version='2.0'>
    <endpoint
        name='notebookservice'
        implementation='fr.mickaelbaron.jaxwstutorialexercice6.NotebookServiceImpl'
        url-pattern='/notebookservice'/>
</endpoints>
```

* Saisir la ligne de commande suivante pour compiler et construire le projet vers un fichier war.

```bash
mvn clean package -P war
```

> L'option -P war permet d'utiliser le profile Maven appelé war. Depuis le fichier _pom.xml_ examiner la balise `<profiles>`. Cette astuce permet de générer un fichier jar ou un fichier war depuis un même fichier _pom.xml_.

```xml
    ...
    <packaging>${project.packaging}</packaging>
    ...
    <profiles>
        <profile>
            <id>jar</id>
            <activation>
                <activeByDefault>true</activeByDefault>
            </activation>
            <properties>
                <project.packaging>jar</project.packaging>
            </properties>
        </profile>
        <profile>
            <id>war</id>
            <properties>
                <project.packaging>war</project.packaging>
            </properties>
        </profile>
    </profiles>
```

* Saisir la ligne de commande suivante pour télécharger une image Docker de Tomcat

```bash
docker pull tomcat:9.0.12-jre10-slim
```

* Enfin, saisir la ligne de commande suivante pour créer un conteneur Docker qui permettra de démarrer une instance de Tomcat. Le fichier `ws.war` contient tous le code et dépendances de ce projet. 

```bash
docker run --rm --name helloworldservice-tomcat -v $(pwd)/target/ws.war:/usr/local/tomcat/webapps/ws.war -it -p 8080:8080 tomcat:9.0.12-jre10-slim
```

* Ouvrir un navigateur web et tester l'URL suivante : <http://localhost:8080/ws/notebookservice?wsdl> et visualiser le WSDL.
