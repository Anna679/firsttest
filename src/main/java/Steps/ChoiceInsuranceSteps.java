package Steps;

        import pages.ChoiceInsurancePage;
        import ru.yandex.qatools.allure.annotations.Step;

public class ChoiceInsuranceSteps{

    @Step("Выбрана сумма страхования{0}")

    public void stepSelectChoiceInsurance(String menuItem) {

        ChoiceInsurancePage choiceInsurancePage = new ChoiceInsurancePage (BaseSteps.getDriver());
        choiceInsurancePage.selectInsurance(menuItem);
        choiceInsurancePage.selectChoiceButton();



    }
}





