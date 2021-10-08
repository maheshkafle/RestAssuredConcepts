import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestGetApiResponseAfterQuery {

    @Test
    void get_req(){
        RestAssured.baseURI ="https://reqres.in/api/users";
        given().
            queryParam("page","2").body("")
        .when()
            .get()
        .then().log().all()
            .assertThat().statusCode(200)
            .body("page",equalTo(2));
    }
}


