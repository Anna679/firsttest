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
    WebElement Minimal;
    @FindBy (xpath = "//*[contains(text(),'Оформить')]")
    WebElement ChoiceButton;
    WebDriver driver;

   public ChoiceInsurancePage(WebDriver driver){
       this.driver=driver;
     PageFactory.initElements(driver, this);
      Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000);
     wait.until(ExpectedConditions.visibilityOf(Minimal));
      wait.until(ExpectedConditions.visibilityOf(ChoiceButton));
  }

        public void selectInsurance (String menuItem){
        Minimal.findElement(By.xpath("//*[contains(text(),'"+menuItem+"')]")).click();
        }
        public void selectChoiceButton(){ChoiceButton.click();
        }
        public void NextWindow () {
       for (String winHandle : driver.getWindowHandles()) {
                if (!driver.getTitle().equals("Страхование путешественников")) {
                    driver.switchTo().window(winHandle);
                }
            }
        }
}
