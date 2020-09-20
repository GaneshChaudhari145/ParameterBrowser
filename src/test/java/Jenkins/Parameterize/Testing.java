package Jenkins.Parameterize;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testing extends TestBase{
	
	

	@BeforeTest
	public void setUp() throws IOException
	{
		initialization();
	}

	@Test
	public void test1() throws InterruptedException
	{
		String title=driver.getTitle();
		Assert.assertEquals(title, "OrangeHRM");
		System.out.println(title);
	}

	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
