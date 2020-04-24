package com.socks.ui.test;

import com.socks.ui.MainPage;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void userCanLogin() {
        MainPage.open()
                .loginAs("farolazeb", "123456");

    }
}
