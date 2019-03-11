package stepDefination;

import com.sephora.dmg.core.driver.SephoraDsgMobileDriver;
import com.sephora.dsg.pages.HomePage;
import com.sephora.dsg.pages.WelcomePage;

public class BaseDefination extends SephoraDsgMobileDriver {
	
	public WelcomePage welcomepage=new WelcomePage();
	
	public HomePage homepage = new HomePage();
	


}
