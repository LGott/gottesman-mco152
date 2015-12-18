package gottesman.contacts;

import java.awt.Container;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

public class ContactGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JList<JLabel> contactList;

	public ContactGUI() {

		setTitle("Contact List");
		setSize(1300, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final Container container = getContentPane();

		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		ContactsThread contactThread;

		try {
			contactThread = new ContactsThread();

			contactThread.start();

			JLabel[] contactLabels = new JLabel[10];
			contactLabels = contactThread.getLabelList();

			contactList = new JList<JLabel>(contactLabels);

			add(contactList);

			// Font f = new Font("Dialog", Font.PLAIN, 24);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ContactGUI gui = new ContactGUI();
		gui.setVisible(true);
	}
}
