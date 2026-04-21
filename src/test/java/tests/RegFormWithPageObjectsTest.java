package tests;
import org.junit.jupiter.api.Test;

public class RegFormWithPageObjectsTest extends TestBase{

    @Test
    void regFormTest() {
        String userName = "Testqa";
        String subject = "Math";
        String userLastName = "Qatest";
        String userEmail = "qatest@gmail.com";
        String userGender = "Male";
        String phone = "1234567899";
        String birthDate = "18 April 1995";
        String hobbies = "Sports";
        String picture = "images.jpg";
        String Address = "Some Address";
        String userState = "NCR";
        String userCity = "Delhi";

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(userLastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setPhone(phone)
                .setBirthDate(birthDate)
                .setSubjects(subject)
                .setHobbies(hobbies)
                .uploadPicture(picture)
                .setCurrentAddress(Address)
                .setState(userState)
                .setCity(userCity)
                .submit();

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
    }

}
