package metier.webapp.jms;

import static javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ResourceBundle;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import metier.webapp.presentation.xml.CreateTestReturn;
import metier.webapp.presentation.xml.DeleteTestReturn;
import metier.webapp.presentation.xml.LoginReturn;
import metier.webapp.presentation.xml.LogoutReturn;
import metier.webapp.presentation.xml.ReadTestReturn;
import metier.webapp.presentation.xml.UseTestReturn;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;

/**
 * <br>JMS Sender allows to send a message XML to presentation
 * @author Davide
 * @version 2.1
 * @since JVM 1.7
 * @since 2015/02/14
 */

public class JMSSender {
	/**
	 * 
	 */
	private 	static Logger 		LOG 	= 	Logger.getLogger(JMSSender.class);
	protected 	MessageProducer 	producer;
	protected 	ResourceBundle 		bundle;
	protected 	Session 			session;
	protected 	ConnectionFactory 	connectFactory;
	protected 	Connection 			connection;
	protected 	String 				url;
	protected 	Destination 		destination;

	/**
	 * A contructor JMSSender
	 */
	public JMSSender(String urlPresentation) {

		try {
			url 			= 	urlPresentation;
			bundle 			= 	ResourceBundle.getBundle("config");
			
			// Create a connection factory
			connectFactory 	= new ActiveMQConnectionFactory(
					bundle.getString("URL_ACTIVEMQ"));
			
			// Create a new connection
			connection 		= connectFactory.createConnection();
			connection.start();

			// Create a new session
			session 		= connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			// Create a destination: Queue M2P
			destination 	= session.createQueue(bundle.getString("QUEUE_M2I"));

			// Create a new producer
			producer 		= session.createProducer(destination);
		} catch (Throwable e) {
			LOG.error("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * <br> The method allows to send the message to presentation
	 * @param objet
	 */
	public void SendFile(Object objet) {
		StringWriter 	writer 		= 	new StringWriter();
		JAXBContext 	context;
		Marshaller 		marshaller;
		SchemaFactory 	schemaFactory;
		File 			file;
		TextMessage 	message;

		try {
			// Create a new context with JAXB
			context 		= JAXBContext.newInstance(bundle.getString("PACKAGE_PRES"));
			// Create a new encoder 
			marshaller 		= context.createMarshaller();
			
			// Create a new schema factory
			schemaFactory 	= SchemaFactory.newInstance(W3C_XML_SCHEMA_NS_URI);
			
			// Create a new file
			file 			= new File(bundle.getString("XSD_PRESENTATION"));

			// Create a schema
			Schema schema 	= schemaFactory.newSchema(file);
			marshaller.setSchema(schema);
			
			/**
			 * <br> If the new object is Login 
			 */
			if (objet instanceof LoginReturn) {
				LoginReturn 	obj 	= (LoginReturn) objet;
				marshaller.marshal(obj, writer);
				writer.close();
				String 			contenu = writer.toString();
				LOG.info("XML Content: " + contenu);
				message 				= session.createTextMessage(contenu);
				this.producer.send(message);
				LOG.info("JMSSender finish the job");
				
			} 
			
			/**
			 * <br> If the new object is Login 
			 */
			if (objet instanceof LogoutReturn) {
				LogoutReturn 	obj 	= (LogoutReturn) objet;
				marshaller.marshal(obj, writer);
				writer.close();
				String 			contenu = writer.toString();
				LOG.info("XML Content: " + contenu);
				message 				= session.createTextMessage(contenu);
				this.producer.send(message);
				LOG.info("JMSSender finish the job");
				
			} 
			
			/**
			 * <br> If the new object is Login 
			 */
			if (objet instanceof CreateTestReturn) {
				CreateTestReturn 	obj = (CreateTestReturn) objet;
				marshaller.marshal(obj, writer);
				writer.close();
				String 			contenu = writer.toString();
				LOG.info("XML Content: " + contenu);
				message 				= session.createTextMessage(contenu);
				this.producer.send(message);
				LOG.info("JMSSender finish the job");
				
			} 
			
			/**
			 * <br> If the new object is Login 
			 */
			if (objet instanceof UseTestReturn) {
				UseTestReturn 		obj = (UseTestReturn) objet;
				marshaller.marshal(obj, writer);
				writer.close();
				String 			contenu = writer.toString();
				LOG.info("XML Content: " + contenu);
				message 				= session.createTextMessage(contenu);
				this.producer.send(message);
				LOG.info("JMSSender finish the job");
				
			} 
			
			/**
			 * <br> If the new object is Login 
			 */
			if (objet instanceof ReadTestReturn) {
				ReadTestReturn 		obj = (ReadTestReturn) objet;
				marshaller.marshal(obj, writer);
				writer.close();
				String 			contenu = writer.toString();
				LOG.info("XML Content: " + contenu);
				message 				= session.createTextMessage(contenu);
				this.producer.send(message);
				LOG.info("JMSSender finish the job");
				
			} 
			
			/**
			 * <br> If the new object is Login 
			 */
			if (objet instanceof DeleteTestReturn) {
				DeleteTestReturn 	obj = (DeleteTestReturn) objet;
				marshaller.marshal(obj, writer);
				writer.close();
				String 			contenu = writer.toString();
				LOG.info("XML Content: " + contenu);
				message 				= session.createTextMessage(contenu);
				this.producer.send(message);
				LOG.info("JMSSender finish the job");
				
			} 
			
			session.close();
			connection.close();

		} catch (JMSException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}
}
