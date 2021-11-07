package com.restfulbooker.qa.testcases;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class TestGetApiResponseAfterQuery {

    @Test
    public void getBookings(){

        given()
        //5. setting params and headers
                .param("MyName", "Kahesh")
                .header("MyHeader", "Nepali")
        .when()
            .get("https://reqres.in/api/users")
        .then()
            // 2. Log Response
            .log().all()
            .assertThat()
                //1. Test API Response Status Code
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                //3. Verify single content in response body
                .body("data[0].email", equalTo("george.bluth@reqres.in"))
                //4. verify multiple content in response body
                .body("data.email", hasItems("george.bluth@reqres.in", "janet.weaver@reqres.in", "eve.holt@reqres.in", "charles.morris@reqres.in"))
                .header("Content-Type", "application/json; charset=utf-8");
    }
}


