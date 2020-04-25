package com.socks.api.test;

import com.github.javafaker.Faker;
import com.socks.api.ProjectConfig;
import com.socks.api.payloads.UserRegistrationPayload;
import com.socks.api.responses.UserRegistationResponse;
import com.socks.api.secvices.UserApiService;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Locale;

import static com.socks.api.conditions.Conditions.bodyField;
import static com.socks.api.conditions.Conditions.statusCode;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;

public class UsersTest {
    private final UserApiService userApiService = new UserApiService();
    private Faker faker;

    @BeforeMethod
    public void setUp() {
        ProjectConfig prop = ConfigFactory.create(ProjectConfig.class, System.getProperties());
        RestAssured.baseURI = prop.baseURL();
        faker = new Faker(new Locale(prop.locale()));
    }


    @Test
    public void testCanRegisterNewUser() {
        UserRegistrationPayload payLoadUser = new UserRegistrationPayload()
                .username(faker.name().username())
                .email("sdf@dsfs.com")
                .password(faker.random().hex(7));

        UserRegistationResponse response = userApiService.registerUser(payLoadUser)
                .shouldHave(statusCode(200))
                .asPojo(UserRegistationResponse.class);
        System.out.println(response.getId());

    }

    @Test
    public void testCanRegisterNewUser2() {
        UserRegistrationPayload payLoadUser = new UserRegistrationPayload()
                .username(faker.funnyName().name())
                .email("test123")
                .password("test123");

        userApiService.registerUser(payLoadUser)
                .shouldHave(statusCode(200))
                .shouldHave(bodyField("id", not(isEmptyString())));

        userApiService.registerUser(payLoadUser)
                .shouldHave(statusCode(500));
    }


    @Test
    public void testCanRegisterNewUser3() {
        UserRegistrationPayload payLoadUser = new UserRegistrationPayload()
                .username(faker.funnyName().name())
                .email("test123")
                .password("test123");

        userApiService.registerUser(payLoadUser)
                .shouldHave(statusCode(200))
                .shouldHave(bodyField("id", not(isEmptyString())));

        userApiService.registerUser(payLoadUser)
                .shouldHave(statusCode(500));
    }


}
