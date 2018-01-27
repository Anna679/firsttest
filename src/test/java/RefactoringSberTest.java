import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.ChoiceInsurancePage;
import pages.FormPage;
import pages.MainPage;
import pages.StrahovaniePage;
import static org.junit.Assert.assertEquals;

public class RefactoringSberTest extends BaseTest {

   @Test
    public void newSberTest (){
         MainPage  mainPage =new MainPage(driver);
         mainPage.selectMeinMenu("Раздел Застраховать себя  и имущество");
         mainPage.selectSubMenu("Страхование путешественников");

         new StrahovaniePage(driver).IMGButton.click();

         ChoiceInsurancePage choiceInsurancePage=new ChoiceInsurancePage(driver);
         choiceInsurancePage.selectInsurance("Минимальная");
         choiceInsurancePage.selectChoiceButton();

        FormPage formPage =new FormPage(driver);
        formPage.fillField("Фамилия застрахованного", "Petrov");
        formPage.fillField("Имя застрахованного", "Petr");
        formPage.fillField("Дата рождения застрахованного", "01.01.1990");
        formPage.fillField("Фамилия", "Иванов");
        formPage.fillField("Имя", "Иван");
        formPage.fillField("Отчество", "Иванович");
        formPage.fillField("Дата рождения", "01.01.1990");
        formPage.fillField("Серия", "4515");
        formPage.fillField("Номер", "111111");
        formPage.fillField("Дата выдачи", "01.01.2004");
        formPage.fillField("Кем выдан", "Москва");


        assertEquals("Petrov", formPage.insuredSurname.getAttribute("value"));
        assertEquals("Petr", formPage.insuredName.getAttribute("value"));
        assertEquals("01.01.1988", formPage.insuredBirthDate.getAttribute("value"));

        assertEquals("Иванов", formPage.surname.getAttribute("value"));
        assertEquals("Иван", formPage.name.getAttribute("value"));
        assertEquals("Иванович", formPage.middlename.getAttribute("value"));
        assertEquals("4515", formPage.passportSeries.getAttribute("value"));
        assertEquals("111111", formPage.passportNumber.getAttribute("value"));
        assertEquals("01.01.2004", formPage.issueDate.getAttribute("value"));
        assertEquals("Москва", formPage.issuePlace.getAttribute("value"));

        formPage.ClickGoButton();

        Assert.assertEquals("Заполнены не все обязательные поля", driver.findElement(By.xpath("//DIV[@ng-show='tryNext && myForm.$invalid']")).getText());


    }

}
