package pages;
import Steps.BaseSteps;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class FormPage {

    @FindBy(xpath = "//*[contains(text(),'Продолжить')]")
    public WebElement GoButton;

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
        //(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(GoButton));
    }

    public FormPage() {

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
            case "Дата выдачи":
                fillField(issueDate, value);
                break;
            case "Кем выдан":
                fillField(issuePlace, value);
                break;
            default:
                throw new AssertionError("Поле '" + fildName + "' отсутствует на странице");
        }
    }
    public String getFillZnachenie(String fildName){
        switch (fildName){
            case "Фамилия застрахованного":
                return insuredSurname.getAttribute("value");
            case "Имя застрахованного":
                return insuredName.getAttribute("value");
            case "Дата рождения застрахованного":
                return insuredBirthDate.getAttribute("value");
            case "Фамилия":
                return surname.getAttribute("value");
            case "Имя":
                return name.getAttribute("value");
            case "Отчество":
                return middlename.getAttribute("value");
            case "Дата рождения":
                return birthDate.getAttribute("value");
            case "Серия паспорта":
                return passportSeries.getAttribute("value");
            case "Номер паспорта":
                return passportNumber.getAttribute("value");
            case "Дата выдачи":
                return issueDate.getAttribute("value");
            case "Кем выдан":
                return issuePlace.getAttribute("value");
        }
        throw new AssertionError("Поле не существует!");
    }
    protected void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }
    public void ClickGoButton() {
        GoButton=BaseSteps.getDriver().findElement(By.xpath("//*[contains(text(),'Продолжить')]"));
        (new WebDriverWait(BaseSteps.getDriver(), 10)).until(ExpectedConditions.elementToBeClickable(GoButton));
        if (GoButton==null)
            System.out.println("Кнопки нет");
        GoButton.click();}

    public void checkErrorMessage(String errorMessage){
        WebElement erorMessage=BaseSteps.getDriver().findElement(By.xpath("//div [text()='Заполнены не все обязательные поля']"));
        (new WebDriverWait(BaseSteps.getDriver(), 10)).until(ExpectedConditions.elementToBeClickable(erorMessage));
        if (erorMessage==null)
            System.out.println("ошибки нет");
        String alertText = erorMessage.getText();
        System.out.println(alertText);
        assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", alertText, errorMessage),alertText.equals(errorMessage));
    }


}
