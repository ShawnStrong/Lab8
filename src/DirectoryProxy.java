import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;

import com.google.gson.Gson;

public class DirectoryProxy{
	LinkedList<Employee> sort = new LinkedList<>();
	Gson g = new Gson();

	public void print() {
		// TODO Auto-generated method stub

		try {
			System.out.println("Attempting to connect to the server");

			// Client will connect to this location
			URL site = new URL("http://localhost:8000/print");
			HttpURLConnection conn = (HttpURLConnection) site.openConnection();

			// now create a POST request
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			DataOutputStream out = new DataOutputStream(conn.getOutputStream());
			
			System.out.println("Connected to server");

			// build a string that contains JSON from console
			//String content = "";
			//content = getJSON();
			//String content = g.toJson(temp);

			// write out string to output buffer for message
			//out.writeBytes(content);
			out.flush();
			out.close();

			System.out.println("Done sent to server");

			InputStreamReader inputStr = new InputStreamReader(conn.getInputStream());

			// string to hold the result of reading in the response
			StringBuilder sb = new StringBuilder();

			// read the characters from the request byte by byte and build up
			// the Response
			int nextChar;
			while ((nextChar = inputStr.read()) > -1) {
				sb = sb.append((char) nextChar);
			}
			System.out.println("Return String: " + sb);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clear() {
		// TODO Auto-generated method stub
		sort.clear();

	}

	public void add(Employee temp)
	{
		try {
			System.out.println("Attempting to connect to the server");

			// Client will connect to this location
			URL site = new URL("http://localhost:8000/submit");
			HttpURLConnection conn = (HttpURLConnection) site.openConnection();

			// now create a POST request
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			DataOutputStream out = new DataOutputStream(conn.getOutputStream());
			
			System.out.println("Connected to server");

			// build a string that contains JSON from console
			//String content = "";
			//content = getJSON();
			String content = g.toJson(temp);

			// write out string to output buffer for message
			out.writeBytes(content);
			out.flush();
			out.close();

			System.out.println("Done sent to server");

			InputStreamReader inputStr = new InputStreamReader(conn.getInputStream());

			// string to hold the result of reading in the response
			StringBuilder sb = new StringBuilder();

			// read the characters from the request byte by byte and build up
			// the Response
			int nextChar;
			while ((nextChar = inputStr.read()) > -1) {
				sb = sb.append((char) nextChar);
			}
			System.out.println("Return String: " + sb);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
