package com.socks.ui;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {


    public static MainPage open() {
        Selenide.open("http://localhost:80");
        return new MainPage();
    }

    public void loginAs(String userName, String userPassword) {
        $("#login > a").click();
        $("#username-modal").setValue(userName);
        $("#password-modal").setValue(userPassword);
        $x("//button[contains(text(),'Log in')]").click();
    }


}
