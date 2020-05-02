package com.socks.ui;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoggedUserPage {

    public SelenideElement logOutBtn() {
        return $("#logout > a");
    }

    public SelenideElement userName() {
        return $("#howdy > a");
    }


}
