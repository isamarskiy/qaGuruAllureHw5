package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LamdaStepsSearchIssueTest {

    private static final String myRepo = "isamarskiy/qaGuruAllureHw5";
    private static final String issueTitle = "Issue for hw";

    @Test
    @Owner("Samarskiy")
    @Tags({@Tag("web"), @Tag("test")})
    @DisplayName("Test with lamda steps")
    public void testLamdaStepsSearch(){
        step("Open the main page", () -> {
            open("http://github.com");
        });
        step("Search my repo" + myRepo, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(myRepo);
            $(".header-search-input").submit();
        });
        step("Go to " + myRepo, () ->{
            $(By.linkText(myRepo)).click();
        });
        step("Go to issues tab", () -> {
            $(withText("Issues")).click();
        });

        step("Check issue with name " + issueTitle, () ->{
            $(withText(issueTitle)).shouldBe(visible);
        });
    }
}
