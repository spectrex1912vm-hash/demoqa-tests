package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    private final CalendarComponent calendarComponent = new CalendarComponent();
    private final RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final String TITLE_TEXT = "Practice Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput =  $("#userEmail"),
            phoneInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            uploadPictureInput =  $("#uploadPicture"),
            currentAddressInput =  $("#currentAddress"),
            stateInput =  $("#state input"),
            cityInput =   $("#city"),
            stateSityWrapper =  $("#stateCity-wrapper"),
            submitButton =  $("#submit");


    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        $("h1").shouldBe(visible).shouldHave(text(TITLE_TEXT));
        return this;

    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        $("#lastName").setValue(value);

        return this;
    }

    public RegistrationPage clearLastName(String value) {
        lastNameInput.clear();

        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        $("#genterWrapper").$(byText(value))  .click();

        return this;
    }

    public RegistrationPage setPhone(String value) {
        phoneInput.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setBirthDate(String date) {
        String[] parts = date.split(" ");

        String day = parts[0];
        String month = parts[1];
        String year = parts[2];

        return setBirthDate(day, month, year);
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);

        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;

    }

    public RegistrationPage setHobbies(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage uploadPicture(String filename) {
        uploadPictureInput.uploadFromClasspath(filename);
        return this;
    }

    public RegistrationPage setState(String value) {
        stateInput.scrollIntoView("{block: 'center'}");
        stateInput.click();
        stateSityWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setCity(String value) {
        cityInput.scrollIntoView("{block: 'center'}");
        cityInput.click();
        stateSityWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage submit() {
        submitButton.click();
        return this;
    }

}
