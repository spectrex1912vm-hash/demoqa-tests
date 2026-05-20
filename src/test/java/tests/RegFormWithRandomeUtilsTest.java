package tests;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class RegFormWithRandomeUtilsTest extends TestBase {

    @Test
    void regFormTest() {
//        Faker faker = new Faker();
        Faker faker = new Faker(new Locale("de-CH"));

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();
        String address = faker.address().streetAddress();



        open("https://demoqa.com/automation-practice-form");
        $("h1").shouldBe(visible).shouldHave(text("Practice Form"));
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $(".form-check-input").click();
        $("#userNumber").setValue("1234567899");
        $("#dateOfBirthInput").setValue("18 Apr 1995");
        $("#subjectsInput").setValue("History").pressEnter();
        $("#hobbies-checkbox-1").click();
        $("#uploadPicture").uploadFromClasspath("images.jpg");
        $("#currentAddress").setValue(address);
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
