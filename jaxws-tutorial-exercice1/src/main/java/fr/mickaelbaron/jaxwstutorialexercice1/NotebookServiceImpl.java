package fr.mickaelbaron.jaxwstutorialexercice1;

import java.util.ArrayList;
import java.util.List;

import jakarta.jws.WebService;

/**
 * @author Mickael BARON (baron.mickael@gmail.com)
 */
@WebService(endpointInterface = "fr.mickaelbaron.jaxwstutorialexercice1.NotebookService", serviceName = "NotebookService", portName = "NotebookPort")
public class NotebookServiceImpl implements NotebookService {

	private List<Person> persons = new ArrayList<Person>();

	public NotebookServiceImpl() {
		persons.add(new Person("Mickael Baron", "Migné-Auxances"));
		persons.add(new Person("Sébastien Loeb", "France"));
	}

	@Override
	public boolean addPerson(Person p) {
		System.out.println("addPerson method has been invoked:" + p);

		if (p == null)
			throw new NullPointerException("Person is null");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return persons.add(p);
	}

	@Override
	public List<Person> getPersons() {
		System.out.println("getPersons method has been invoked.");

		return persons;
	}

	@Override
	public Person getPersonAt(String name) {
		System.out.println("getPersonAt method has been invoked: " + name);

		if (name == null || name.isEmpty())
			throw new NullPointerException("Name is null.");

		for (Person person : persons) {
			if (name.equals(person.getName()))
				return person;
		}
		return null;
	}
}
