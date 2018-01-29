import Steps.BaseSteps;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.ChoiceInsurancePage;
import pages.FormPage;
import pages.MainPage;
import pages.StrahovaniePage;


import static org.junit.Assert.assertEquals;

public class RefactoringSberTest extends BaseSteps {


   @Test


    public void newSberTest (){
         MainPage  mainPage =new MainPage(driver);
         mainPage.selectMeinMenu("Застраховать себя ");
         mainPage.selectSubMenu("Страхование путешественников");
         new StrahovaniePage(driver).IMGButton.click();

       try {
           Thread.sleep(10000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       for (String winHandle : driver.getWindowHandles()) {
           if(winHandle.equals(driver.getWindowHandle())) {
               System.out.println(driver.getTitle());
               continue;
           }

           if (!driver.getTitle().equals("Сбербанк страхование")) {

               System.out.println("tab needed found!!!!");
               driver.switchTo().window(winHandle);
               System.out.println(driver.getTitle());
               break;
           }

       }

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
        formPage.fillField("Серия паспорта", "4515");
        formPage.fillField("Номер паспорта", "111111");
        formPage.fillField("Дата выдачи", "01.01.2004");
        formPage.fillField("Кем выдан", "Москва");


        assertEquals("Petrov", formPage.insuredSurname.getAttribute("value"));
        assertEquals("Petr", formPage.insuredName.getAttribute("value"));
        assertEquals("01.01.1990", formPage.insuredBirthDate.getAttribute("value"));

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
