package metier.webapp.action;

import org.apache.log4j.Logger;

import metier.webapp.persistence.xml.LogoutVerify;
import metier.webapp.presentation.xml.Error;
import metier.webapp.presentation.xml.LogoutReturn;

/**
 * @category Logout
 * @author TRUONG Cong Minh
 * @version 2.1
 * @since JVM 1.7
 * @since 2015/02/14
 * @see <br> Logout action
 */

public class Logout {
	private 	static Logger 	LOG 	= Logger.getLogger(Logout.class);

	/**
	 * <br> The method allows to transfer the message content to presentation
	 * @param verify
	 * @return
	 */
	public LogoutReturn presentationToPersistence(LogoutVerify verify) {
		LogoutReturn 			returne = new LogoutReturn();
		Error 					error 	= new Error();
		
		// Error
		error.setIsOk(verify.getError().isIsOk());
		error.setMessageError(verify.getError().getMessage());
		LOG.info("Message: " + verify.getError().getMessage());
		
		returne.setError(error);
		return returne;
	}

}
