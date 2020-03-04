# JAX-WS Tutoriel

L'objectif de cette série d'exercices est d'apprendre à manipuler l'API JAX-WS pour le développement de services web étendus à partir de la plateforme de développement Java.

Chaque exercice est fourni dans un dossier avec à l'intérieur un projet Java Maven contenant des classes et des fichiers de configuration qu'il faudra compléter au fur et à mesure des questions.

**Buts pédagogiques** : transformation d'un POJO Java en service web, génération des artifacts à partir d'une description WSDL, utilisation de l'outillage fourni depuis JavaSE 6, mise en place d'un intercepteur (handler), clients service web en mode synchrone et asynchrone, outils **wsgen** et **wsimport**.

> Ce dépôt est utilisé dans le cadre d'un cours sur les architectures orientées services que je dispense à l'[ISAE-ENSMA](https://www.ensma.fr) et à l'[Université de Poitiers](http://www.univ-poitiers.fr/) en français. Tous les supports de cours et tutoriaux sont disponibles sur ma page Developpez.com : [https://mbaron.developpez.com](https://mbaron.developpez.com/#page_soa).

## Prérequis logiciels

Avant de démarrer cette série d'exercices sur l'utilisation de l'API JAX-WS, veuillez préparer votre environnement de développement en installant les outils suivants :

* [Java via OpenJDK](http://jdk.java.net/ "Java 8+")
* [Maven](https://maven.apache.org/ "Maven")
* [Eclipse](https://www.eclipse.org/ "Eclipse")
* [SOAP-UI](http://www.soapui.org/ "SOAP-UI")
* [Docker (exercice 6)](https://www.docker.com/ "Docker")

> Ces exemples n'utilisent pas les modules Java (introduits depuis Java 9).

## Ressources et Remerciements

Retrouver la précédente leçon :

* [Tutoriel sur SOAP-UI pour inspecter et invoquer un service web étendus/SOAP via l’outil SOAP-UI](https://github.com/mickaelbaron/soapui-tutorial).

Pour aller plus loin, vous pouvez consulter les ressources suivantes :

* [Support de cours SOA](https://mickael-baron.fr/soa/introduction-soa "Support de cours SOA") ;
* [Support de cours WSDL](https://mickael-baron.fr/soa/decrire-configurer-wsdl "Support de cours WSDL") ;
* [Support de cours SOAP](https://mickael-baron.fr/soa/communiquer-soap "Support de cours SOAP") ;
* [Support de cours JAX-WS](https://mickael-baron.fr/soa/developper-serviceweb-jaxws "Support de cours JAX-WS").

Je tiens à remercier [Claude Leloup](http://www.developpez.net/forums/u124512/claudeleloup/) pour sa relecture orthographique de cet article.
