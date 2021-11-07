package com.restfulbooker.qa.testcases;

import com.restfulbooker.qa.TestBase.TestBase;
import com.restfulbooker.qa.utils.RestUtils;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class TestPutApiResponseAfterQuery extends TestBase {

    @BeforeTest
    public void putData() {
        bookingInfoMap.put("firstname", RestUtils.getFirstName());
        bookingInfoMap.put("lastname", RestUtils.getLastName());
        bookingInfoMap.put("totalprice", RestUtils.getTotalPrice());
        bookingInfoMap.put("depositpaid", RestUtils.getIsDepositPaid());
        bookingInfoMap.put("additionalneeds", RestUtils.getAdditionalNeeds());

        bookingDatesInfoMap.put("checkin", "2021-01-29");
        bookingDatesInfoMap.put("checkout", "2021-02-02");

        bookingInfoMap.put("bookingdates", bookingDatesInfoMap);

        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        RestAssured.basePath = "/booking/1";
    }

    @Test
    void TestPutRequestURI() {
        given()
                .header("Cookie", "token=52e7412f75ac43d")
                .contentType("application/json; charset=utf-8")
                .body(bookingInfoMap)

        .when()
                .put()
        .then().log().all()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .body("bookingdates", is(notNullValue()));
    }
}

