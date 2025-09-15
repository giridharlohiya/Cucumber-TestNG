package Pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

    public static void trial(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in");
        // ((ChromeDriver) driver).executeScript("window.open('https://www.google.com','_blank');");
    
        // String Parent = driver.getWindowHandle();
        // Set<String> windows = new LinkedHashSet<>();
        // windows = driver.getWindowHandles();

        // for(String win : windows){
        //     if(win.equals(Parent))
        //     {
        //         driver.switchTo().window(win);
        //     }
        // }

        Alert alert = driver.switchTo().alert();

        List<WebElement> links = driver.findElements(By.tagName("a"));
        for(WebElement link : links){
            System.out.println("Link - " +link.getAttribute("href"));
        }

        //Implicit Wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // waits max 10s for all elements
        //Explicit Wait
        WebDriverWait  wait = new WebDriverWait (driver, 20);
        WebElement element  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        element.click();
        //Fluent Wait
        Wait<WebDriver> fluentwait = new FluentWait<>(driver)
        .withTimeout(Duration.ofSeconds(30))
        .pollingEvery(Duration.ofSeconds(2))
        .ignoring(NoSuchElementException.class);

    }

    public static int factorial(int n){
        if(n<=1) return 1;
        return n * factorial(n-1);
    }
    public static String ReverseStringBuilder(String str){
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
    public static String ReverseWOStringBuilder(String str){
        
        String rev="";
        for(int i=str.length()-1;i>=0;i--){
            rev+=str.charAt(i);
        }
        return rev;
    }
    public static void main(String[] args) {
        String str1 = "(1) Selenium";
        String str2 = "madam";
        // str1 = str1 + str2; // str1 = "SeleniumCucumber"
        // str2 = str1.substring(0, str1.length() - str2.length());
        // str1 = str1.substring(str2.length()); // str1 = "Cucumber"
        String first = str1.substring(1,2);
        System.out.println("Wow - "+first);
        // System.out.println("str1 = " + str1);
        // System.out.println("str2 = " + str2);

        trial();

        System.out.println("ReverseWOStringBuilder - "+ReverseWOStringBuilder(str1));
        System.out.println("ReverseStringBuilder - "+ReverseStringBuilder(str1));
        String rev2 = "";
        for(int i = str2.length()-1; i>=0; i--){
            rev2+= str2.charAt(i);
        }
        System.out.println("rev2 - "+rev2);
        System.out.println("Palindron = "+str2.equals(rev2));

        System.out.println("Fact = "+factorial(5));
    
        String str = "QA Automation QA Testing Automation";
        Map<String,Integer> names = new HashMap<>();
        String[] words = str.split(" ");
        for(String word:words){
            if(names.containsKey(word))
            {
                int count = names.get(word);
                names.put(word,count+1);
            }
            else
                names.put(word,1);    
        }        
            System.out.println(names);
    
        Map<String,Integer> data = new HashMap<>();
        for(String nav:words)
        {
            data.put(nav, data.getOrDefault(nav,0)+1);
        }
        System.out.println(data);
    }
        
}
