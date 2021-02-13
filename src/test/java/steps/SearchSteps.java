package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchSteps {

    private static final String myRepo = "isamarskiy/qaGuruAllureHw5";

    @Step("Open the main page")
    public void openMainPage(String url){
        open(url);
    }

    @Step("Search my repo" + myRepo)
    public void searchMyRepo(){
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(myRepo);
        $(".header-search-input").submit();
    }

    @Step("Go to " + myRepo)
    public void goToMyRepo(){
        $(By.linkText(myRepo)).click();
    }

    @Step("Go to issues tab")
    public void goToIssuesTab(){
        $(withText("Issues")).click();
    }

    @Step("Check issue name")
    public void checkIssueTitle(String issueTitle){
        $(withText(issueTitle)).shouldBe(visible);
    }
}
