package fr.mickaelbaron.jaxwstutorialexercice6;

import java.util.List;

import jakarta.jws.WebService;

/**
 * @author Mickael BARON (baron.mickael@gmail.com)
 */
@WebService(name = "NotebookService", targetNamespace="http://jaxwstutorialexercice6.mickaelbaron.fr")
public interface NotebookService {

	boolean addPerson(Person p);
	
	List<Person> getPersons();
	
	Person getPersonAt(String name);
}
