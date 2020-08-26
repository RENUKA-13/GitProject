import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginScenario {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
 System.setProperty("webdriver.chrome.driver", "C:/chromedriver_win32/chromedriver.exe");
 WebDriver drive = new ChromeDriver();
 
 drive.get("http://jt-dev.azurewebsites.net/#/SignUp");
 drive.manage().window().maximize();
 drive.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
 
 WebElement dropDown = drive.findElement(By.xpath("//div[@id='language']//span[2]"));
 
 WebDriverWait wait1=new WebDriverWait(drive,10);
 wait1.until(ExpectedConditions.elementToBeClickable(dropDown));
 
 dropDown.click();
drive.findElement(By.xpath("//input[@placeholder='Choose Language']")).sendKeys("English");
// drive.findElement(By.xpath("//div[@id='language']//span[2]")).sendKeys("Dutch");

//Select language = new Select(dropDown);
//System.out.println(language.getFirstSelectedOption().getText());
//language.selectByValue("English");



 drive.findElement(By.xpath("//Input[@id='name']")).sendKeys("Renu");
 drive.findElement(By.xpath("//Input[@id='orgName']")).sendKeys("Maintec Technology");
drive.findElement(By.xpath("//input[@id='singUpEmail']")).sendKeys("imrenupatil@gmail.com");

drive.findElement(By.xpath("//span[contains(text(),'I agree to the')]")).isDisplayed();
drive.findElement(By.xpath("//span[contains(text(),'I agree to the')]")).isEnabled();
drive.findElement(By.xpath("//span[contains(text(),'I agree to the')]")).isSelected();
drive.findElement(By.xpath("//span[contains(text(),'I agree to the')]")).click();

try {
WebElement ele = drive.findElement(By.xpath("//button[@type='submit']")) ;
ele.click();
Alert alt = drive.switchTo().alert();

Thread.sleep(1000);
String StrngMsg = drive.switchTo().alert().getText();

System.out.println(StrngMsg);
alt.accept();
}
catch(NoAlertPresentException e){
	System.out.println(e.getMessage());
}

 drive.close();
	}

}
