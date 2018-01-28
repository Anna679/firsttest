package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    @FindBy (xpath = "(//div[@class='sbrf-div-list-inner --area bp-area header-container']//ul[@class='alt-menu-mid__list']//li//a[@aria-label='Раздел Застраховать себя  и имущество'])")
    WebElement mainMenu;
    @FindBy(xpath = "//div[contains(@class,'header_more_nav')]")
    WebElement subMenu;
    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void selectMeinMenu(String menuItem){

        mainMenu.findElement(By.xpath(".//SPAN[@class='multiline']//SPAN[text()='"+menuItem+"']")).click();

    }
    public void selectSubMenu (String menuItem){
        subMenu.findElement(By.xpath(".//a[contains(text(),'"+menuItem+"')]")).click();

    }
}
