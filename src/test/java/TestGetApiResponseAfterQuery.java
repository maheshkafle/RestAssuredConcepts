import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestGetApiResponseAfterQuery {

    @Test
    void get_req(){

        given()
        .when()
            .get("https://petstore.swagger.io/v2/pet/findByStatus?status=available")
        .then()
            .log().all()
            .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK");

    }
}


