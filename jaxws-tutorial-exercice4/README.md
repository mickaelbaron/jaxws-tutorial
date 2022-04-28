# Exercice 4 (JAX-WS): développer un client de service web en mode asynchrone

Cet exercice consiste à appeler le service web défini dans l'exercice 1. Un client lourd défini via une interface graphique SWING est utilisé pour invoquer l'opération `addPerson(...)` en mode asynchrone. L'intérêt de cet exercice est de montrer comment paramétrer la génération des artifacts via **wsimport** pour le mode asynchrone.

## But

* Développer un client d'un service web.
* Appel asynchrone de service web.
* Outil **wsimport**.
* Client lourd via une interface graphique SWING.

## Étapes à suivre

* Assurez-vous que le programme principal du premier exercice est en cours d'exécution et que le WSDL du service web est toujours accessible.

* Importer le projet Maven **jaxws-tutorial-exercice4** (**File -> Import -> Maven -> Existing Maven Projects**, choisir le répertoire du projet puis faire **Finish**.

* Pour modifier la génération des classes artifacts des informations supplémentaires peuvent être indiquées dans un fichier binding. Créer un fichier nommé _binding.xml_ stocké dans le répertoire _src/jaxws_ dont le contenu est le suivant.

```xml
<bindings 
	xmlns:xsd="http://www.w3.org/2001/XMLSchema"
	xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"
	wsdlLocation="http://localhost:9991/ws/notebookservice?wsdl"
	xmlns="https://jakarta.ee/xml/ns/jaxws">
	<bindings node="wsdl:definitions">
		<enableAsyncMapping>true</enableAsyncMapping>
	</bindings>
</bindings>
```

* Compléter le fichier de description Maven _pom.xml_ existant afin de générer les classes artifacts (identique à l'exercice 2 et 3). Pour la prise en compte du fichier _binding.xml_ vous ajouterez ces paramètres dans le contenu de la balise configuration.

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

* Depuis Eclipse, exécuter la configuration d'exécution appelée _wsimport (clean and generate-sources)_ comme pour les exercices 2 et 3.

* Compléter la classe `NotebookWebServiceAsynchronousClient`.

```java
package fr.mickaelbaron.jaxwstutorialexercice4;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import jakarta.xml.ws.AsyncHandler;
import jakarta.xml.ws.Response;

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

                // TODO: initialiser un service et un port.

                // TODO: invoquer de manière asynchrone l'opération `addPerson` à partir du port précédent
                // et faire appel au code suivant.
                //     if (!res.isCancelled() && res.isDone()) {
                //         textArea.append("New Person added.\n");
                //         startButton.setEnabled(true);
                //     }
            }
        });

        this.pack();
        this.setSize(400,200);
		this.setLocationRelativeTo(null);
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
