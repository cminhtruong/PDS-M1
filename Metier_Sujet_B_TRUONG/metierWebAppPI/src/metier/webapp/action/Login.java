package metier.webapp.action;

import org.apache.log4j.Logger;

import metier.webapp.persistence.xml.LoginVerify;
import metier.webapp.presentation.xml.LoginReturn;
import metier.webapp.presentation.xml.Test;
import metier.webapp.presentation.xml.User;
import metier.webapp.presentation.xml.Error;

/**
 * @category Login
 * @author TRUONG Cong Minh
 * @version 2.1
 * @since JVM 1.7
 * @since 2015/02/14
 * @see <br> Login
 */

public class Login {
	private 	static Logger 	LOG 	= Logger.getLogger(Login.class);

	/**
	 * <br> The method allows to transfer the message content to presentation
	 * @param verify
	 * @return
	 */
	public LoginReturn persistenceToPresentation(LoginVerify verify) {
		LoginReturn 			returne = new LoginReturn();
		User 					user 	= new User();
		Error 					error 	= new Error();
		Test 					test 	= new Test();
		
		// User ID
		user.setId(verify.getUser().getId());
		LOG.info("User ID: " + verify.getUser().getId());
		
		// Pseudo
		user.setPseudo(verify.getUser().getPseudo());
		LOG.info("Pseudo: " + verify.getUser().getPseudo());
		
		// Password
		user.setPassword(verify.getUser().getPassword());
		LOG.info("Password: " + verify.getUser().getPassword());
		
		// Error
		error.setIsOk(verify.getError().isIsOk());
		error.setMessageError(verify.getError().getMessage());
		LOG.info("Error: " + verify.getError().getMessage());
		
		// Test id
		test.setIdTest(verify.getTest().getIdTest());
		LOG.info("Test id: " + verify.getTest().getIdTest());
		
		// Test name
		test.setTestName(verify.getTest().getTestName());
		LOG.info("Test name: " + verify.getTest().getTestName());
		
		// Test content
		test.setAny(verify.getTest().getAny());
		LOG.info("Test content: " + verify.getTest().getAny());
		
		returne.setUser(user);
		returne.setError(error);
		returne.setTest(test);
		return returne;
	}

}
