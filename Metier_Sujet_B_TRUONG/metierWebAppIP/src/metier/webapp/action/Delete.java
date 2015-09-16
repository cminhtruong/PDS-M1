package metier.webapp.action;

import org.apache.log4j.Logger;

import metier.webapp.persistence.xml.DeleteTestCheck;
import metier.webapp.persistence.xml.Test;
import metier.webapp.persistence.xml.User;
import metier.webapp.presentation.xml.DeleteTestSend;

/**
 * @category Delete
 * @author TRUONG Cong Minh
 * @version 2.1
 * @since JVM 1.7
 * @since 2015/02/14
 * @see <br> Delete action
 */
public class Delete {
	private 	static Logger 	LOG 	= 	Logger.getLogger(Delete.class);

	/**
	 * <br> The method allows to convert all data from Send to Check
	 * @param send
	 * @return
	 */
	public DeleteTestCheck presentationToPersistence(DeleteTestSend send) {
		DeleteTestCheck 		check 	= 	new DeleteTestCheck();
		User 					user 	= 	new User();
		Test 					test 	= 	new Test();
		
		// Date delete
		check.setDateDeleteCheck(send.getDateDeleteSend());
		LOG.info("Date delete: " + send.getDateDeleteSend());
		
		// User id
		user.setId(send.getUser().getId());
		LOG.info("User ID: " + send.getUser().getId());
		
		// Pseudo
		user.setPseudo(send.getUser().getPseudo());
		LOG.info("Pseudo: " + send.getUser().getPseudo());
		
		// Password
		user.setPassword(send.getUser().getPassword());
		LOG.info("Password: " + send.getUser().getPassword());
		
		// Test id
		test.setIdTest(send.getTest().getIdTest());
		LOG.info("Test ID: " + send.getTest().getIdTest());
		
		// Test name
		test.setTestName(send.getTest().getTestName());
		LOG.info("Test name: " + send.getTest().getTestName());
		
		// Test content
		test.setAny(send.getTest().getAny());
		LOG.info("Test content: " + send.getTest().getAny());
		check.setUser(user);
		check.setTest(test);
		return check;
	}
}
