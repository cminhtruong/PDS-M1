package metier.webapp.action;

import org.apache.log4j.Logger;

import metier.webapp.persistence.xml.LogoutCheck;
import metier.webapp.persistence.xml.User;
import metier.webapp.presentation.xml.LogoutSend;

/**
 * @category Logout
 * @author TRUONG Cong Minh
 * @version 2.1
 * @since JVM 1.7
 * @since 2015/02/14
 * @see <br> Logout action
 */
public class Logout {
	private 	static Logger 	LOG 	= 	Logger.getLogger(Logout.class);

	/**
	 * <br>
	 * The method allows to create a new XML message to sent to persistence
	 * 
	 * @param send
	 * @return
	 */
	public LogoutCheck presentationToPersistence(LogoutSend send) {
		LogoutCheck 			check 	= 	new LogoutCheck();
		
		// Date logout
		check.setDateLogout(send.getDateLogoutSend());
		LOG.info("Date logout: " + send.getDateLogoutSend());
		User 					user 	= 	new User();
		
		// User id
		user.setId(send.getUser().getId());
		LOG.info("User ID: " + send.getUser().getId());
		
		// Pseudo
		user.setPseudo(send.getUser().getPseudo());
		LOG.info("Pseudo: " + send.getUser().getPseudo());
		
		// Password
		user.setPassword(send.getUser().getPassword());
		LOG.info("Password: " + send.getUser().getPassword());
		check.setUser(user);
		return check;
	}
}
