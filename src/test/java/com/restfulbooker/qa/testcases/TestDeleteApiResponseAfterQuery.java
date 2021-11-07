package com.restfulbooker.qa.testcases;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestDeleteApiResponseAfterQuery {

    @Test
    void TestDeleteRequestURI() {

        RestAssured.baseURI ="https://restful-booker.herokuapp.com";
        RestAssured.basePath="/booking/2";

        Response response =
                (Response) given()
                    .header("Cookie", "token=519373ef46e7c0c")
                    .contentType("application/json; charset=utf-8")
                .when()
                    .delete()
                .then().log().all()
                    .statusCode(201)
                    .statusLine("HTTP/1.1 201 Created")
                .extract().response();

        String jsonAsString  = response.asString();
        Assert.assertEquals(jsonAsString.contains("Created"),true);
    }
}
