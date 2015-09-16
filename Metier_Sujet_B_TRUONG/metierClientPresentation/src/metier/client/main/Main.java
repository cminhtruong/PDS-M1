package metier.client.main;

import org.apache.log4j.Logger;

import metier.client.presentation.jms.JMSListener;

/**
 * @category Main
 * @author TRUONG Cong Minh
 * @version 2.1
 * @since JVM 1.7
 * @since 2015/02/14
 * @see <br> The connection between Presentation Client and the first Web Application
 */
public class Main {
	private static Logger LOG = Logger.getLogger(Main.class);
	public static void main(String [] args){
		LOG.info("Hey! The client from presentation sends a message ...");
		JMSListener listener = new JMSListener();
		listener.start();
	}
	
	
}
