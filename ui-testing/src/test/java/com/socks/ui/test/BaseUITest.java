package com.socks.ui.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.socks.api.ProjectConfig;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeSuite;

public class BaseUITest {

    @BeforeSuite
    public void setUp() {
        ProjectConfig prop = ConfigFactory.create(ProjectConfig.class, System.getProperties());
        RestAssured.baseURI = prop.baseURL();
        Configuration.baseUrl = prop.baseURL();
        Configuration.browser = "com.socks.ui.SelenoidDriverProvider";
        Configuration.timeout = 10000;
//        Configuration.browserSize ="1200x1000";

    }

    protected <T> T at(Class<T> pageClass) {
        return Selenide.page(pageClass);
    }

}
