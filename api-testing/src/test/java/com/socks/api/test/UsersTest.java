package com.socks.api.test;

import com.socks.api.payloads.UserRegistrationPayload;
import com.socks.api.secvices.UserApiService;
import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;

public class UsersTest {
    private final UserApiService userApiService = new UserApiService();

    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = "http://localhost:80/";
    }


    @Test
    public void testCanRegisterNewUser() {
        UserRegistrationPayload payLoadUser = new UserRegistrationPayload()
                .username(RandomStringUtils.randomAlphanumeric(6))
                .email("test123")
                .password("test123");

        userApiService.registerUser(payLoadUser)
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("id", not(isEmptyString()));

    }

    @Test
    public void testCanRegisterNewUser2() {
        UserRegistrationPayload payLoadUser = new UserRegistrationPayload()
                .username(RandomStringUtils.randomAlphanumeric(6))
                .email("test123")
                .password("test123");

        userApiService.registerUser(payLoadUser)
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("id", not(isEmptyString()));


        userApiService.registerUser(payLoadUser)
                .then().log().all()
                .assertThat()
                .statusCode(500);
    }


}
