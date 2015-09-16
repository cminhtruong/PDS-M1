package metier.webapp.action;

import org.apache.log4j.Logger;

import metier.webapp.persistence.xml.CreateTestCheck;
import metier.webapp.persistence.xml.Test;
import metier.webapp.persistence.xml.User;
import metier.webapp.presentation.xml.CreateTestSend;

/**
 * @category Create
 * @author TRUONG Cong Minh
 * @version 2.1
 * @since JVM 1.7
 * @since 2015/02/14
 * @see <br> Create action
 */

public class Create {
	private 	static Logger 	LOG 	= 	Logger.getLogger(Create.class);

	/**
	 * <br> The method allows to convert all data from type Send to Check
	 * @param send
	 * @return
	 */
	public CreateTestCheck presentationToPersistence(CreateTestSend send) {
		CreateTestCheck 	check 		= 	new CreateTestCheck();
		User 				user 		= 	new User();
		Test 				test 		= 	new Test();
		
		// Date create
		check.setDateCreateCheck(send.getDateCreateSend());
		LOG.info("Date create test: " + send.getDateCreateSend());
		
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
		LOG.info("Test id: " + send.getTest().getIdTest());
		
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
