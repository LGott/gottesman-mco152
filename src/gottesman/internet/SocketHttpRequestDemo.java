package gottesman.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketHttpRequestDemo {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub

		// A socket is an endpoint for communication betweeen two machines.

		Socket socket = new Socket("www.google.com", 80);

		String httprequestString = "GET /index.html\n\n"; // This is the request that gets sent * (not fully true- says
		// schwimmer

		PrintWriter out = new PrintWriter(socket.getOutputStream());
		out.write(httprequestString);
		out.flush();

		java.io.InputStream in = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}

		socket.close();
	}

}
