import Steps.*;
import org.junit.Ignore;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.util.HashMap;

public class MyForAllureReportTest extends BaseSteps {

    @Ignore
    @Test
    @Title("Застраховать себя и имущество")
    public void testInsurance () {
        MainSteps mainSteps= new MainSteps();
        StrahovanieSteps strahovanieSteps= new StrahovanieSteps();
        ChoiceInsuranceSteps choiceInsuranceSteps=new ChoiceInsuranceSteps();
        FormSteps formSteps=new FormSteps();
        HashMap <String,String> testData= new HashMap<>();
        testData.put("Фамилия застрахованного","Petrov");
        testData.put("Имя застрахованного","Petr");
        testData.put("Дата рождения застрахованного","01.01.1990");
        testData.put("Фамилия","Иванов");
        testData.put("Имя","Иван");
        testData.put("Отчество","Иванович");
        testData.put("Дата рождения","01.01.1990");
        testData.put("Серия паспорта","4515");
        testData.put("Номер паспорта","111111");
        testData.put("Дата выдачи","01.01.2004");
        testData.put("Кем выдан","Москва");

        mainSteps.stepSelectMaimMenu("Застраховать себя ");
        mainSteps.stepSelectSubMenu("Страхование путешественников");
        strahovanieSteps.stepSendIMGButton();
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
        choiceInsuranceSteps.stepSelectChoiceInsurance("Минимальная");
        formSteps.stepFillSome(testData);
        formSteps.stepSendContinueButton();
        formSteps.stepCheckErrorMessage("Заполнены не все обязательные поля");


    }
}
