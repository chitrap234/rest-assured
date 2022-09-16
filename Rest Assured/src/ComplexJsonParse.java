import org.testng.Assert;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		
		int sum = 0;
		JsonPath js1 = new JsonPath(Payload.complexjson());
		// To get the count of couses present
		int size = js1.getInt("courses.size()");
		//System.out.println(size);
		
		//To print the purchase amount 
		int purchaseamount = js1.getInt("dashboard.purchaseAmount");
		//System.out.println(purchaseamount);
		
		//Print Title of the first course
		String Title=js1.get("courses[0].title");
	//	System.out.println(Title);
		//Print All course titles and their respective Prices
		
		for (int i=0;i<size;i++)
		{
		String Ctitle = js1.get("courses["+i+"].title");
		int price = js1.getInt("courses["+i+"].price");
	//	System.out.println(Ctitle);
		//System.out.println(price);
		}
		
		//System.out.println("Print no of copies sold by RPA Course");
		
		for (int i = 0;i<size;i++)
		{
			
			String coursetitle=js1.get("courses["+i+"].title");
			if (coursetitle.equalsIgnoreCase("RPA"))
			{
				int copiesnumber= js1.get("courses["+i+"].copies");
			//	System.out.println(copiesnumber);
				break;
				
				
			}
		}
				
			System.out.println("Verify if Sum of all Course prices matches with Purchase Amount");
			for (int j=0;j<size;j++)
			{
			int price = js1.getInt("courses["+j+"].price");
			int copies = js1.getInt("courses["+j+"].copies");
			//System.out.println(price);
			//System.out.println(copies);
			int total=price*copies;
			//System.out.println(total);
			sum= sum +total;
			
			
			}
			
			System.out.println(sum);
			int puramt = js1.getInt("dashboard.purchaseAmount");
			System.out.println(puramt);
			Assert.assertEquals(sum, puramt);
			
		
			
			
			
			
		}
		
		
		
		}
		


