package fr.mickaelbaron.jaxwstutorialexercice5;

import java.util.List;

import javax.jws.WebService;

/**
 * @author Mickael BARON (baron.mickael@gmail.com)
 */
@WebService(name = "NotebookService", targetNamespace = "http://jaxwstutorialexercice1.mickaelbaron.fr")
public interface NotebookService {

	boolean addPerson(Person p);

	List<Person> getPersons();

	Person getPersonAt(String name);
}
