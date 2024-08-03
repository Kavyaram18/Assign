package FitPeo_Tech_CodeChallenge;

import Webdriver_launch.commonutlis;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Assignment {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = commonutlis.browserlaunch("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //Task -- Question 1 (Navigate to the FitPeo Homepage)
        driver.get("https://www.fitpeo.com");
        Thread.sleep(3000);
        // Question 2 (Navigate to the Revenue Calculator Page)
        driver.navigate().to("https://www.fitpeo.com/revenue-calculator");

        //Question 3 (Scroll Down to the Slider section)
        //WebElement sliderSection = driver.findElement(By.xpath("//div[@class='MuiBox-root css-j7qwjs']/span[1]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
        Thread.sleep(3000);

        //Question 4 (Adjust the Slider)
        WebElement slider = driver.findElement(By.xpath("//div[@class='MuiBox-root css-j7qwjs']/span[1]/span[3]/input"));
        System.out.println("Current Location of Slider Before Moving : " + slider.getLocation());
        Actions action = new Actions(driver);// (x,y = 779,654)
        action.dragAndDropBy(slider, 820, 654).perform();
        Thread.sleep(2000);
        System.out.println("Current Location of Slider After Moving : " + slider.getLocation());

        //Question 5 : Update the Text Field:
         int Textvalue = 560;
         WebElement Textfield = driver.findElement(By.xpath("//div[@class='MuiBox-root css-j7qwjs']/div/div/input"));
         Textfield.sendKeys(String.valueOf(Textvalue));
         Thread.sleep(2000);

         //Question 6 : Validate the Text Field:
         Textfield.getAttribute("value");
         assert Textvalue == Integer.parseInt(Textfield.getAttribute("value"));
        js.executeScript("window.scrollBy(0,400)");
        Thread.sleep(3000);

        //Question 7 : Select CPT Codes
        driver.findElement(By.xpath("(//div[@class='MuiBox-root css-4o8pys']/label/span/input)[1]")).click();
        driver.findElement(By.xpath("(//div[@class='MuiBox-root css-4o8pys']/label/span/input)[2]")).click();
        driver.findElement(By.xpath("(//div[@class='MuiBox-root css-4o8pys']/label/span/input)[3]")).click();
        driver.findElement(By.xpath("(//div[@class='MuiBox-root css-4o8pys']/label/span/input)[8]")).click();

        //Question 8 : Validate Total Recurring Reimbursement:
        String Total_Recurring = driver.findElement(By.xpath("(//div[@class='MuiBox-root css-4o8pys']/label/span/input)[8]")).getText();
        System.out.println("Total Recurring is : " + Total_Recurring);

        // Question 9 : Verifying  Total Recurring Reimbursement:
        if(Total_Recurring.equals("$75600")){
            System.out.println("Total Recurring is : " + Total_Recurring);
        }
        else{
            System.out.println("Total Recurring is not equal to given value which is  : " + Total_Recurring);
        }




    }
}
