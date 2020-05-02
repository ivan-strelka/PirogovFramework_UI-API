package com.socks.ui.test;

import com.socks.ui.CatalogPage;
import com.socks.ui.ShoppingCartPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;

public class ShoppingCartTest extends BaseUITest {
    @Test
    public void userCanAddItemToCardFromCatalog() {
        CatalogPage
                .open()
                .addItemByIndex(0)
                .goToCard();

        at(ShoppingCartPage.class)
                .totalAmount().shouldHave(exactText("$104.98"));

    }
}
