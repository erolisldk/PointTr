package stepDefinitions.apiStepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import pojos.US01.Register_Pojo;

import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;

public class US001_ApiStepDef {

    Faker faker = new Faker();

    Response response;

    Register_Pojo expectedData = new Register_Pojo();

    RequestSpecification spec;

    @Given("Kullanici path params olusturur..")
    public void kullanici_path_params_olusturur() {

        spec = new RequestSpecBuilder().setBaseUri("https://www.pointr.tech/").build();
        spec.pathParams("1", "api", "2", "register");
    }
    @Given("Kullanici expected data olusturur.")
    public void kullanici_expected_data_olusturur() {

      //  expectedData.setEmail(faker.internet().safeEmailAddress());
      //  expectedData.setFirstName(faker.name().firstName());
      //  expectedData.setLastName(faker.name().lastName());
      //  expectedData.setLogin(faker.name().username());
      //  expectedData.setPassword(faker.internet().password(8,10,true,true,true));
      //  expectedData.setSsn(faker.idNumber().ssnValid());
    }
    @When("Kullanici request gonderir response alir.")
    public void kullanici_request_gonderir_response_alir() {
        response = given().spec(spec).contentType(ContentType.JSON).
                header("Authorization","Bearer "+ generateToken()).
                body(expectedData).post("/{1}/{2}");
    }
    @When("Kullanici kayitlari dogrular.")
    public void kullanici_kayitlari_dogrular() {
        response.then().assertThat().statusCode(201);

        //Register_Pojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), Register_Pojo.class);

        Register_Pojo actualData = response.as(Register_Pojo.class);

      //  Assert.assertEquals(expectedData.getEmail(),actualData.getEmail());
      //  Assert.assertEquals(expectedData.getFirstName(),actualData.getFirstName());
      //  Assert.assertEquals(expectedData.getLastName(),actualData.getLastName());
      //  Assert.assertEquals(expectedData.getLogin(),actualData.getLogin());
      //  Assert.assertEquals(expectedData.getSsn(),actualData.getSsn());
    }

    @Given("Swagger dokumaninda gerekli bilgiler bulunmamaktadir")
    public void swaggerDokumanindaGerekliBilgilerBulunmamaktadir() {
        System.out.println("Swagger dokumaninda gerekli bilgiler bulunmamaktadir");
    }
}
