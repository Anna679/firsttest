package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    @FindBy (xpath = "//div [@class='sbrf-div-list-inner --area bp-area header_more_nav']")
    WebElement mainMenu;
    @FindBy(xpath = "(//DIV[@class='alt-menu-collapser__area alt-menu-collapser__area_cols_3'])[4]")
    WebElement subMenu;
    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void selectMeinMenu(String menuItem){
        mainMenu.findElement(By.xpath(".//a[contains(@aria-label,'" + menuItem + "')]")).click();
        }
    public void selectSubMenu (String menuItem){
        subMenu.findElement(By.xpath(".//a[@href='" + menuItem + "']")).click();

    }
}
