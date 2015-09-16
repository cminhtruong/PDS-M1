package metier.webapp.action;

import org.apache.log4j.Logger;

import metier.webapp.persistence.xml.CreateTestVerify;
import metier.webapp.presentation.xml.Test;
import metier.webapp.presentation.xml.User;
import metier.webapp.presentation.xml.CreateTestReturn;
import metier.webapp.presentation.xml.Error;

/**
 * @category Create
 * @author TRUONG Cong Minh
 * @version 2.1
 * @since JVM 1.7
 * @since 2015/02/14
 * @see <br> Create action
 */
public class Create {

	private 	static Logger 	LOG 	= Logger.getLogger(Create.class);
	
	/**
	 * <br> The method allows to transfer the message content to presentation
	 * @param verify
	 * @return
	 */
	public CreateTestReturn presentationToPersistence(CreateTestVerify verify) {
		CreateTestReturn 	returne 	= new CreateTestReturn();
		User 				user 		= new User();
		Test 				test 		= new Test();
		Error 				error 		= new Error();
		
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
		
		// Test ID
		test.setIdTest(verify.getTest().getIdTest());
		LOG.info("ID Test: " + verify.getTest().getIdTest());
		
		// Test name
		test.setTestName(verify.getTest().getTestName());
		LOG.info("Test name: " + verify.getTest().getTestName());
		
		// Test content
		test.setAny(verify.getTest().getAny());
		LOG.info("Test content: " + verify.getTest().getAny());
		
		// Error
		error.setIsOk(verify.getError().isIsOk());
		error.setMessageError(verify.getError().getMessage());
		LOG.info("Message: " + verify.getError().getMessage());
		
		returne.setUser(user);
		returne.setTest(test);
		returne.setError(error);
		return returne;
	}

}
