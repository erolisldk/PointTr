package stepDefinitions.apiStepDefs;

import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;
import static pojos.US01.PointTrURL.spec;
import static utilities.Authentication2.generateToken;
public class RoomOlusturmaSteps {
    Response response;
  //  RoomPostBatch81 room = new RoomPostBatch81();
    @Given("user sends a post request for rooms data")
    public void user_sends_a_post_request_for_rooms_data() {
        spec.pathParams("bir", "api", "iki", "rooms");
        //Room data olusturma
     //   room.setRoomNumber(374839);
     //   room.setRoomType("DELUXE");
     //   room.setDescription("Medunna 81 api model post request 234");
     //   room.setPrice(300);
     //   room.setStatus(true);
  //     response = given().headers("Authorization", "Bearer " + generateToken()
  //             ,  "Content-Type", ContentType.JSON,
  //             "Accept", ContentType.JSON
  //     ).spec(spec).contentType(ContentType.JSON).body(room).when().post("/{bir}/{iki}");
    }
    @Given("user gets the room data and validates")
    public void user_gets_the_room_data_and_validates() {
        response.then().assertThat().statusCode(201);
    }
}