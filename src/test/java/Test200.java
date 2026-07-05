import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class Test200 {
    @Test
            public void status200(){
                given()
                .baseUri ("https://postman-echo.com/")
                .when()
                .get("/cookies")
                .then()
                .assertThat()
                .statusCode(200);
    }
}
