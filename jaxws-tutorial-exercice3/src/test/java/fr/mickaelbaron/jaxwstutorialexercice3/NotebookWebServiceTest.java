package fr.mickaelbaron.jaxwstutorialexercice3;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.mickaelbaron.jaxwstutorialexercice3.NoteBookService;
import fr.mickaelbaron.jaxwstutorialexercice3.NoteBookService_Service;
import fr.mickaelbaron.jaxwstutorialexercice3.Person;

/**
 * @author Mickael BARON (baron.mickael@gmail.com)
 */
public class NotebookWebServiceTest {

	protected NoteBookService notebookPort;

	@Before
	public void setup() {
	    
	    NoteBookService_Service notebookService = new NoteBookService_Service();
      notebookPort = notebookService.getNoteBookPort();
	}

	@Test
	public void addPersonTest() {
		// Given
	    Person myPerson = new Person();
      myPerson.setName("NewPerson");
      myPerson.setAddress("NewAddress");
		// When
		// To complete
      boolean addPerson = notebookPort.addPerson(myPerson);    
		// Then
		Assert.assertTrue(addPerson);
	}

	@Test
	public void getPersonsTest() {
		// Given
		// When
		// To complete
	    List<Person> persons = notebookPort.getPersons();
		// Then
		Assert.assertTrue(persons.size() >= 2);
	}

	@Test
	public void getPersonAtTest() {
		// Given
		// To complete
	    Person personAt = notebookPort.getPersonAt("Mickael Baron");
		// When
		// To complete

		// Then
		Assert.assertNotNull(personAt);
		Assert.assertEquals(personAt.getAddress(), "Migné-Auxances");
	}
}
