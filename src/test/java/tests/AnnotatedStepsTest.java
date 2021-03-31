package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Набор тестов с аннотациями")
public class AnnotatedStepsTest {
    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static int ISSUE_NUMBER = 58;
    private final static String ISSUE_NAME = "с днем археолога!";

    private WebSteps steps = new WebSteps();

    @Test
    @Owner("netpiligrim")
    @DisplayName("Поиск Issue по номеру (аннотации)")
    @Feature("Работа с разметкой")
    @Story("Разметка аннотациий")
    @Severity(SeverityLevel.BLOCKER)
    @Link(name = "BaseURL", url = "https://github.com")
    public void testSearchRepoByNumber() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.clickOnIssueTab();
        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);
    }

    @Test
    @Owner("netpiligrim")
    @DisplayName("Поиск Issue по имени (аннотации)")
    @Feature("Работа с разметкой")
    @Story("Разметка аннотациий")
    @Severity(SeverityLevel.BLOCKER)
    @Link(name = "BaseURL", url = "https://github.com")
    public void testSearchRepoByName() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.clickOnIssueTab();
        steps.shouldSeeIssueWithName(ISSUE_NAME);
    }
}
