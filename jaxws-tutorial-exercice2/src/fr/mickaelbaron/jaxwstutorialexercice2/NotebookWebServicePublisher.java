package fr.mickaelbaron.jaxwstutorialexercice2;

import javax.xml.ws.Endpoint;

/**
 * @author Mickael BARON (baron.mickael@gmail.com)
 */
public class NotebookWebServicePublisher {
	public static void main(String[] args) throws ClassNotFoundException {
		Endpoint.publish("http://localhost:9992/ws/NotebookService", new NoteBookServiceImpl());
	}
}
