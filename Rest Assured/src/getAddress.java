import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;

public class getAddress {

	public static void main(String[] args) {
		given().queryParam("key", "qaclick123").queryParam("place_id", "1ba919b71131c8571409b3720c966210")
				.when().get("maps/api/place/get/json").then().log().all().assertThat().statusCode(200).extract().response().asString();
				
				/*System.out.println(ResponseAdd);
			JsonPath js2 = new JsonPath(ResponseAdd);
				
				String actualadd = js2.getString("address");
				System.out.println(actualadd);*/
				

	}

}
