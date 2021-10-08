import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class TestDeleteApiResponseAfterQuery {

    @Test
    void delete_req(){
        RestAssured.baseURI ="https://reqres.in/api/users/2";
        given()
        .when()
            .delete()
        .then().log().all()
            .assertThat().statusCode(204);
    }
}
