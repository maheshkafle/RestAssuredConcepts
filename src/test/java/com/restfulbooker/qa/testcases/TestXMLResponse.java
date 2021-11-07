package com.restfulbooker.qa.testcases;

import com.restfulbooker.qa.TestBase.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TestXMLResponse extends TestBase {

    @Test
    public void TestXMLResponse(){

        given()
        .when()
                .get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/1")
        .then()
                //1. Test single content in XML response body
                .body("CUSTOMER.ID", equalTo("1"))

                //2. Test multiple content in XML response body
                .body("CUSTOMER.FIRSTNAME", equalTo("Susanne"))
                .body("CUSTOMER.LASTNAME", equalTo("King"))
                .body("CUSTOMER.STREET", equalTo("366 - 20th Ave."))
                .body("CUSTOMER.CITY", equalTo("Olten"))

                //3. Test multiple content in XML response body in one go
                .body("CUSTOMER.text()", equalTo("1SusanneKing366 - 20th Ave.Olten"))

                //4. Test values in XML response body using Xpath
                .body(hasXPath("/CUSTOMER/FIRSTNAME"), containsString("Susanne"));
    }
}
