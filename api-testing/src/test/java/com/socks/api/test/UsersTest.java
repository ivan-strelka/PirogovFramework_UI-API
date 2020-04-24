package com.socks.api.test;

import com.socks.api.payloads.UserRegistrationPayload;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;

public class UsersTest {

    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = "http://localhost:80/";
    }

    @Test
    public void testCanRegisterNewUser() {
        UserRegistrationPayload payLoadUser = new UserRegistrationPayload();
        payLoadUser.setUsername(RandomStringUtils.randomAlphanumeric(6));
        payLoadUser.setPassword("test123");
        payLoadUser.setEmail("test@gfj.com");

        RestAssured
                .given().contentType(ContentType.JSON).log().all()
                .body(payLoadUser)
                .when()
                .post("register")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("id", not(isEmptyString()));

    }



}
