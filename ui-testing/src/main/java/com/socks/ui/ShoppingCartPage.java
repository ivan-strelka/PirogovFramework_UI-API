package com.socks.ui;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ShoppingCartPage {

    @Step
    public static ShoppingCartPage open() {
        Selenide.open("/basket.html");
        return Selenide.page(ShoppingCartPage.class);
    }

    @Step
    public SelenideElement totalAmount() {
        return $("#orderGrandTotal");
    }

    public ShoppingCartPage deleteItem() {
        $x("//i[@class='fa fa-trash-o']").click();
        return this;

    }


}
