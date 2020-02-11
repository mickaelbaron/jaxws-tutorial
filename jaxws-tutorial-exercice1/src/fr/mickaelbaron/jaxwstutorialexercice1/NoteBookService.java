package fr.mickaelbaron.jaxwstutorialexercice1;

import java.util.List;
import javax.jws.WebService;


@WebService(name="NoteBookService", targetNamespace = "http://jaxwstutorialexercice1.mickaelbaron.fr")
public interface NoteBookService {
    
    boolean addPerson(Person p);
    
    List<Person> getPersons();
    
    Person getPersonAt(String name);
 
}
