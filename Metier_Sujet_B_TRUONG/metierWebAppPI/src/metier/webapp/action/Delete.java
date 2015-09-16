package metier.webapp.action;

import org.apache.log4j.Logger;

import metier.webapp.persistence.xml.DeleteTestVerify;
import metier.webapp.presentation.xml.DeleteTestReturn;
import metier.webapp.presentation.xml.User;
import metier.webapp.presentation.xml.Error;

/**
 * @category Delete
 * @author TRUONG Cong Minh
 * @version 2.1
 * @since JVM 1.7
 * @since 2015/02/14
 * @see <br> Delete action
 */
public class Delete {

	private 	static Logger 	LOG 	= Logger.getLogger(Delete.class);
	
	/**
	 * <br> The method allows to transfer the message content to presentation
	 * @param verify
	 * @return
	 */
	public DeleteTestReturn presentationToPersistence(DeleteTestVerify verify) {
		DeleteTestReturn 		returne = new DeleteTestReturn();
		User 					user 	= new User();
		Error 					error 	= new Error();
		
		// ID Session
		returne.setIdSession(verify.getIdSession());
		LOG.info("ID Session: " + verify.getIdSession());
		
		// User ID
		user.setId(verify.getUser().getId());
		LOG.info("ID User: " + verify.getUser().getId());
		
		// Pseudo
		user.setPseudo(verify.getUser().getPseudo());
		LOG.info("Pseudo: " + verify.getUser().getPseudo());
		
		// Password
		user.setPassword(verify.getUser().getPassword());
		LOG.info("Password: " + verify.getUser().getPassword());
		
		// Error
		error.setIsOk(verify.getError().isIsOk());
		error.setMessageError(verify.getError().getMessage());
		LOG.info("Message: " + verify.getError().getMessage());
		
		returne.setUser(user);
		returne.setError(error);
		return returne;
	}

}
