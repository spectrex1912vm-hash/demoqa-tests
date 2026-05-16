package tests;
import org.junit.jupiter.api.Test;

public class RegFormWithPageObjectsTest extends TestBase{

    @Test
    void regFormTest() {
        TestData testData = new TestData();

        String userName = testData.userName;
        String subject = "Math";
        String userGender = "Male";
        String hobbies = "Sports";
        String picture = "images.jpg";
        String userState = "NCR";
        String userCity = "Delhi";

        registrationPage.openPage()
                .setFirstName(testData.userName)
                .setLastName(testData.userLastName)
                .setEmail(testData.userEmail)
                .setGender(userGender)
                .setPhone(testData.phone)
                .setBirthDate(testData.getBirthday())
                .setSubjects(subject)
                .setHobbies(hobbies)
                .uploadPicture(picture)
                .setCurrentAddress(testData.address)
                .setState(userState)
                .setCity(userCity)
                .submit();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", testData.userName + " " + testData.userLastName)
                .verifyResult("Student Email", testData.userEmail)
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", testData.phone)
                .verifyResult("Date of Birth", testData.getBirthday())
                .verifyResult("Subjects", "Maths")
                .verifyResult("Hobbies", "Sports")
                .verifyResult("Picture", "images.jpg")
                .verifyResult("Address", testData.address)
                .verifyResult("State and City", "NCR Delhi");
    }

}
