package tests;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Ищем репозиторий {repository}")
    public void searchForRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }

    @Step("Переходим в репозиторий {repository}")
    public void goToRepository(String repository) {
        $(By.linkText(repository)).click();
    }

    @Step("Переходим в таб Issues")
    public void clickOnIssueTab() {
        $(withText("Issues")).click();
    }

    @Step("Проверяем что Issue с номером {number} существует")
    public void shouldSeeIssueWithNumber(int number) {
        $(withText("#" + number)).should(exist);
    }

    @Step("Проверяем что Issue с именем {name} существует")
    public void shouldSeeIssueWithName(String name) {
        $(withText(name)).should(exist);
    }

}