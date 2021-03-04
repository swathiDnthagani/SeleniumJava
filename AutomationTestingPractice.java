package day16;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationTestingPractice {
	
	public static void main(String[] args) throws InterruptedException {
		
		
			// TODO Auto-generated method stub
			//1) Open Web Browser
			System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
	        		
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().window().maximize();
		
			driver.get("https://testautomationpractice.blogspot.com/");
		
	
		
		/*Alert alertwindow = driver.switchTo().alert();
		System.out.println(alertwindow.getText());
		alertwindow.accept();
		*/
		
	
		driver.switchTo().frame("frame-one1434677811");		
		WebElement name= driver.findElement(By.name("RESULT_TextField-1"));
		
		name.sendKeys("Pandu");
		
		//RESULT_TextField-2
		
		driver.findElement(By.id("RESULT_TextField-2")).sendKeys("D");
		driver.findElement(By.id("RESULT_TextField-3")).sendKeys("99990000");
		driver.findElement(By.id("RESULT_TextField-4")).sendKeys("DK");
		driver.findElement(By.id("RESULT_TextField-5")).sendKeys("CPH");
		driver.findElement(By.id("RESULT_TextField-6")).sendKeys("S@gmail.com");
		
		
		//RESULT_RadioButton-7_0
		WebElement femail_radio_bt = driver.findElement(By.id("RESULT_RadioButton-7_1"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()",femail_radio_bt );
		
		//tagname[@attribute='value']
		//
		List <WebElement> days = driver.findElements(By.xpath("//input[contains(@type,'check')]"));
		for(WebElement day : days)
			jse.executeScript("arguments[0].click()",day);
		
		WebElement drp_time = driver.findElement(By.id("RESULT_RadioButton-9"));		
		Select drp = new Select(drp_time);
		drp.selectByVisibleText("Evening");
		
		driver.switchTo().defaultContent();
		
		//Alert
		Alert alertwindow= driver.switchTo().alert();
		alertwindow.getText();
		alertwindow.accept();
		
		
		/*****
		 * 1) search for a string then find out how many links displayed
		2) Click on each link
		3) switch to each browser window then capture titles
		4) close specific browser windows
		 */
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links);
		for (WebElement link : links) {
			link.click();
			Thread.sleep(5000);
			
		}
			
	
		//***********Search
    	driver.findElement(By.xpath("//*[@id=\'Wikipedia1_wikipedia-search-input\']")).sendKeys("Testing");;
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		List<WebElement> search_result= driver.findElements(By.xpath("//div[@id='Wikipedia1_wikipedia-search-results']//div/a"));
		System.out.println("search_result size: " + search_result.size());
		
		for (WebElement search_link : search_result) {
			search_link.click();
					
		}
		String parent_window = driver.getWindowHandle();
		Set<String> window_ids=driver.getWindowHandles();
		for (String window_id : window_ids) {
			String title= driver.switchTo().window(window_id).getTitle();
			System.out.println(title);
		}
		if (driver.getTitle() == "Testing effect - Wikipedia"   )
			driver.close();
		
		driver.switchTo().window(parent_window);
		
	List<WebElement> table_row = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr"));
		for (WebElement r : table_row)
			System.out.println("table_row : " + r);
		
		System.out.println("table_row : " + table_row.size());
		
		int table_col = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr/th")).size();
		System.out.println("table_col : " + table_col);
		
		
		
		
	}
 
}
