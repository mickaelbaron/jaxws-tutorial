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
	}

	@Test
	public void addPersonTest() {
		// Given

		// When
		// To complete

		// Then
		Assert.assertTrue(addPerson);
	}

	@Test
	public void getPersonsTest() {
		// Given
		// When
		// To complete

		// Then
		Assert.assertTrue(persons.size() >= 2);
	}

	@Test
	public void getPersonAtTest() {
		// Given
		// To complete

		// When
		// To complete

		// Then
		Assert.assertNotNull(personAt);
		Assert.assertEquals(personAt.getAddress(), "Migné-Auxances");
	}
}
