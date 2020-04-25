package com.socks.api.secvices;

import com.socks.api.assertions.AssertableResponse;
import com.socks.api.payloads.UserRegistrationPayload;
import io.qameta.allure.Step;

public class UserApiService extends BaseApiService {

    @Step
    public AssertableResponse registerUser(UserRegistrationPayload payLoadUser) {
        return new AssertableResponse(setUp()
                .body(payLoadUser)
                .when()
                .post("register"));
    }
}
