package fr.mickaelbaron.jaxwstutorialexercice4;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

/**
 * @author Mickael BARON (baron.mickael@gmail.com)
 */
public class NotebookWebServiceAsynchronousClient extends JFrame {

	private static final long serialVersionUID = -8095150953761740313L;

	public NotebookWebServiceAsynchronousClient() {
		super("NotebookWebServiceAsynchronous Client");
		
		this.setLayout(new BorderLayout());
		final JButton startButton = new JButton("Call addPerson operation");
		this.getContentPane().add(BorderLayout.NORTH, startButton);
		
		final JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		this.getContentPane().add(BorderLayout.CENTER, textArea);
		
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			 // TODO: initialiser un service et un port.
			   NoteBookService_Service service = new NoteBookService_Service();
			   NoteBookService noteBookPort = service.getNoteBookPort();			   
			   
			   startButton.setEnabled(false);
         Person newPerson = new Person();
         newPerson.setName("New Person");
         newPerson.setAddress("Poitiers");

         textArea.append("addPerson operation has been invoked.\n");
         
         noteBookPort.addPersonAsync(newPerson, new AsyncHandler<AddPersonResponse>() {

            @Override
            public void handleResponse(Response<AddPersonResponse> res) {
                // TODO: invoquer de manière asynchrone l'opération `addPerson` à partir du port précédent
                // et faire appel au code suivant.
                     if (!res.isCancelled() && res.isDone()) {
                         textArea.append("New Person added.\n");
                         startButton.setEnabled(true);
                     }
                
            }
        });         
			}
		});
		
		this.pack();
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new NotebookWebServiceAsynchronousClient();
	}
}
