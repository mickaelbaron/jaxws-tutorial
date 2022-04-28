package fr.mickaelbaron.jaxwstutorialexercice4;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

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
				// TODO
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
