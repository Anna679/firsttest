package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChoiceInsurancePage {

    @FindBy (xpath = "//*[contains(text(),'Минимальная')]")
    WebElement Minimal;
    @FindBy (xpath = "//*[contains(text(),'Оформить')]")
    WebElement ChoiceButton;

    public ChoiceInsurancePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000);
        wait.until(ExpectedConditions.visibilityOf(Minimal));
        wait.until(ExpectedConditions.visibilityOf(ChoiceButton));
    }

        public void selectInsurance (String menuItem){
        Minimal.findElement(By.xpath("//*[contains(text(),'"+menuItem+"')]")).click();
        }
        public void selectChoiceButton(){ChoiceButton.click();}

}
