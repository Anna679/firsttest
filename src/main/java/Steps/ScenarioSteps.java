package Steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import pages.FormPage;

import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class ScenarioSteps {

    MainSteps mainSteps=new MainSteps();
    StrahovanieSteps strahovanieSteps=new StrahovanieSteps();
    ChoiceInsuranceSteps choiceInsuranceSteps=new ChoiceInsuranceSteps();
    FormSteps formSteps=new FormSteps();
    FormPage formPage=new FormPage();

    @When("^выбран пункт меню \"(.*)\"$")
    public void stepSelectMaimMenu(String menuItem){
        mainSteps.stepSelectMaimMenu(menuItem);
    }
    @When("^выбран вид страхования \"(.*)\"$")
    public void stepSelectTypeInsurance(String menuItem) {
        mainSteps.stepSelectSubMenu(menuItem);

    }
    @When("^выполнено нажатие на кнопку -Оформить онлайн")
    public void stepSendButtonOrotmit(){
        strahovanieSteps.stepSendIMGButton();
    }
    @Then("^переключение в другое окно")
    public void stepSwitchToWindow (){
        switchToWindow("Сбербанк страхование");
    }
    public void switchToWindow (String nameWindow ){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (String winHandle : (BaseSteps.getDriver()).getWindowHandles()) {
            if(winHandle.equals((BaseSteps.getDriver()).getWindowHandle())) {
                System.out.println((BaseSteps.getDriver()).getTitle());
                continue;
            }

            if (!(BaseSteps.getDriver()).getTitle().equals(nameWindow)) {

                System.out.println("tab needed found!!!!");
                (BaseSteps.getDriver()).switchTo().window(winHandle);
                System.out.println((BaseSteps.getDriver()).getTitle());
                break;
            }

        }
    }
    @When("^выбрана сумма-программа страхования \"(.*)\"$")
    public void stepChoice(String meneItem){
        choiceInsuranceSteps.stepSelectChoiceInsurance(meneItem);

    }
    @When("^заполняются поля:$")
    public void stepZapolnenie(DataTable fields){
        fields.asMap(String.class,String.class).forEach(
                (field,value) -> formSteps.stepFillOne(field,value));

    }

    @Then("^проверяются поля, что заполненны правильными значениями:$")
    public void stepCheckZapolnenie(DataTable fields){
        fields.asMap(String.class,String.class).forEach(
                (field,value) -> formSteps.checkFullField(field,value));

    }
    @When("^нажата кнопка - Продолжить")
    public void stepSendButtonContinue(){

        formPage.ClickGoButton();
    }
    @Then("^Вызов ошибки")
    public void stepCheckErrorMessage(/*String errorMessage*/){
     formSteps.stepCheckErrorMessage("Заполнены не все обязательные поля");
    }
    }
