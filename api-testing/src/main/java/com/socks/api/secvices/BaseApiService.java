package com.socks.api.secvices;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;


public class BaseApiService {

    protected RequestSpecification setUp() {
        return RestAssured
                .given().contentType(ContentType.JSON).log().all();
    }


}
