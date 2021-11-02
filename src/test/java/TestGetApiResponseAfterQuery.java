import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestGetApiResponseAfterQuery {

    @Test
    public void getBookings(){

        given()
        .when()
            .get("https://restful-booker.herokuapp.com/booking/20")
        .then()
            .log().all()
            .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .assertThat().body("depositpaid", equalTo(true))
                .header("Content-Type", "application/json; charset=utf-8");
    }
}


