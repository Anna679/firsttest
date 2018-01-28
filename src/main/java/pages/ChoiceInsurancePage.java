package pages;

import Steps.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Title;


public class ChoiceInsurancePage {

    @FindBy (xpath = "//*[contains(text(),'Минимальная')]")
    //@FindBy(xpath = "//div[@class='b-form-box-title ng-binding' and text()='Минимальная']")
    WebElement Minimal;
    @FindBy (xpath = "//*[contains(text(),'Оформить')]")
    WebElement ChoiceButton;
    WebDriver driver;
    public Wait<WebDriver> wait;
   public ChoiceInsurancePage(WebDriver driver){
       this.driver=driver;
     PageFactory.initElements(driver, this);
     wait = new WebDriverWait(driver, 5, 1000);
     wait.until(ExpectedConditions.visibilityOf(Minimal));
      wait.until(ExpectedConditions.visibilityOf(ChoiceButton));
  }

        public void selectInsurance (String menuItem){
        //Minimal.findElement(By.xpath("//*[contains(text(),'"+menuItem+"')]")).click();


            wait.until(ExpectedConditions.elementToBeClickable(

            Minimal.findElement(By.xpath("//*[contains(text(),'"+menuItem+"')]")))).click();
        ////
        }
        public void selectChoiceButton(){ChoiceButton.click();
        }
        public void NextWindow () {
       for (String winHandle : driver.getWindowHandles()) {
                if (driver.getTitle().equals("Сбербанк страхование")) {
                    driver.switchTo().window(winHandle);
                    break;
                }
            }
        }
}
