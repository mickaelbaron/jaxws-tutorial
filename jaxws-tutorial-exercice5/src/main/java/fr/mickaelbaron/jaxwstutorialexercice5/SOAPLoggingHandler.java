package fr.mickaelbaron.jaxwstutorialexercice5;

import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 * @author Mickael BARON (baron.mickael@gmail.com)
 */
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
		Boolean outboundProperty = (Boolean) smc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

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
