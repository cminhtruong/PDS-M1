package metier.webapp.action;

import org.apache.log4j.Logger;

import metier.webapp.presentation.xml.*;
import metier.webapp.persistence.xml.*;

/**
 * @category Login 
 * @author TRUONG Cong Minh
 * @version 2.1
 * @since JVM 1.7
 * @since 2015/02/14
 * @see <br>This class allows to convert all data when the client login
 */

public class Login {

	private 	static Logger 	LOG 	= 	Logger.getLogger(Login.class);

	/**
	 * <br> The method allows to create a new XML message to sent to persistence
	 * @param send
	 * @return
	 */
	public LoginCheck presentation2persistence(LoginSend send) {
		LoginCheck 				check 	= 	new LoginCheck();
		
		// IP Login
		check.setIpLogin(send.getIpLogin());
		LOG.info("Ip Login of user: " + send.getIpLogin());
		
		// Pseudo
		check.setPseudo(send.getPseudo());
		LOG.info("Pseudo: " + send.getPseudo());
		
		// Password
		check.setPassword(send.getPassword());
		LOG.info("Password: "+ send.getPassword());
		return check;
	}

}
