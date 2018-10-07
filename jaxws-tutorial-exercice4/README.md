# Exercice 4 (JAX-WS): développer un client de service web en mode asynchrone

Cet exercice consiste à appeler le service web défini dans l'exercice 1. Un client lourd défini via une interface graphique SWING est utilisé pour invoquer l'opération `addPerson(...)` en mode asynchrone. L'intérêt de cet exercice est de montrer comment paramétrer la génération des artifacts via **wsimport** pour le mode asynchrone.

## But

* Développer un client d'un service web.
* Appel asynchrone de service web.
* Outil **wsimport**.
* Client lourd via une interface graphique SWING.

## Étapes à suivre

* Assurez-vous que le programme principal du premier exercice est en cours d'exécution et que le WSDL du service web est toujours accessible.

* Importer le projet Maven **jaxws-tutorial-exercice4** (**File -> Import -> Maven -> Existing Maven Projects** et choisir l'option **Select archive file** puis sélectionner l'archive).

* Pour modifier la génération des classes artifacts des informations supplémentaires peuvent être indiquées dans un fichier binding. Créer un fichier nommé *binding.xml* stocké dans le répertoire *src/jaxws* dont le contenu est le suivant.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<bindings
    wsdlLocation="http://localhost:9991/ws/NotebookService?wsdl"
    xmlns="http://java.sun.com/xml/ns/jaxws">
    <enableAsyncMapping>true</enableAsyncMapping>
</bindings>
```

* Compléter le fichier de description Maven *pom.xml* existant afin de générer les classes artifacts (identique à l'exercice 2 et 3). Pour la prise en compte du fichier *binding.xml* vous ajouterez ces paramètres dans le contenu de la balise configuration.

```xml
<configuration>
    ...
    <bindingFiles>
        <bindingFile>
            ${basedir}/src/main/resources/binding.xml
        </bindingFile>
    </bindingFiles>
</configuration>
```

* Depuis Eclipse, exécuter la configuration d'exécution appelée *wsimport (clean and generate-sources)* comme pour les exercices 2 et 3.

* Compléter la classe *NotebookWebServiceAsynchronousClient*

```java
package soa.jaxwslabs.notebookwebserviceexercice4;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

public class NotebookWebServiceAsynchronousClient extends JFrame {

    private static final long serialVersionUID = -8095150953761740313L;

    public NotebookWebServiceAsynchronousClient() {
        super("NotebookWebServiceAsynchronous Client");

        this.setLayout(new BorderLayout());
        final JButton startButton = new JButton("Call addPerson operation");
        this.getContentPane().add(BorderLayout.NORTH, startButton);

        final JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        this.getContentPane().add(BorderLayout.CENTER, textArea);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButton.setEnabled(false);
                Person newPerson = new Person();
                newPerson.setName("New Person");
                newPerson.setAddress("Poitiers");

                textArea.append("addPerson operation has been invoked.\n");

                NotebookService_Service service = new NotebookService_Service();
                NotebookService port = service.getNoteBookPort();

                port.addPersonAsync(newPerson, new AsyncHandler<AddPersonResponse>() {
                    @Override
                    public void handleResponse(Response<AddPersonResponse> res) {
                        if (!res.isCancelled() && res.isDone()) {
                            textArea.append("New Person added.\n");
                            startButton.setEnabled(true);
                        }
                    }
                });
            }
        });

        this.pack();
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new NotebookWebServiceAsynchronousClient();
    }
}
```

* Exécuter le programme, le résultat attendu est celui montré sur la figure ci-dessous.

![Swing exercice 4](./images/exercice4-swing.png "Swing exercice 4")
