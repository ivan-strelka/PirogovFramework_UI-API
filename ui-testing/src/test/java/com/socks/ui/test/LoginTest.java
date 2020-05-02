package com.socks.ui.test;

import com.socks.api.payloads.UserRegistrationPayload;
import com.socks.api.secvices.UserApiService;
import com.socks.ui.LoggedUserPage;
import com.socks.ui.MainPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.socks.api.conditions.Conditions.statusCode;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class LoginTest extends BaseUITest {

    private final UserApiService userApiService = new UserApiService();

    @Test
    public void userCanLogin() {
        UserRegistrationPayload payLoadUser = new UserRegistrationPayload()
                .username(randomAlphanumeric(6))
                .email(randomAlphanumeric(6) + "@mail.com")
                .password("123456");

        userApiService.registerUser(payLoadUser)
                .shouldHave(statusCode(200));

        MainPage.open()
                .loginAs(payLoadUser.username(), payLoadUser.password());

        LoggedUserPage loggedUserPage = at(LoggedUserPage.class);
        loggedUserPage.logOutBtn()
                .shouldHave(appear)
                .shouldHave(text("Logout"));
        loggedUserPage.userName()
                .shouldHave(text("Logged in as"));
    }
}
