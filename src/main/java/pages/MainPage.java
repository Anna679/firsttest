package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {


    @FindBy (xpath = "(//div[@class='sbrf-div-list-inner --area bp-area header-container']//ul[@class='alt-menu-mid__list']//li//a[@aria-label='Раздел Застраховать себя  и имущество'])")
    WebElement mainMenu;
    @FindBy(xpath = "//div[contains(@class,'header_more_nav')]")
    WebElement subMenu;
    public Wait<WebDriver> wait;

    public void selectMeinMenu(String menuItem){

        mainMenu.findElement(By.xpath(".//SPAN[@class='multiline']//SPAN[text()='"+menuItem+"']")).click();

    }
    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, 5, 1000);
    }
    public void selectSubMenu (String menuItem){
        wait.until(ExpectedConditions.elementToBeClickable(
        subMenu.findElement(By.xpath(".//a[contains(text(),'"+menuItem+"')]")))).click();

    }
}
