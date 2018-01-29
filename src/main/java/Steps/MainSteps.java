package Steps;


import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps extends BaseSteps{

@Step("Выбран пункт меню {0}")
    public void stepSelectMaimMenu(String menuItem){
    new MainPage(driver).selectMeinMenu(menuItem);
}

@Step ("Выбран вид страхования {0}")
    public void stepSelectSubMenu(String menuItem){
        new MainPage(driver).selectSubMenu(menuItem);
    }
}
