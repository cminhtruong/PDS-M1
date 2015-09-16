package metier.webapp.action;

import java.io.StringReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import metier.webapp.persistence.xml.*;
import metier.webapp.presentation.xml.*;

/**
 * <br>
 * This class translates the message and convert all data. 
 * It will create a new message type Check.
 * @author TRUONG Cong Minh
 * @version 2.1
 * @since JVM 1.7
 * @since 2015/02/14
 * @see <br>
 *      Treatment all messages received from clients
 */

public class Treatment {

	private 	static Logger 	LOG 			= 	Logger.getLogger(Treatment.class);

	/**
	 * <br>
	 * The function allows to decode the message XML by type Map
	 * 
	 * @param message
	 * @param from
	 * @return
	 */
	public static Map<String, Object> decodeObject(String message, String from, String urlServeur) {
		Map<String, Object> 	infosMessages 	= 	new HashMap<String, Object>();
		try {

			// Read a message
			StringReader 		reader 			= 	new StringReader(message);

			// Configuration
			ResourceBundle 		bundle 			= 	ResourceBundle.getBundle("config");

			// Take the context XML by JAXB
			JAXBContext 		context 		= 	JAXBContext.newInstance(bundle.getString("PACKAGE_PRES"));

			// Create a new decoder
			Unmarshaller 		unmarshaller 	= 	context.createUnmarshaller();

			// Decode the object
			Object 				object 			= 	unmarshaller.unmarshal(reader);

			// End a reader
			reader.close();
			
			/**
			 * <br>
			 * If object is Login
			 */
			if (object instanceof LoginSend) {
				LOG.info("The message is type Login");
				LoginSend 		send 			= 	(LoginSend) object;
				Login 			login 			= 	new Login();
				LoginCheck 		check 			= 	login.presentation2persistence(send);
				check.setIdSession(new Date().getTime() + " ");
				infosMessages.put("objet", check);
				infosMessages.put("idSession", check.getIdSession());
				infosMessages.put("ipLogin", check.getIpLogin());
				infosMessages.put("pseudo", check.getPseudo());
				infosMessages.put("password", check.getPassword());

			}
			
			/**
			 * If object is Logout
			 */
			if (object instanceof LogoutSend) {
				LOG.info("The message is type Logout");
				LogoutSend 		send 			= 	(LogoutSend) object;
				Logout 			logout 			= 	new Logout();
				LogoutCheck 	check 			= 	logout.presentationToPersistence(send);
				infosMessages.put("objet", check);
				infosMessages.put("date", check.getDateLogout());
				infosMessages.put("user", check.getUser());
			}
			
			/**
			 * If object is Create
			 */
			if (object instanceof CreateTestSend) {
				LOG.info("The message is type Create");
				CreateTestSend 	send 			= 	(CreateTestSend) object;
				Create 			create 			= 	new Create();
				CreateTestCheck check 			= 	create.presentationToPersistence(send);
				infosMessages.put("objet", check);
				infosMessages.put("date", check.getDateCreateCheck());
				infosMessages.put("user", check.getUser());
				infosMessages.put("test", check.getTest());
			}
			
			/**
			 * If object is Read
			 */
			if (object instanceof ReadTestSend) {
				LOG.info("The message is type Read");
				ReadTestSend 	send 			= 	(ReadTestSend) object;
				Read 			lire 			= 	new Read();
				ReadTestCheck 	check 			= 	lire.presentationToPersistence(send);
				infosMessages.put("objet", check);
				infosMessages.put("date", check.getDateReadCheck());
				infosMessages.put("user", check.getUser());
				infosMessages.put("test", check.getTest());
			}
			
			/**
			 * If object is Use
			 */
			if (object instanceof UseTestSend) {
				LOG.info("The message is type Use");
				UseTestSend 	send 			= 	(UseTestSend) object;
				Use 			use 			= 	new Use();
				UseTestCheck 	check 			= 	use.presentationToPersistence(send);
				infosMessages.put("objet", check);
				infosMessages.put("date", check.getDateUseCheck());
				infosMessages.put("user", check.getUser());
				infosMessages.put("test", check.getTest());
			}
			/**
			 * If object is Delete
			 */
			if (object instanceof DeleteTestSend) {
				LOG.info("The message is type Delete");
				DeleteTestSend 	send 			= 	(DeleteTestSend) object;
				Delete 			delete 			= 	new Delete();
				DeleteTestCheck check 			= 	delete.presentationToPersistence(send);
				infosMessages.put("objet", check);
				infosMessages.put("date", check.getDateDeleteCheck());
				infosMessages.put("user", check.getUser());
				infosMessages.put("test", check.getTest());
			}

		} catch (Exception e) {
			LOG.error("Treatment has problem: " + e.getMessage());
		}
		return infosMessages;
	}
}
