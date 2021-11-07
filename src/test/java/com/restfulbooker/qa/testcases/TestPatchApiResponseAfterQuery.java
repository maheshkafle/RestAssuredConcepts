package com.restfulbooker.qa.testcases;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class TestPatchApiResponseAfterQuery {

    @Test
    void patch_req(){
        RestAssured.baseURI ="https://reqres.in/api/users/2";
        String payload = "{"+
                "\"email\" : \"hello@gmail.com\", " +
                "\"first_name\" : \"Mahesh\", + " +
                "\"last_name\" : \"Kafle\", + " +
                "}" ;
        given()
                .body(payload)
        .when()
                .put()
        .then()
                .log().all()
                .assertThat().statusCode(200)
                .body("updatedAt",is(notNullValue()));
    }
}
