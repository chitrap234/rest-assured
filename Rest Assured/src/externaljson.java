import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class externaljson {

	public static void main(String[] args) throws IOException {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String Response=given().queryParam("key", "qaclick123").header("Content-Type", "application/json").body(new String (Files.readAllBytes(Paths.get("E:\\JAva selenium and other videos\\API Notes\\staticjson.json")))).when().post("maps/api/place/add/json").then().assertThat().statusCode(200)
		.header("Server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
		
		//JsonPath js = new JsonPath(Response);
		//String place_Id = js.getString("place_id");
		System.out.println(Response);
		//System.out.println(place_Id);*/
		
	/*String Updateaddress = "newaddress";
	
	 given().queryParam("key", "qaclick123").header("Content_type","application/json").body("{\r\n"
				+ "\"place_id\":\""+place_Id+"\",\r\n"
				+ "\"address\":\""+Updateaddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "").when().put("maps/api/place/get/json").then().assertThat().statusCode(200);
		
		String ResponseAdd=given().queryParam("key", "qaclick123").queryParam("place_id", place_Id)
		.when().get("maps/api/place/get/json").then().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(ResponseAdd);
	JsonPath js2 = new JsonPath(ResponseAdd);
		
		String actualadd = js2.getString("address");
		System.out.println(actualadd);
		
		Assert.assertEquals(actualadd, Updateaddress);*/

	}

}
