package metier.client.presentation.jms;

import java.util.ResourceBundle;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import metier.client.presentation.connection.HttpConnection;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;

/**
 * @category JMSListener
 * @author TRUONG Cong Minh
 * @version 2.1
 * @since JVM 1.7
 * @since 2015/02/14
 * @see <br>JMSListener receives messages from presentation and sends to Web Application
 */
public class JMSListener extends Thread{
	private 	static Logger 		LOG 		= 	Logger.getLogger(JMSListener.class);
	protected 	Message 			message;
	protected 	ConnectionFactory 	connectionFactory;
	protected 	ResourceBundle 		bundle;
	protected 	HttpConnection 		httpPresentation;
	
	/**
	 * <br> Claim when the message received from presentation had been killed by Garbage Control
	 */
	protected void finalize(){
		LOG.info("MessageListener killed by GC.");
	}
	
	/**
	 * <br> Run method allows to send a message to the first web application
	 */
	public void run(){
		//Create a new connection
		httpPresentation 			= new HttpConnection();
		//Message started 
		LOG.info("JMSListener is starting");
		
		try {
			
			// Link the configuration
			bundle 					= ResourceBundle.getBundle("config");
			
			// Create a new connection factory
			connectionFactory = new ActiveMQConnectionFactory(bundle.getString("BROKER_URL"));
			
			// Create a new connection
			Connection connection 	= connectionFactory.createConnection();
			
			// Started a connection
			connection.start();
			
			// Create a new session
			Session session 		= connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			// Create a destination
			Destination destinationPresentation 	= 	session.createQueue(bundle.getString("QUEUE_I2M"));
			
			// Create a consumer
			MessageConsumer consumerPresentation 	= 	session.createConsumer(destinationPresentation);
			
			// All the process
			LOG.info("Waiting for a message ... ");
			
			// Loop
			while (true) {
				try {
					message = consumerPresentation.receive(1000);
					if(message instanceof TextMessage){
						LOG.info("Received a message from presentation ...");
						TextMessage msg 	= (TextMessage) message;
						LOG.info("The message from the presentation");
						String text = msg.getText();
						LOG.info("\r\n" + msg.getText());
						httpPresentation.initConnection(bundle.getString("URL_WEB_APP_IN"), text);
						httpPresentation.sendMessageToWebApp(bundle.getString("METHOD"));
						LOG.info("Message sent to web app ...");
					}

				} catch (Exception e) {
					LOG.error("While loop is not exiting because of error "
									+ e.getMessage(), e);
					break;
				}
			}
			LOG.info("Ending the loop ...");
			
			// Ended the loop
			consumerPresentation.close();
			session.close();
			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Method to display the message when the JMS has gotten a problem.
	 * <br>Shutting down the client.
	 * 
	 * @param ex
	 */
	public synchronized void onException(JMSException ex) {
		LOG.info("JMS Exception occured. Shutting down client");
	}
	
}
