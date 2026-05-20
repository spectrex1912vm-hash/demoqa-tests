package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegFormWithTestDataTest extends TestData {
//    String userName = "Testqa";
//    String lastname = "Qatest";
//    String userEmail = "qatest@gmail.com";

//    String userName = "Testqa",
//           lastname = "Qatest",
//           userEmail = "qatest@gmail.com";

//    static String userName,
//           lastname,
//           userEmail ;

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";

//        userName = "Testqa"; // Bad practice
//        lastname = "Qatest";
//        userEmail = "qatest@gmail.com";
    }

    @BeforeEach
     void beforeEach() {
//        userName = "Testqa";
//        lastname = "Qatest";
//        userEmail = "qatest@gmail.com";
    }

    @Test
    void regFormTest() {
//        String userName = "Testqa";
//        String lastname = "Qatest";
//        String userEmail = "qatest@gmail.com";


        open("https://demoqa.com/automation-practice-form");
        $("h1").shouldBe(visible).shouldHave(text("Practice Form"));
        $("#firstName").setValue(userName);
        $("#lastName").setValue(userLastName);
        $("#userEmail").setValue(userEmail);
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
