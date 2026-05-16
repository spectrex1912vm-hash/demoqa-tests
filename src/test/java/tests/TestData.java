package tests;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TestData {
     Faker faker = new Faker();
     String userName = faker.name().firstName();
     String userLastName = faker.name().lastName();
     String userEmail = faker.internet().emailAddress();
     String address = faker.address().streetAddress();
     String phone = faker.number().digits(10);

     String getBirthday() {
          Date birthDate = faker.date().birthday();

          SimpleDateFormat formatter =
                  new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);

          return formatter.format(birthDate);
     }


}
