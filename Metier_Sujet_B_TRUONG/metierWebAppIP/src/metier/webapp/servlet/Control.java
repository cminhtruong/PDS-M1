package metier.webapp.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.webapp.action.Treatment;
import metier.webapp.jms.persistence.JMSSenderPersistence;

import com.sun.istack.internal.logging.Logger;

/**
 * <br> Servlet implementation class Control
 * @author Davide
 * @version 2.1
 * @since JVM 1.7
 * @since 2015/02/14
 * @see <br>The servlet control the message from presentation and send the new message to persistence
 */

public class Control extends HttpServlet implements Serializable {
	private 	static Logger 			LOG 				= Logger.getLogger(Control.class);
	private 	static final long 		serialVersionUID 	= 1L;
	public 		Map<String, Object> 	infosMessages;
	public 		ResourceBundle 			rb;

	/**
	 * @see HttpServlet#HttpServlet()
	 * <br> Start the web application
	 */
	public Control() {
		super();
		LOG.info("The First web application is starting");
	}

	
	/**
	 * <br>Finalize to show the message which is killed by Garbage Control
	 * 
	 * @see finalize
	 */
	@Override
	protected void finalize() throws Throwable {
		LOG.info("Servlet killed by GC.");
		super.finalize();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 * <br> Initialize the servlet
	 */
	public void init(ServletConfig config) throws ServletException {

	}

	/**
	 * The service which controls the message from presentation by treatment all
	 * data and send it to persistence. Analyze all the code XML come from
	 * presentation and create some new code which sends to persistence
	 * 
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		LOG.info("Waiting please for the message from presentation .....");
		rb 									= 	ResourceBundle.getBundle("config");

		ServletInputStream 	sis 			= 	request.getInputStream();
		// Read message
		BufferedReader	 	br 				= 	new BufferedReader(new InputStreamReader(sis));

		// Show the message in the console
		ArrayList<String> 	listMessage 	= 	new ArrayList<String>();
		String 				line;
		
		while ((line = br.readLine()) != null) {
			listMessage.add(line);
		}
		if (listMessage.size() < 2)
			return;

		String from = listMessage.get(0);
		String message = "";

		for (int i = 1; i < listMessage.size(); i++) {
			message += listMessage.get(i) + " ";
		}
		
		LOG.info("From		: " + from);
		LOG.info("Message     	: " + message);

		if (from != null) {
			LOG.info("Starting decode the message ...");
			infosMessages 			= 	Treatment.decodeObject(message, from, rb.getString("URL_PERSISTENCE"));
			LOG.info("The end of decode");
			JMSSenderPersistence 	sender 		= 	new JMSSenderPersistence(rb.getString("URL_PERSISTENCE"));
			sender.sending(infosMessages.get("objet"));
			LOG.info("Message was sending to persistence ...");
		}
	}
}
