package metier.client.persistence.connection;


import java.io.BufferedWriter;

import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;

/**
 * @category HttpConnection
 * @author TRUONG Cong Minh
 * @version 2.1
 * @since JVM 1.7
 * @since 2015/02/14
 * @see <br>Http Connect between Persistence Client and Web App
 */

public class HttpConnection implements Serializable {

	/**
	 * @see Class attributes
	 */
	private 	static Logger 				LOG 				= Logger.getLogger(HttpConnection.class);
	private 	static final long 			serialVersionUID 	= 1L;
	protected 	String 						to;
	protected 	String 						from;
	protected 	Object 						object;
	protected 	HashMap<String, String> 	map 				= new HashMap<String, String>();
	protected 	int 						i 					= 0;
	protected 	URL 						url;
	protected 	HttpURLConnection 			connection;
	protected 	ResourceBundle 				bundle 				= ResourceBundle.getBundle("config");
	
	/**
	 * @see HttpConnection 
	 * 		Create a connection between clientPersistence's
	 *      project and metierWebApp's project. This connection allows to link
	 *      two project and transfers objects
	 */
	public HttpConnection() {
		
	}
	
	/**
	 * @category Initialize Connection
	 * @see <br>To create a connection between client and web application
	 * @param urlWebApp
	 * @param message
	 * @throws MalformedURLException
	 * 
	 */
	public void initConnection(String urlWebApp, Object message) throws MalformedURLException{
		LOG.info("Create a connection to web app ...");
		url 	= 	new URL(urlWebApp);
		object 	= 	message;
	}
	
	/**
	 * @category sendMessage 
	 * @see <br>Send message from client persistence to the 2nd web application
	 * @param method
	 */
	public void sendMessageToWebApp(String method){
		LOG.info("Sending a message to web application with the method " + method);
		try {
			connection 					= 	(HttpURLConnection) url.openConnection();
			connection.setRequestMethod(method);
			connection.setDefaultUseCaches(false);
			connection.setDoInput(true);
			connection.setDoOutput(true);
			LOG.info("Message sending ... ");
			String from = "persistence";
			try {
				// Read messages
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
						connection.getOutputStream()));
				bw.write(from + "\n");
				bw.write(object.toString());
				bw.flush();
				bw.close();
				LOG.info("Send was sending");
				connection.getInputStream();
			} catch (Exception e) {
				LOG.info("Send KO");
				e.printStackTrace();
			}
		} catch (Exception ex) {
			LOG.info("Sending failed ...");
			ex.printStackTrace();
		} finally {
			connection.disconnect();
		}
	}
}
