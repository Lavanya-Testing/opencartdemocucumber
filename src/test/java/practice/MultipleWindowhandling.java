package practice;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowhandling {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		Thread.sleep(3000);
		driver.get("https://www.pepperfry.com/");
        WebElement module= driver.findElement(By.xpath("//p[text()='Partner With Us']/parent::div"));
        List<WebElement> allLinks=module.findElements(By.tagName("div"));
        System.out.println(allLinks.size());
        Iterator<WebElement> it=allLinks.iterator();
        while(it.hasNext())
        {
        	System.out.println(it.next().getText());
        }
        driver.quit();
        
	}

}
