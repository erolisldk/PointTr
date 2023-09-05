package pojos.US01;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class PointTrURL {

    public static RequestSpecification spec;

    @Before
    public void setup(){

        spec = new RequestSpecBuilder().setBaseUri("https://www.pointr.tech/").build();

    }
}
