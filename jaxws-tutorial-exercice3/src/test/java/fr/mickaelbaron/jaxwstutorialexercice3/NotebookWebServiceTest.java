package fr.mickaelbaron.jaxwstutorialexercice3;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Mickael BARON (baron.mickael@gmail.com)
 */
public class NotebookWebServiceTest {

	protected NotebookService notebookPort;

	@Before
	public void setup() {
		NotebookService_Service notebookService = new NotebookService_Service();
		notebookPort = notebookService.getNotebookPort();
	}

	@Test
	public void addPersonTest() {
		// Given
		Person myPerson = new Person();
		myPerson.setName("NewPerson");
		myPerson.setAddress("NewAddress");

		// When
		boolean addPerson = notebookPort.addPerson(myPerson);

		// Then
		Assert.assertTrue(addPerson);
	}

	@Test
	public void getPersonsTest() {
		// Given
		// When
		List<Person> persons = notebookPort.getPersons();

		// Then
		Assert.assertTrue(persons.size() >= 2);
	}

	@Test
	public void getPersonAtTest() {
		// Given
		String name = "Mickael Baron";

		// When
		Person personAt = notebookPort.getPersonAt(name);

		// Then
		Assert.assertNotNull(personAt);
		Assert.assertEquals(personAt.getAddress(), "Migné-Auxances");
	}
}
