# Exercice 2 (JAX-WS) : développer un service web suivant une approche descendante « Top/Down »

Dans cet exercice, nous développons un service web à partir de sa description WSDL. Pour cela, nous nous basons sur la description WSDL du service web obtenue à la fin de l'exercice 1\. L'intérêt est de montrer que 1) la génération des classes (artifacts) ne donne pas exactement les mêmes classes que celles construites dans l'exercice 1 et 2) la génération est obligatoire.

## But

- Générer les artifacts d'un service web à partir d'une description WSDL.
- Implémenter le service web.
- Publier en local.
- Tester le service web.
- Utilisation de **wsimport**.

## Étapes à suivre

- Assurez-vous que le programme principal du premier exercice est en cours d'exécution et que le WSDL du service web est toujours accessible.

- Ouvrir le dossier du projet Maven **jaxws-tutorial-exercice2**.

- Afin de générer les classes (artifacts), nous utilisons l'outil **wsimport** par l'intermédiaire de Maven. Compléter le fichier de description Maven _pom.xml_ existant.

```xml
<plugin>
    <groupId>com.sun.xml.ws</groupId>
    <artifactId>jaxws-maven-plugin</artifactId>
    <version>${jaxws.version}</version>
    <executions>
        <execution>
            <goals>
                <goal>wsimport</goal>
            </goals>
            <configuration>
                <packageName>fr.mickaelbaron.jaxwstutorialexercice2</packageName>
                <sourceDestDir>${project.build.directory}/generated-sources/jaxws-wsimport</sourceDestDir>
                <keep>true</keep>
                <wsdlUrls>
                    <wsdlUrl>http://localhost:9991/ws/notebookservice?wsdl</wsdlUrl>
                </wsdlUrls>
            </configuration>
        </execution>
    </executions>
</plugin>
```

- Exécuter la ligne de commande suivante à la racine de votre projet. 

```bash
mvn clean generate-sources
```

Un ensemble de classes sera généré par l'outil **wsimport** et localisé dans le répertoire _./target/generated-sources/jaxws-wsimport_. Ces classes ne doivent pas être modifiées puisqu'elles sont générées automatiquement.

Il reste maintenant à implémenter la classe `NotebookServiceImpl`. Elle correspond à la classe implémentant le comportement du service web.

- Réutiliser et adapter le code de l'exercice 1 pour compléter cette classe.
