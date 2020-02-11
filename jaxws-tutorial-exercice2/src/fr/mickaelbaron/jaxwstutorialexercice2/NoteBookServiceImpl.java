/**
 * 
 */
package fr.mickaelbaron.jaxwstutorialexercice2;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;


/**
 * @author Reginald.Bourdon
 *
 */
@WebService(endpointInterface = "fr.mickaelbaron.jaxwstutorialexercice1.NoteBookService", serviceName="NoteBookService", portName="NoteBookPort")
public class NoteBookServiceImpl implements NoteBookService {
    
    

    private List<Person> persons = new ArrayList<Person>();

    public NoteBookServiceImpl() {
        Person person1 = new Person();
        person1.setName("Mickael Baron");
        person1.setAddress("Migné-Auxances");
        Person person2 = new Person();
        person2.setName("Sébastien Loeb");
        person2.setAddress("France");
        persons.add(person1);
        persons.add(person2);
    }

    @Override
    public boolean addPerson(Person p) {
        System.out.println("addPerson method has been invoked:" + p);

        if (p == null) throw new NullPointerException("Person is null");

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

        if (name == null || name.isEmpty()) throw new NullPointerException("Name is null.");

        for (Person person : persons) {
            if (name.equals(person.getName())) return person;
        }
        return null;
    }

}
