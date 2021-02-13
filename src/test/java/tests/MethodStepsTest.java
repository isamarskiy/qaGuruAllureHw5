package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import steps.SearchSteps;

public class MethodStepsTest {

    final SearchSteps steps = new SearchSteps();

    @Test
    @Owner("Samarskiy")
    @Tags({@Tag("web"), @Tag("test")})
    @DisplayName("Test with method steps")
    public void searchIssueTest(){
        steps.openMainPage("http://github.com");
        steps.searchMyRepo();
        steps.goToMyRepo();
        steps.goToIssuesTab();
        steps.checkIssueTitle("Issue for hw");
    }
}
