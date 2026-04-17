package demqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {

        open("/text-box");
        $(".text-center").shouldHave(text("Text Box"));

        $("#userName").setValue("Test QA");
        $("#userEmail").setValue("testQa@gmail.com");
        $("#currentAddress").setValue("Some Address 1");
        $("#permanentAddress").setValue("Other Address 1");
        $("#submit").scrollIntoView(true).shouldBe(visible).click();
        $("#output").shouldBe(visible);
        $("#output").$("#name").shouldHave(text("Test QA"));
        $("#output").$("#email").shouldHave(text("testQa@gmail.com"));
        $("#output").$("#currentAddress").shouldHave(text("Some Address 1"));
        $("#output").$("#permanentAddress").shouldHave(text("Other Address 1"));



    }
}
