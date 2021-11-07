package com.restfulbooker.qa.testcases;

import com.restfulbooker.qa.utils.RestUtils;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TestPostApiResponseAfterQuery {

    public static Map<String, Object> bookingInfoMap = new LinkedHashMap<>();
    public static Map<String, Object> bookingDatesInfoMap = new LinkedHashMap<>();

    @BeforeTest
    public void postData(){
        bookingInfoMap.put("firstname", RestUtils.getFirstName());
        bookingInfoMap.put("lastname", RestUtils.getLastName());
        bookingInfoMap.put("totalprice", RestUtils.getTotalPrice());
        bookingInfoMap.put("depositpaid", RestUtils.getIsDepositPaid());
        bookingInfoMap.put("additionalneeds", RestUtils.getAdditionalNeeds());

        bookingDatesInfoMap.put("checkin", "2021-01-29");
        bookingDatesInfoMap.put("checkout", "2021-02-02");

        bookingInfoMap.put("bookingdates", bookingDatesInfoMap);

        RestAssured.baseURI ="https://restful-booker.herokuapp.com";
        RestAssured.basePath="/booking";
    }

    @Test
    void createBookings(){
        given()
                .contentType("application/json; charset=utf-8")
                .body(bookingInfoMap)
        .when()
                .post()
        .then().log().all()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .body("bookingid",is(notNullValue()))
                .body("booking",is(notNullValue()));
    }
}
