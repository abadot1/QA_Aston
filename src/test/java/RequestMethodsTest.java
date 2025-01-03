import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class RequestMethodsTest {
    @Test
    public void getRequestTest() {
        given()
                .baseUri("https://postman-echo.com/")

                .when()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .get("get")

                .then()
                .assertThat()
                .statusCode(200)
                .body("args.foo1", Matchers.is("bar1"))
                .body("args.foo2", Matchers.is("bar2"))
                .log().body();
    }

    @Test
    public void postRawTextTest() {
        given()
                .baseUri("https://postman-echo.com/")

                .when()
                .body("This is expected to be sent back as part of response body.")
                .post("post")

                .then()
                .assertThat()
                .statusCode(200)
                .body("data", Matchers.is("This is expected to be sent back as part of response body."))
                .log().body();
    }

    @Test
    public void postFormDataTest() {
        given()
                .baseUri("https://postman-echo.com")

                .when()
                .contentType(ContentType.JSON)
                .body("{\"foo1\" : \"bar1\", \"foo2\" : \"bar2\"}")
                .post("/post")

                .then()
                .statusCode(200)
                .body("json.foo1", Matchers.is("bar1"))
                .body("json.foo2", Matchers.is("bar2"))
                .log().body();
    }

    @Test
    public void putRequestTest() {
        given()
                .baseUri("https://postman-echo.com/")

                .when()
                .body("This is expected to be sent back as part of response body.")
                .put("put")

                .then()
                .assertThat()
                .statusCode(200)
                .body("data", Matchers.is("This is expected to be sent back as part of response body."))
                .log().body();
    }

    @Test
    public void patchRequestTest(){
        given()
                .baseUri("https://postman-echo.com/")

                .when()
                .body("This is expected to be sent back as part of response body.")
                .patch("patch")

                .then()
                .assertThat()
                .statusCode(200)
                .body("data", Matchers.is("This is expected to be sent back as part of response body."))
                .log().body();
    }

    @Test
    public void deleteRequestTest(){
        given()
                .baseUri("https://postman-echo.com/")

                .when()
                .body("This is expected to be sent back as part of response body.")
                .delete("delete")

                .then()
                .assertThat()
                .statusCode(200)
                .body("data", Matchers.is("This is expected to be sent back as part of response body."))
                .log().body();
    }
}
