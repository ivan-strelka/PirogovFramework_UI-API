package com.socks.api.secvices;

import com.socks.api.assertions.AssertableResponse;
import com.socks.api.payloads.UserRegistrationPayload;

public class UserApiService extends BaseApiService {

    public AssertableResponse registerUser(UserRegistrationPayload payLoadUser) {
        return new AssertableResponse(setUp()
                .body(payLoadUser)
                .when()
                .post("register"));
    }
}
