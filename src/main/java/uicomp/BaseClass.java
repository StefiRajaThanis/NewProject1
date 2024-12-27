package uicomp;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class BaseClass {
		public static WebDriver driver;
		public static JavascriptExecutor js;
		public static Actions act;
		String parentWindowId;
		
		public static void browserLaunch(String browserType) {
			if(browserType.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}
			else if(browserType.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			}
			else if(browserType.equalsIgnoreCase("ie")) {
				driver = new InternetExplorerDriver();
			}
			else {
				System.out.println("Browser is invalid");
			}
			driver.manage().window().maximize();
			
		}
		
		public static void urlLaunch(String url) {
			driver.get(url);
		}
		
		public static void sendValues(WebElement element, String values) {
			element.sendKeys(values);
		}
		
		public static void clickButton(WebElement element) {
			element.click();
		}
		public static void gettext(WebElement element) {
			String text = element.getText();
			System.out.println(text);
			
		}
		public static void closewindow() {
			driver.close();
		}
		public static void quitallWindow() {
			driver.quit();
		}
		public static void refresh() {
			driver.navigate().refresh();
		}
		public static void isdisplayed(WebElement element) {
			boolean displayed = element.isDisplayed();
			System.out.println(displayed);
		}
		public static void isenabled(WebElement element) {
			boolean enabled = element.isEnabled();
			System.out.println(enabled);
		}
		public static void isselected(WebElement element) {
			boolean selected = element.isSelected();
			System.out.println(selected);
		}
		public static void gettitle() {
			String title = driver.getTitle();
			System.out.println(title);
		}
		public static void screenshot(String name) throws IOException {
			TakesScreenshot ts = (TakesScreenshot)driver;
		    File source = ts.getScreenshotAs(OutputType.FILE);
		    File dest = new File("E:\\Screenshot\\"+name+".png");
		    Files.copy(source, dest);
		}
		public static void dropdown(WebElement element, String by, String value) {
			Select s = new Select(element);
			switch(by.toLowerCase()) {
			
			case "index": 
				s.selectByIndex(Integer.parseInt(value));
				break;
			case "value":
				s.selectByValue(value);
				break;
			case "text":
				s.selectByVisibleText(value);
				break;
				default:
					throw new IllegalArgumentException("Select by is wrong:"+by);
			}	
		}
		public static void insertvaluesjsexecutor(WebElement element, String values) {
			js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].setAttribute('value', 'values')", element);
		}
		public static void getvaluesjsexecutor(WebElement element) {
			js.executeScript("arguments[0].getAttribute('value')", element);
		}
		public static void clickUsingjsexecutor(WebElement element) {
			js.executeScript("arguments[0].click()", element);	
		}
		public static void scrollUsingJsExecutor(WebElement element, int value1, int value2) {
			js.executeScript("window.scrollBy(value1, value2)");
		}
		public static void staticWait(int milliseconds) throws InterruptedException {
			Thread.sleep(milliseconds);
		}
		public static void implicitWait(int sec) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
		}
		public static void moveElementAction(WebElement element) {
			act = new Actions(driver);
			act.moveToElement(element).perform();
		}
		public static void rightClick(WebElement element) {
			act.contextClick(element).perform();
		}
		public static void doubleclick(WebElement element) {
			act.doubleClick(element).perform();
		}
		public static void framesSwitch(String by, int index, String idname, WebElement element) {
			switch(by.toLowerCase()) {
			case "index":
				driver.switchTo().frame(Integer.parseInt(idname));
				break;
			case "idname":
				driver.switchTo().frame(idname);
				break;
			case "element":
				driver.switchTo().frame(element);
				break;
				default:
					throw new IllegalArgumentException("Input is invalid: "+by);
			}
		}
		public static void parentWindow() {
			String parentWindowId = driver.getWindowHandle();
			System.out.println(parentWindowId);
		}
		public static void switchToParentWindow(String parentWindowId) {
			driver.switchTo().window(parentWindowId);
		}
		public static void allWindows() {
			Set<String> windowHandles = driver.getWindowHandles();
			System.out.println("All windows id: "+windowHandles);
		}
		public static void acceptAlert() {
			try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			}
			catch(Exception e) {
				System.out.println("No alert present Execption: "+e.getMessage());
			}
		}
		public static void dismissAlert() {
			try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
			}
			catch(Exception e) {
				System.out.println("No alert present Execption: "+e.getMessage());
			}
		}
		public static void promptTextalertAccept(String text) {
			try {
				Alert alert = driver.switchTo().alert();
				alert.sendKeys(text);
				alert.accept();
				}
				catch(Exception e) {
					System.out.println("No alert present Execption: "+e.getMessage());
				}
		}
		public static void promptTextalertDismiss(String text) {
			try {
				Alert alert = driver.switchTo().alert();
				alert.sendKeys(text);
				alert.dismiss();
				}
				catch(Exception e) {
					System.out.println("No alert present Execption: "+e.getMessage());
				}
		}
	}

