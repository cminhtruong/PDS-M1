package metier.webapp.action;

import org.apache.log4j.Logger;

import metier.webapp.persistence.xml.ReadTestVerify;
import metier.webapp.presentation.xml.ReadTestReturn;
import metier.webapp.presentation.xml.Test;
import metier.webapp.presentation.xml.User;

/**
 * @category Read
 * @author TRUONG Cong Minh
 * @version 2.1
 * @since JVM 1.7
 * @since 2015/02/14
 * @see <br> Read action
 */
public class Read {
	private 	static Logger 	LOG		= Logger.getLogger(Read.class);
	
	/**
	 * <br> The method allows to transfer the message content to presentation
	 * @param verif
	 * @return
	 */
	public ReadTestReturn presentationToPersistence(ReadTestVerify verif) {
		ReadTestReturn 			retur 	= new ReadTestReturn();
		User 					user 	= new User();
		Test 					test 	= new Test();
		
		// Session id
		retur.setIdSession(verif.getIdSession());
		LOG.info("ID Session: " + verif.getIdSession());
		
		// User id
		user.setId(verif.getUser().getId());
		LOG.info("ID User: " + verif.getUser().getId());
		
		// Pseudo
		user.setPseudo(verif.getUser().getPseudo());
		LOG.info("Pseudo: " + verif.getUser().getPseudo());
		
		// Password
		user.setPassword(verif.getUser().getPassword());
		LOG.info("Password: " + verif.getUser().getPassword());
		
		// Test id
		test.setIdTest(verif.getTest().getIdTest());
		LOG.info("ID Test: " + verif.getTest().getIdTest());
		
		// Test name
		test.setTestName(verif.getTest().getTestName());
		LOG.info("Test name: " + verif.getTest().getTestName());
		
		// Test content
		test.setAny(verif.getTest().getAny());
		LOG.info("Test content: " + verif.getTest().getAny());
		
		retur.setUser(user);
		retur.setTest(test);
		return retur;
	}

}
