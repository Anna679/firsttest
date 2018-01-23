import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class SberTest  extends BaseTest{
    @Test
    @Ignore
    public void Sbermetod () {
        driver.get(baseUrl);
    //1
    driver.findElement(By.xpath("(//SPAN[@class='multiline'])[5]//SPAN[text()='Застраховать себя ']")).click();
    //2
    driver.findElement(By.xpath("//div[contains(@class,'bp-area header-container')]//a[contains(text(),'Страхование путешественников')]")).click();
    //3
        Assert.assertEquals("Страхование путешественников", driver.findElement(By.xpath("(//H1[text()='Страхование путешественников'])[1]")).getText());
    //4
        driver.findElement(By.xpath("//a//img[contains(@src,'banner-zashita-traveler')]")).click();

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    //5
        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[contains(text(),'Минимальная')]")))).click();
        driver.findElement(By.xpath("//*[contains(text(),'Минимальная')]")).click();
    //6
        driver.findElement(By.xpath("//*[contains(text(),'Оформить')]")).click();
    //7
        fillField(By.name("insured0_surname"), "Petrov");
        fillField(By.name("insured0_name"), "Petr");
        fillField(By.name("insured0_birthDate"), "01.01.1990");

        fillField(By.name("surname"), "Иванов");
        fillField(By.name("name"), "Иван");
        fillField(By.name("middlename"), "Иванович");
        fillField(By.name("birthDate"),"01.01.1990");
        fillField(By.name("passport_series"),"4515");
        fillField(By.name("passport_number"),"111111");
        fillField(By.name("issueDate"), "01.01.2004");
        fillField(By.name("issuePlace"), "Москва");
    //8
        Assert.assertEquals("Petrov", driver.findElement(By.xpath("//INPUT[@name='insured0_surname']")).getAttribute("value"));
        Assert.assertEquals("Petr", driver.findElement(By.xpath("//INPUT[@name='insured0_name']")).getAttribute("value"));
        Assert.assertEquals("01.01.1990", driver.findElement(By.name("insured0_birthDate")).getAttribute("value"));

        Assert.assertEquals("Иванов", driver.findElement(By.xpath("//INPUT[@name='surname']")).getAttribute("value"));
        Assert.assertEquals("Иван", driver.findElement(By.xpath("//INPUT[@name='name']")).getAttribute("value"));
        Assert.assertEquals("Иванович", driver.findElement(By.xpath("//INPUT[@name='middlename']")).getAttribute("value"));
        Assert.assertEquals("01.01.1990", driver.findElement(By.name("birthDate")).getAttribute("value"));

        Assert.assertEquals("4515", driver.findElement(By.xpath("//input[@placeholder='Серия']")).getAttribute("value"));
        Assert.assertEquals("111111", driver.findElement(By.xpath("//INPUT[@ng-model='formdata.insurer.documentList[0].DOCNUMBER']")).getAttribute("value"));
        Assert.assertEquals("01.01.2004", driver.findElement(By.name("issueDate")).getAttribute("value"));
        Assert.assertEquals("Москва", driver.findElement(By.xpath("//TEXTAREA[@name='issuePlace']")).getAttribute("value"));
     //9
        driver.findElement(By.xpath("//SPAN[@ng-click='save()'][text()='Продолжить']")).click();
     //10
        Assert.assertEquals("Заполнены не все обязательные поля", driver.findElement(By.xpath("//DIV[@ng-show='tryNext && myForm.$invalid']")).getText());
    }


}
