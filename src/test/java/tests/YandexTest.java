import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class YandexTest {

    @Test
    void searchYandex() {
        open("https://ya.ru");
        $("#text").setValue("yandex").pressEnter();

        $("#search-result").shouldHave(text("yandex.ru"));
    }
}
