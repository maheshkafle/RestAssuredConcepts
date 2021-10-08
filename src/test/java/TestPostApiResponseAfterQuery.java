import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TestPostApiResponseAfterQuery {

    @Test
    void post_req(){
        RestAssured.baseURI ="https://reqres.in/api/users";
        String payload = "{"+
                "\"email\" : \"hello@gmail.com\", " +
                "\"first_name\" : \"Mahesh\", + " +
                "\"last_name\" : \"Kafle\", + " +
                "}" ;
        given()
                .body(payload)
        .when()
                .post()
        .then().log().all()
                .assertThat().statusCode(201)
                .body("id",is(notNullValue()));
    }
}
