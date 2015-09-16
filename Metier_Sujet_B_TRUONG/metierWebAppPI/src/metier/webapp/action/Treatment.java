package metier.webapp.action;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import metier.webapp.persistence.xml.*;
import metier.webapp.presentation.xml.*;

/**
 * @category Treatment
 * @author Davide
 * @version 2.1
 * @since JVM 1.7
 * @since 2015/02/14
 * @see <br>
 *      Treatment all messages received from clients
 */

public class Treatment {
	private 	static Logger 				LOG 			= Logger.getLogger(Treatment.class);
	protected 	static Map<String, Object> 	infosMessages 	= new HashMap<String, Object>();

	/**
	 * <br> The method allows to treat all message received from persistence
	 * @param message
	 * @param from
	 * @return
	 */
	public static Map<String, Object> decodeObject(String message, String from, String urlServeur) {
		Map<String, Object> 	infosMessages 	= new HashMap<String, Object>();
		try {
			// Read a message
			StringReader 		reader 			= new StringReader(message);

			// Config
			ResourceBundle 		bundle 			= ResourceBundle.getBundle("config");

			// Take the context XML by JAXB
			JAXBContext 		context 		= JAXBContext.newInstance(bundle.getString("PACKAGE_PERS"));

			// Create a new decoder
			Unmarshaller 		unmarshaller 	= context.createUnmarshaller();

			// Decode the object
			Object 				object 			= unmarshaller.unmarshal(reader);
			// End a reader
			reader.close();

			/**
			 * If object is Login
			 */
			if (object instanceof LoginVerify) {
				LOG.info("Message is type Login");
				LoginVerify 	verify 	= (LoginVerify) object;
				Login 			login 	= new Login();
				LoginReturn 	returne = login.persistenceToPresentation(verify);
				infosMessages.put("objet", returne);
				infosMessages.put("user", returne.getUser());
				infosMessages.put("error", returne.getError());
				infosMessages.put("test", returne.getTest());

			}
			/**
			 * If object is Logout
			 */
			if (object instanceof LogoutVerify) {
				LOG.info("Message is type Logout");
				LogoutVerify 	verify 	= (LogoutVerify) object;
				Logout 			logout 	= new Logout();
				LogoutReturn 	returne = logout.presentationToPersistence(verify);
				infosMessages.put("objet", returne);
				infosMessages.put("error", returne.getError());
			}
			/**
			 * If object is Create
			 */
			if (object instanceof CreateTestVerify) {
				LOG.info("Message is type Create");
				CreateTestVerify 	verif 	= (CreateTestVerify) object;
				Create 				create 	= new Create();
				CreateTestReturn 	retur 	= create.presentationToPersistence(verif);
				infosMessages.put("objet", retur);
				infosMessages.put("idSession", retur.getIdSession());
				infosMessages.put("user", retur.getUser());
				infosMessages.put("test", retur.getTest());
				infosMessages.put("error", retur.getError());
			}
			/**
			 * If object is Read
			 */
			if (object instanceof ReadTestVerify) {
				LOG.info("Message is type Read");
				ReadTestVerify 		verif 	= (ReadTestVerify) object;
				Read 				lire 	= new Read();
				ReadTestReturn 		retur 	= lire.presentationToPersistence(verif);
				infosMessages.put("objet", retur);
				infosMessages.put("idSession", retur.getIdSession());
				infosMessages.put("user", retur.getUser());
				infosMessages.put("test", retur.getTest());
			}
			/**
			 * If object is Use
			 */
			if (object instanceof UseTestVerify) {
				LOG.info("Message is type Use");
				UseTestVerify 		verif 	= (UseTestVerify) object;
				Use 				use 	= new Use();
				UseTestReturn 		returne = use.presentationToPersistence(verif);
				infosMessages.put("objet", returne);
				infosMessages.put("idSession", returne.getIdSession());
				infosMessages.put("user", returne.getUser());
				infosMessages.put("test", returne.getTest());
			}
			/**
			 * If object is Delete
			 */
			if (object instanceof DeleteTestVerify) {
				LOG.info("Message is type Delete");
				DeleteTestVerify 	verif 	= (DeleteTestVerify) object;
				Delete 				delete 	= new Delete();
				DeleteTestReturn 	retur 	= delete.presentationToPersistence(verif);
				infosMessages.put("objet", retur);
				infosMessages.put("idSession", retur.getIdSession());
				infosMessages.put("user", retur.getUser());
				infosMessages.put("error", retur.getError());
			}

		} catch (Exception e) {
			LOG.error("Error treatment: " + e.getMessage());
		}
		return infosMessages;

	}
}
