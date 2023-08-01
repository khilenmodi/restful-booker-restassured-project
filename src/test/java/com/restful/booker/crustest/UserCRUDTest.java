package com.restful.booker.crustest;

import com.restful.booker.model.PostPojo;
import com.restful.booker.model.PutPatchPojo;
import com.restful.booker.testbase.TestBase;
import com.restful.booker.utils.TestUtils;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserCRUDTest extends TestBase {




    @Test
    public void createToken() {
        PostPojo postPojo = new PostPojo();
        postPojo.setUsername("admin");
        postPojo.setPassword("password123");
        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(postPojo)
                .post("/auth");
        response.prettyPrint();
        response.then().log().all().statusCode(200);
    }

@Test
    public void createBooking(){
  //  String email = TestUtils.getRandomValue() + "kamlesh1234@gmail.com";
    String username = "admin";
    String password = "password123";
    String firstname = TestUtils.getRandomValue() + "kamlesh";
    String lastname = TestUtils.getRandomValue() +"patel";
    int totalPrice = 250;
    boolean depositPaid = true;
    String additionalNeeds = TestUtils.getRandomValue() +"Breakfast";
   String checkingDates = "2022-09-05";
   String checkoutDates = "2022-09-15";


    PostPojo postPojo = new PostPojo();
    postPojo.setUsername(username);
    postPojo.setPassword(password);
    postPojo.setFirstname(firstname);
    postPojo.setLastname(lastname);
    postPojo.setTotalPrice(totalPrice);
    postPojo.setDepositPaid(depositPaid);
    postPojo.setBookingDates(checkingDates);
    postPojo.setBookingDates(checkoutDates);
    postPojo.setAdditionalNeeds(additionalNeeds);

    Response response = given().log().all()
            .header("Authorization","token = 47c54ba355e5c26")
            .header("Content-type","application/json")
            .when()
            .body(postPojo)
            .post("https://restful-booker.herokuapp.com/booking");
    response.prettyPrint();
    response.then().log().all().statusCode(200);


}

@Test
    public void getBookingWithFirstName(){
    String firstname = TestUtils.getRandomValue() + "kamlesh";

    PostPojo postPojo = new PostPojo();
    postPojo.setFirstname(firstname);
    Response response = given().log().all()
            .header("Authorization","token = 47c54ba355e5c26")
            .header("Content-type","application/json")
            .when()
            .body(postPojo)
            .get("https://restful-booker.herokuapp.com/booking");
    response.prettyPrint();
    response.then().log().all().statusCode(200);
}


@Test
    public void updateBooking(){
    String firstname = TestUtils.getRandomValue() + "jay";
    String lastname = TestUtils.getRandomValue() + "vaghani";
    int totalPrice = 400;
    boolean depositPaid = true;
    String additionalNeeds = TestUtils.getRandomValue() + "Bed and Breakfast";
    String checkingDates = "2022/01/07";
    String checkoutDates = "2022/01/20";


    PutPatchPojo putPatchPojo = new PutPatchPojo();
    putPatchPojo.setFirstname(firstname);
    putPatchPojo.setLastname(lastname);
    putPatchPojo.setTotalPrice(totalPrice);
    putPatchPojo.setDepositPaid(depositPaid);
    putPatchPojo.setBookingDates(checkingDates);
    putPatchPojo.setBookingDates(checkoutDates);
    putPatchPojo.setAdditionalNeeds(additionalNeeds);

    Response response = given().log().all()
            .header("Authorization","token = 47c54ba355e5c26")
            .header("Content-type","application/json")
            .when()
            .body(putPatchPojo)
            .put("https://restful-booker.herokuapp.com/booking");
    response.prettyPrint();
    response.then().log().all().statusCode(200);


}

@Test
    public void partialUpdateBooking(){
    String firstname = TestUtils.getRandomValue() + "Prime";
    String lastname = TestUtils.getRandomValue() + "Testing";

    PutPatchPojo putPatchPojo = new PutPatchPojo();
    putPatchPojo.setFirstname(firstname);
    putPatchPojo.setLastname(lastname);
    Response response = given().log().all()
            .header("Authorization", "Bearer 47c54ba355e5c26" )
            .header("Content-type","application/json")
            .when()
            .body(putPatchPojo)
            .patch("https://restful-booker.herokuapp.com/booking");
    response.prettyPrint();
    response.then().log().all().statusCode(200);
}

@Test
    public void deleteData(){
    Response response = given().log().all()
            .header("Authorization", "Bearer 47c54ba355e5c26" )
            .header("Content-type","application/json")
            .when()
            .delete("https://restful-booker.herokuapp.com/booking/307");
            response.prettyPrint();
            response.then().statusCode(204);

}




}
//http://localhost:8080/auth
//47c54ba355e5c26