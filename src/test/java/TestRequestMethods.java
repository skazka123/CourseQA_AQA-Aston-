import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class TestRequestMethods {

    private final static String BASE_URI = "https://postman-echo.com/";
    private final static String TEXT_DATA = "This is expected to be sent back as part of response body.";

    @Test
    public void getRequestWoops_Status200() {
        given()
                .baseUri(BASE_URI) // Вынести
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                .assertThat()
                .statusCode(200)
                .and().body("args.foo1", equalTo("bar1"))
                .and().body("args.foo2", equalTo("bar2"));
    }

    @Test
    public void postRawText_Status200() {
        given()
                .baseUri(BASE_URI)
                .body(TEXT_DATA)
                .when()
                .post("/post")
                .then()
                .assertThat()
                .statusCode(200)
                .and().body("data", equalTo(TEXT_DATA));
    }

    @Test
    public void postFormData_Status200() {
        given()
                .baseUri(BASE_URI)
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .header("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8")
                .when()
                .post("/post")
                .then()
                .assertThat()
                .statusCode(200)
                .and().body("form.foo1", equalTo("bar1"))
                .and().body("form.foo2", equalTo("bar2"));
    }

    @Test
    public void putRequest_Status200() {
        given()
                .baseUri(BASE_URI)
                .body(TEXT_DATA)
                .when()
                .put("/put")
                .then()
                .assertThat()
                .statusCode(200)
                .and().body("data", equalTo(TEXT_DATA));
    }

    @Test
    public void patchRequest_Status200() {
        given()
                .baseUri(BASE_URI)
                .body(TEXT_DATA)
                .when()
                .patch("/patch")
                .then()
                .assertThat()
                .statusCode(200)
                .and().body("data", equalTo(TEXT_DATA));
    }

    @Test
    public void deleteRequest_Status200() {
        given()
                .baseUri(BASE_URI)
                .body(TEXT_DATA)
                .when()
                .delete("/delete")
                .then()
                .assertThat()
                .statusCode(200)
                .and().body("data", equalTo(TEXT_DATA));
    }
}
