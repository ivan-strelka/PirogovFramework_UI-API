package com.socks.api.secvices;

import com.socks.api.payloads.UserRegistrationPayload;
import io.restassured.response.Response;

public class UserApiService extends BaseApiService {
    public Response registerUser(UserRegistrationPayload payLoadUser) {
        return setUp()
                .body(payLoadUser)
                .when()
                .post("register");

    }
}
