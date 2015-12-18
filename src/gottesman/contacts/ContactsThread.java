package gottesman.contacts;

import java.io.IOException;

import javax.swing.JLabel;

public class ContactsThread extends Thread {

	ContactsConnection contactsConn; // Returns a Users list class that holds an array of users
	UsersList[] userList;
	ContactsConnection contactList;
	Users[] cont; // Array of users
	JLabel[] contactLabels;

	public ContactsThread() throws IOException {

		contactsConn = new ContactsConnection();
		userList = contactsConn.contactConnect();

		cont = userList[0].getUsers();

		contactLabels = new JLabel[10];

	}

	@Override
	public void run() {
		for (int i = 0; i < 9; i++) {

			contactLabels[i].setText(cont[0].getName().toString());
		}
	}

	public JLabel[] getLabelList() {

		return this.contactLabels;
	}
}
