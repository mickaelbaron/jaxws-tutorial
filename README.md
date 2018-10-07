# JAX-WS Tutoriel

L'objectif de cette deuxième série d'exercices est d'apprendre à manipuler l'API JAX-WS pour le développement de services web étendus à partir de la plateforme de développement Java.

Chaque exercice est fourni dans un dossier avec à l'intérieur un projet Java Maven contenant des classes et des fichiers de configuration qu'il faudra compléter au fur et à mesure des questions.

**Buts pédagogiques** : transformation d'un POJO Java en service web, génération des artifacts à partir d'une description WSDL, utilisation de l'outillage fourni depuis JavaSE 6, mise en place d'un intercepteur (handler), clients service web en mode synchrone et asynchrone, outils **wsgen** et **wsimport**.

# Prérequis logiciels

Avant de démarrer cette série d'exercices sur l'utilisation de l'API JAX-WS, veuillez préparer votre environnement de développement en installant les outils suivants :

* [Java via OpenJDK](http://jdk.java.net/ "Java 8 à 10")
* [Maven](https://maven.apache.org/ "Maven")
* [Eclipse](https://www.eclipse.org/ "Eclipse")
* [SOAP-UI](http://www.soapui.org/ "SOAP-UI")
* [Docker (exercice 6)](https://www.docker.com/ "Docker")

> Ces exemples ne supportent pas complètement Java 11 puisque celui-ci ne fournit plus les outils wsimport et wsgen. Par ailleurs, les modules Java (introduit depuis Java 9) ne sont pas utilisés explicitement.

> Ce dépôt est utilisé dans le cadre d'un cours sur les architectures orientées services que je dispense à l'[ISAE-ENSMA](https://www.ensma.fr) et à l'[Université de Poitiers](http://www.univ-poitiers.fr/) en français. Tous les supports de cours et tutoriaux sont disponibles sur ma page Developpez.com : [https://mbaron.developpez.com](https://mbaron.developpez.com/#page_soa).

# Remerciements

Pour aller plus loin, vous pouvez consulter les ressources suivantes :

* [Support de cours SOA](http://mbaron.developpez.com/soa/intro/ "Support de cours SOA")
* [Support de cours WSDL](http://mbaron.developpez.com/soa/wsdl "Support de cours WSDL")
* [Support de cours SOAP](http://mbaron.developpez.com/soa/soap "Support de cours SOAP")
* [Support de cours JAX-WS](http://mbaron.developpez.com/soa/jaxws "Support de cours JAX-WS")
* [Exercices sur le test fonctionnel de services web avec SOAP-UI](http://mbaron.developpez.com/tutoriels/soa/soapui-tests-fonctionnels-services-web "Exercices sur le test fonctionnel de services web avec SOAP-UI")

Je tiens à remercier [Claude Leloup](http://www.developpez.net/forums/u124512/claudeleloup/) pour sa relecture orthographique de cet article.