package demqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class RegFormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";

    }

    @Test
    void regFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("h1").shouldBe(visible).shouldHave(text("Practice Form"));
        $("#firstName").setValue("Testqa");
        $("#lastName").setValue("Qatest");
        $("#userEmail").setValue("qatest@gmail.com");
        $(".form-check-input").click();
        $("#userNumber").setValue("1234567899");
        $("#dateOfBirthInput").setValue("18 Apr 1995");
        $("#subjectsInput").setValue("History").pressEnter();
        $("#hobbies-checkbox-1").click();
        $("#uploadPicture").uploadFromClasspath("images.jpg");
        $("#currentAddress").setValue("Some Address");
        $("#state").scrollIntoView(true).shouldBe(visible).click();
        $(withText("NCR")).shouldBe(visible).click();
        $("#city").scrollIntoView(true).shouldBe(visible).click();
        $(withText("Delhi")).shouldBe(visible).click();
        $("#submit").shouldBe(visible).click();
        $("#example-modal-sizes-title-lg").shouldBe(visible).shouldHave(text("Thanks for submitting the form"));
        $("#closeLargeModal").shouldBe(visible).shouldBe(enabled).scrollIntoView(true)
                .click();


    }
}
