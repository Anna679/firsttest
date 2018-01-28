package Steps;

import pages.StrahovaniePage;
import ru.yandex.qatools.allure.annotations.Step;

public class StrahovanieSteps extends BaseSteps {
    @Step("Выполнено нажатие на кнопку -Оформить Онлайн")
    public void stepSendIMGButton() {
        new StrahovaniePage(driver).IMGButton.click();


    }
}
