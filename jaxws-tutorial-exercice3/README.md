# Exercice 3 (JAX-WS) : développer un client de service web en mode synchrone

Cet exercice consiste à appeler le service web défini depuis l'exercice 1. Des tests unitaires ont été définis pour invoquer les différentes méthodes.

## But

* Développer un client d'un service web.
* Appel synchrone de service web.
* Outil **wsimport** et test d'intégration.

## Étapes à suivre

* Assurez-vous que le programme principal de l'exercice 1 est en cours d'exécution et que le WSDL du service web est toujours accessible.

* Importer le projet Maven **jaxws-tutorial-exercice3** (**File -> Import -> Maven -> Existing Maven Projects** et choisir l'option **Select archive file** puis sélectionner l'archive).

* Compléter le fichier de description Maven *pom.xml* existant afin de générer les classes artifacts.

```xml
<plugin>
    <groupId>org.codehaus.mojo</groupId>
    <artifactId>jaxws-maven-plugin</artifactId>
    <version>${jaxws.maven.version}</version>
    <executions>
        <execution>
            <goals>
                <goal>wsimport</goal>
            </goals>
            <configuration>
                <packageName>fr.mickaelbaron.jaxwstutorialexercice3</packageName>
                <sourceDestDir>${project.build.directory}/generated-sources/jaxws-wsimport</sourceDestDir>
                <keep>true</keep>
                <executable>${java.home}/bin/wsimport</executable>
                <wsdlUrls>
                    <wsdlUrl>http://localhost:9991/ws/notebookservice?wsdl</wsdlUrl>
                </wsdlUrls>
            </configuration>
        </execution>
    </executions>
</plugin>
```

* Depuis Eclipse, exécuter la configuration d'exécution appelée *wsimport3 (clean and generate-sources)*. Si vous rencontrez des soucis avec l'intégration Maven sous Eclipse, exécuter la ligne de commande suivante à la racine de votre projet `$ mvn clean generate-sources`. Un ensemble de classes sera généré par l'outil **wsimport** et localisé dans le répertoire *./target/generated-sources/jaxws-wsimport*. Ces classes ne doivent pas être modifiées puisqu'elles sont générées automatiquement.

* Compléter la classe de test `NotebookWebServiceTest` afin d'accéder au port du service puis exécuter les tests unitaires.

```java
package fr.mickaelbaron.jaxwstutorialexercice3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NotebookWebServiceTest {

    protected NotebookService notebookPort;

    @Before
    public void setup() {
        NotebookService_Service notebookService = new NotebookService_Service();
        notebookPort = notebookService.getNotebookPort();
    }

    @Test
    public void addPersonTest() {
        // Given
        Person myPerson = new Person();
        myPerson.setName("NewPerson");
        myPerson.setAddress("NewAddress");

        // When
        // To complete

        // Then
        Assert.assertTrue(addPerson);
    }

    @Test
    public void getPersonsTest() {
        // Given
        // When
        // To complete

        // Then
        Assert.assertTrue(persons.size() >= 2);
    }

    @Test
    public void getPersonAtTest() {
        // Given
        // To complete

        // When
        // To complete

        // Then
        Assert.assertNotNull(personAt);
        Assert.assertEquals(personAt.getAddress(), "Migné-Auxances");
    }
}
```
