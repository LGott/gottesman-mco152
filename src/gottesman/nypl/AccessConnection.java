package gottesman.nypl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class AccessConnection {
	String searchText;

	public NYPL getConnection(String searchText) throws IOException {

		this.searchText = searchText;

		String url = "http://api.repo.nypl.org/api/v1/items/search?q=" + searchText + "&publicDomainOnly=true";

		URL theURL = new URL(url);

		HttpURLConnection connection = (HttpURLConnection) theURL.openConnection();

		connection.setRequestProperty("Authorization", "Token token=\"99g7g0lys09fa6ne\"");

		InputStream in = connection.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		Gson gson = new Gson();

		return gson.fromJson(br, NYPL.class);

	}
}
