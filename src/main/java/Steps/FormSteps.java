package Steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FormPage;
import ru.yandex.qatools.allure.annotations.Step;
import sun.jvm.hotspot.utilities.Assert;

import java.util.HashMap;

import static junit.framework.TestCase.assertTrue;

public class FormSteps extends BaseSteps {

    private String value;

    @Step("Поле {0} заполняется значением {1}")
    public void stepFillOne (String filed , String value){
        new FormPage(driver).fillField(filed,value);
    }

    @Step ("Заполняются поля:")
    public void stepFillSome(HashMap<String,String> fields){
        fields.forEach((key, value)->stepFillOne(key,value));

    }

    @Step("Поле {0} заполнено значением {1}")
    public void checkFullField(String field, String value){
        String Znachenie = new FormPage(driver).getFillZnachenie(field);
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, Znachenie, value),Znachenie.equals(value));
    }

     @Step("Поля заполнены следующими данными:")
     public void checkFillSome(HashMap<String,String> fields){
       fields.forEach((key, value)-> checkFullField(key,value));
   }
    @Step("Нажать на кнопку - Продолжить")
    public void stepSendContinueButton() {
        new FormPage(driver).ClickGoButton();
    }

        @Step("Cообщение об ошибке по заполнению полей")

        public void stepCheckErrorMessage(String  value){
            new FormPage(driver).checkErrorMessage(value);
        }
    }


