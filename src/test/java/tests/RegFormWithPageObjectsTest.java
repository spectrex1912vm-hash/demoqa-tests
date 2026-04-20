package tests;


import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;


public class RegFormWithPageObjectsTest extends TestBase{

//    Variant 1
    @Test
    void regFormTest() {
        String userName = "Testqa";

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName("Qatest")
                .setEmail("qatest@gmail.com")
                .setGender("Male")
                .setPhone("1234567899")
                .setBirthDate("18", "April", "1995");



        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbies-checkbox-1").click();
        $("#uploadPicture").uploadFromClasspath("images.jpg");
        $("#currentAddress").setValue("Some Address");
        $("#state").scrollIntoView(true).shouldBe(visible).click();
        $(withText("NCR")).shouldBe(visible).click();
        $("#city").scrollIntoView(true).shouldBe(visible).click();
        $(withText("Delhi")).shouldBe(visible).click();
        $("#submit").shouldBe(visible).click();
        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", userName + " Qatest")
                .verifyResult("Student Email", "qatest@gmail.com")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "1234567899")
                .verifyResult("Date of Birth", "18 April,1995")
                .verifyResult("Subjects", "Maths")
                .verifyResult("Hobbies", "Sports")
                .verifyResult("Picture", "images.jpg")
                .verifyResult("Address", "Some address")
                .verifyResult("State and City", "NCR Delhi");
//        registrationPage.registrationResultsModal.verifyResult("Student Name", userName + "qatest");

        $("#closeLargeModal").shouldBe(visible).shouldBe(enabled).scrollIntoView(true)
                .click();


    }

//    Variant 2
//      @Test
//    void regForm1Test() {
//        String userName = "Testqa";
//
//        registrationPage.openPage();
//
//        registrationPage.setFirstName(userName);
//        registrationPage.setLastName("Qatest");
//        registrationPage.setEmail("qatest@gmail.com");
//        registrationPage.setGender("Male");
//        registrationPage.setPhone("1234567899");
//
//
//        $("#userNumber").setValue("1234567899");
//        $("#dateOfBirthInput").setValue("18 Apr 1995");
//        $("#dateOfBirthInput").click();
//        $(".react-datepicker__month-select").selectOption("April");
//        $(".react-datepicker__year-select").selectOption("1995");
//        $(".react-datepicker__day--018:not(.react-datepicker__day--outside-month)")
//                .shouldBe(visible)
//                .click();
//        $("#subjectsInput").setValue("History").pressEnter();
//        $("#hobbies-checkbox-1").click();
//        $("#uploadPicture").uploadFromClasspath("images.jpg");
//        $("#currentAddress").setValue("Some Address");
//        $("#state").scrollIntoView(true).shouldBe(visible).click();
//        $(withText("NCR")).shouldBe(visible).click();
//        $("#city").scrollIntoView(true).shouldBe(visible).click();
//        $(withText("Delhi")).shouldBe(visible).click();
//        $("#submit").shouldBe(visible).click();
//        $("#example-modal-sizes-title-lg").shouldBe(visible).shouldHave(text("Thanks for submitting the form"));
//        $("#closeLargeModal").shouldBe(visible).shouldBe(enabled).scrollIntoView(true)
//                .click();
//
//
//    }
}
