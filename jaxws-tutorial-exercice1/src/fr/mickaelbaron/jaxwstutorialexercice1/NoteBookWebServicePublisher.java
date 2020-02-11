package fr.mickaelbaron.jaxwstutorialexercice1;

import javax.xml.ws.Endpoint;

/**
 * @author Mickael BARON (baron.mickael@gmail.com)
 */
public class NoteBookWebServicePublisher {
	public static void main(String[] args) throws ClassNotFoundException {
	    Endpoint.publish("http://localhost:9991/ws/notebookservice", new NoteBookServiceImpl());
	}
}
