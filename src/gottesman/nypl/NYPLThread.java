package gottesman.nypl;

import java.io.IOException;

import javax.swing.JList;

public class NYPLThread extends Thread {

	private JList<String> titleList;
	private AccessConnection connection;
	private NYPL readNypl;
	private NyplAPI nyplApi;
	private Response response;
	private Result[] results;
	private String[] titles;
	private String searchText;

	public NYPLThread(JList<String> titleList, String searchText) {
		this.titleList = titleList;
		connection = new AccessConnection();
		this.searchText = searchText;
		titles = new String[30];
	}

	@Override
	public void run() {

		try {
			readNypl = connection.getConnection(searchText);
			nyplApi = readNypl.getNYPLApi();
			response = nyplApi.getResponse();
			results = response.getResults();

			for (int i = 0; i < results.length; i++) {
				titles[i] = results[i].getTitle();
			}

			titleList.setListData(titles);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Result[] getResults() {
		return results;
	}
}
