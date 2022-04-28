package fr.mickaelbaron.jaxwstutorialexercice6;

import jakarta.xml.ws.Endpoint;

/**
 * @author Mickael BARON (baron.mickael@gmail.com)
 */
public class NotebookWebServicePublisher {
	public static void main(String[] args) throws ClassNotFoundException {
		Endpoint.publish("http://localhost:9991/ws/notebookservice", new NotebookServiceImpl());
	}
}
