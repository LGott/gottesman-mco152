package gottesman.contacts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class ContactsConnection {

	public UsersList[] contactConnect() throws IOException {

		String urlAddress = "http://jsonplaceholder.typicode.com/users";

		URL url = new URL(urlAddress);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		Gson gson = new Gson();

		UsersList[] userList;
		userList = gson.fromJson(reader, UsersList[].class);

		return userList;
	}
}