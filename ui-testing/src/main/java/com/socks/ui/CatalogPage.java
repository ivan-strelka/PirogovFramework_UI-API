package com.socks.ui;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;

public class CatalogPage {


    public static CatalogPage open() {
        Selenide.open("/category.html");
        return Selenide.page(CatalogPage.class);
    }

    public CatalogPage addItemByIndex(int index) {
        $$x("//a[@class='btn btn-primary']").get(index).click();
        return this;

    }

    public ShoppingCartPage goToCard() {
        $("#numItemsInCart").click();
        return Selenide.page(ShoppingCartPage.class);
    }

}
