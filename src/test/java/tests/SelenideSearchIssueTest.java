package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideSearchIssueTest {

    private static final String myRepo = "isamarskiy/qaGuruAllureHw5";

    @Test
    @Owner("Samarsky")
    @Tags({@Tag("web"), @Tag("test")})
    @DisplayName("Pure Selenide issue search")
    public void testSelenideSearch(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        //test steps
        open("http://github.com");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(myRepo);
        $(".header-search-input").submit();
        $(By.linkText(myRepo)).click();
        $(withText("Issues")).click();
        $(withText("Issue for hw")).shouldBe(visible);
    }
}
