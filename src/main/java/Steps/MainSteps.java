package Steps;


import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps{

@Step("Выбран пункт меню {0}")
    public void stepSelectMaimMenu(String menuItem){
    new MainPage(BaseSteps.getDriver()).selectMeinMenu(menuItem);;
}

@Step ("Выбран вид страхования {0}")
    public void stepSelectSubMenu(String menuItem){
    new MainPage(BaseSteps.getDriver()).selectSubMenu(menuItem);
    }
}
