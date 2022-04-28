# Exercice 5 (JAX-WS) : ajouter un intercepteur (handler) à un service web

Dans cet exercice un intercepteur est ajouté au service web décrivant le carnet d'adresses. L'intercepteur a pour fonction de filtrer les messages SOAP de telle sorte que le traitement de l'opération `getPersons()` ne soit pas réalisé.

## But

* Implémentation handler côté serveur.
* Configuration du service web.
* Filtrage par opération.
* Développer un client d'un service web.

## Étapes à suivre

* Importer le projet Maven **jaxws-tutorial-exercice5** (**File -> Import -> Maven -> Existing Maven Projects**, choisir le répertoire du projet puis faire **Finish**.

* Dans la classe `NotebookServiceImpl`, ajouter l'annotation `@HandlerChain(file = "handler.xml")` au niveau de la description de la classe.

* Ajouter un fichier *handler.xml*, au niveau du répertoire *src/main/resources*.

```xml
<handler-chains xmlns="https://jakarta.ee/xml/ns/jakartaee">
    <handler-chain>
       <handler>
           <handler-name>fr.mickaelbaron.jaxwstutorialexercice5.SOAPLoggingHandler</handler-name>
           <handler-class>fr.mickaelbaron.jaxwstutorialexercice5.SOAPLoggingHandler</handler-class>
       </handler>
    </handler-chain>
</handler-chains>
```

* Ajouter une nouvelle classe intitulée `SOAPLoggingHandler` dont le code est défini de la manière suivante.

```java
package fr.mickaelbaron.jaxwstutorialexercice5;

import java.util.Set;

import javax.xml.namespace.QName;

import jakarta.xml.soap.SOAPBody;
import jakarta.xml.soap.SOAPEnvelope;
import jakarta.xml.soap.SOAPException;
import jakarta.xml.ws.handler.MessageContext;
import jakarta.xml.ws.handler.soap.SOAPHandler;
import jakarta.xml.ws.handler.soap.SOAPMessageContext;

public class SOAPLoggingHandler implements SOAPHandler<SOAPMessageContext> {

    @Override
    public Set<QName> getHeaders() {
        return null;
    }

    @Override
    public void close(MessageContext context) {
    }

    @Override
    public boolean handleMessage(SOAPMessageContext smc) {
        Boolean outboundProperty = (Boolean) smc
                .get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        if (outboundProperty.booleanValue()) {
            return false;
        } else {
            String methodName = getMethodName(smc, true);
            if (!"getPersons".equals(methodName)) {
                System.out.println(methodName + ": authorized");
                return true;
            } else {
                System.out.println(methodName + ": not authorized");
                return false;
            }
        }
    }

    @Override
    public boolean handleFault(SOAPMessageContext smc) {
        return true;
    }

    private String getMethodName(SOAPMessageContext context, boolean isRequest) {
        try {
            SOAPEnvelope envelope = context.getMessage().getSOAPPart().getEnvelope();
            SOAPBody body = envelope.getBody();
            return body.getChildNodes().item(0).getLocalName();
        } catch (SOAPException e) {
            e.printStackTrace();

            return null;
        }
    }
}
```

* Exécuter la classe `NotebookWebServicePublisher` pour démarrer votre service web.

* À partir de l'outil SOAP-UI (voir atelier 1), vérifier que l'appel à l'opération `getPersons` retourne une réponse vide.
