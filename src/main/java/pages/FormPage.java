package pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormPage {

    @FindBy(xpath = "//SPAN[@ng-click='save()'][text()='Продолжить']")
    WebElement GoButton;

    @FindBy(name = "insured0_surname")
    public WebElement insuredSurname;

    @FindBy(name = "insured0_name")
    public WebElement insuredName;

    @FindBy(name = "insured0_birthDate")
    public WebElement insuredBirthDate;

    @FindBy(name = "surname")
    public WebElement surname;

    @FindBy(name = "name")
    public WebElement name;

    @FindBy(name = "middlename")
    public WebElement middlename;

    @FindBy(name = "birthDate")
    public WebElement birthDate;

    @FindBy(name = "passport_series")
    public WebElement passportSeries;

    @FindBy(name = "passport_number")
    public WebElement passportNumber;

    @FindBy(name = "issueDate")
    public WebElement issueDate;

    @FindBy(name = "issuePlace")
    public WebElement issuePlace;


    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(GoButton));
    }

    public void fillField(String fildName, String value) {
        switch (fildName) {
            case "Фамилия застрахованного":
                fillField(insuredSurname, value);
                break;
            case "Имя застрахованного":
                fillField(insuredName, value);
                break;
            case "Дата рождения застрахованного":
                fillField(insuredBirthDate, value);
                break;
            case "Фамилия":
                fillField(surname, value);
                break;
            case "Имя":
                fillField(name, value);
                break;
            case "Отчество":
                fillField(middlename, value);
                break;
            case "Дата рождения":
                fillField(birthDate, value);
                break;
            case "Серия паспорта":
                fillField(passportSeries, value);
                break;
            case "Номер паспорта":
                fillField(passportNumber, value);
                break;
            case "Дата выдачи паспорта":
                fillField(issueDate, value);
                break;
            case "Кем выдан":
                fillField(issuePlace, value);
                break;
            default:
                throw new AssertionError("Поле '" + fildName + "' отсутствует на странице");
        }
    }

    protected void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }
    public void ClickGoButton() {
        GoButton.click();}


}
