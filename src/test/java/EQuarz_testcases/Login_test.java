package EQuarz_testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pom.EQuarz_Login;

public class Login_test extends TestBase {

	EQuarz_Login login;
	
	@BeforeMethod
	
	public void setup() {
		
		Intialization();
		EQuarz_Login login = new EQuarz_Login(driver);
		
	}
	
	@Test
	
	public void Loginverify() {
		
		login.dologin();
		String HomeURL = driver.getCurrentUrl();
		assertEquals("https://e-quarz.com/", HomeURL);
		
	}
	
	@AfterMethod
	
	public void teardown() {
		
		driver.close();
		
	}
	
	
}
