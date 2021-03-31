package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@DisplayName("Набор лямбда тестов")
public class LambdaStepsTests {

    private final String BASE_URL = "https://github.com";

    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static int ISSUE_NUMBER = 58;
    private final static String ISSUE_NAME = "с днем археолога!";

    @Test
    @DisplayName("Поиск Issue по номеру (лямбда)")
    public void testSearchRepoByNumber() {
        Allure.parameter("Repository", REPOSITORY);
        Allure.parameter("Issue Number", ISSUE_NUMBER);

        step("Открываем главную страницу", (step) -> {
            step.parameter("url", BASE_URL);
            open(BASE_URL);
        });
        step("Ищем репозиторий", (step) -> {
            step.parameter("repository", REPOSITORY);

            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Переходим в репозиторий", () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Переходим в таб Issues", () -> {
            $(withText("Issues")).click();
        });
        step("Проверяем что issue с номером  " + ISSUE_NUMBER + " существует", () -> {
            $(withText("#" + ISSUE_NUMBER)).should(Condition.exist);
        });
    }

    @Test
    @DisplayName("Поиск Issue по имени (лямбда)")
    public void testSearchRepoByName() {
        Allure.parameter("Repository", REPOSITORY);
        Allure.parameter("Issue Name", ISSUE_NAME);

        step("Открываем главную страницу", (step) -> {
            step.parameter("url", BASE_URL);
            open(BASE_URL);
        });
        step("Ищем репозиторий", (step) -> {
            step.parameter("repository", REPOSITORY);

            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Переходим в репозиторий", () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Переходим в таб Issues", () -> {
            $(withText("Issues")).click();
        });
        step("Проверяем что issue с именем " + ISSUE_NAME + " существует", () -> {
            $(withText(ISSUE_NAME)).should(Condition.exist);
        });
    }
}