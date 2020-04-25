package com.socks.api.secvices;

import com.socks.api.ProjectConfig;
import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class BaseApiService {

    protected RequestSpecification setUp() {

        return RestAssured
                .given().contentType(ContentType.JSON)
                .filters(getFiltres());
    }

    private List<Filter> getFiltres() {
        ProjectConfig prop = ConfigFactory.create(ProjectConfig.class, System.getProperties());
        if (prop.logging()) {
            return Arrays.asList(new RequestLoggingFilter(), new ResponseLoggingFilter());
        }
        return Collections.emptyList();
    }


}
