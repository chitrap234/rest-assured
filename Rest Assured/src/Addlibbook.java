

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class Addlibbook {

	@Test(dataProvider="BookData")
	
	public void addbook(String isbn, String aisel)
	{
		RestAssured.baseURI = "http://216.10.245.166";
		
		String response = given().log().all().header("content-Type","application/json").body(Payload.addbookpayload(isbn,aisel))
		.when().post("Library/Addbook.php").then().log().all().statusCode(200).extract().response().asString();
		
		JsonPath js = new JsonPath(response);
		String res = js.get("ID");
		
		System.out.println(res);
		
		
	}
	
	@DataProvider(name="BookData")
	
	public  Object[][] getData()
	
	{
		
		return new Object[][] {{"hello","1234"},{"world","3214"},{"welcome","3398"}};
		
		
	}
		
		
	}
	
	
	
	
	

