# Exercice 3 (JAX-WS) : développer un client de service web en mode synchrone

Cet exercice consiste à appeler le service web défini depuis l'exercice 1\. Des tests unitaires ont été définis pour invoquer les différentes méthodes.

## But

- Développer un client d'un service web.
- Appel synchrone de service web.
- Outil **wsimport** et test d'intégration.

## Étapes à suivre

- Assurez-vous que le programme principal de l'exercice 1 est en cours d'exécution et que le WSDL du service web est toujours accessible.

- Ouvrir le dossier du projet Maven **jaxws-tutorial-exercice3**.

- Compléter le fichier de description Maven _pom.xml_ existant afin de générer les classes artifacts.

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
                <packageName>fr.mickaelbaron.jaxwstutorialexercice3</packageName>
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

- Compléter la classe de test `NotebookWebServiceTest` afin d'accéder au port du service puis exécuter les tests unitaires.

```java
package fr.mickaelbaron.jaxwstutorialexercice3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NotebookWebServiceTest {

    protected NotebookService notebookPort;

	@BeforeEach
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
        // TODO: appeler l'opération `addPerson`.

        // Then
        Assertions.assertTrue(addPerson);
    }

    @Test
    public void getPersonsTest() {
        // Given
        // When
        // TODO: appeler l'opération `getPersons`.

        // Then
        Assertions.assertTrue(persons.size() >= 2);
    }

    @Test
    public void getPersonAtTest() {
        // Given
        // TODO: initialiser une variable à 'Mickael Baron'.

        // When
        // TODO: appeler l'opération `getPersonAt` avec la variable précédente.

        // Then
        Assertions.assertNotNull(personAt);
        Assertions.assertEquals(personAt.getAddress(), "Migné-Auxances");
    }
}
```
