package restAPITest;

import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import main.TestBase;
import post.Category;
import post.PetData;
import post.Tags;

public class TC1_PetsAPITest extends TestBase {
	Category category;
	Tags tags;
	PetData petdata;
	
	
	public TC1_PetsAPITest() {
		super();
	}
	
	@Test(priority=1)
	public void getTest() {
		given()
		.when()
		.get(prop.getProperty("baseURI")+prop.getProperty("basePath")+prop.getProperty("petStatus"))
		.then()
		.statusCode(200)
		.body("status", hasItems("available"))
		.body("name", hasItems("doggie"))
		.log().all();
	}
	
	@Test(priority=2)
	public void postTest() {
		category=new Category(3,"string");
		tags=new Tags(3,"string");
		petdata=new PetData(3,category,"enzo",null,tags,"available");
		
		//RestAssured Request
		RestAssured.baseURI=prop.getProperty("baseURI");
				given()
				.contentType("application/json")
				.body(petdata)
				.when()
				.post()
				.then()
				.log().all();
				
	}
	
	@Test(priority=3)
	public void updateTest() {
		category=new Category(3,"string");
		tags=new Tags(3,"string");
		petdata=new PetData(3,category,"enzo",null,tags,"Sold");
		
		
		given()
		.contentType("application/json")
		.body(petdata)
		.when()
		.put(prop.getProperty("baseURI"))
		.then()
		.statusCode(200)
		.log().all();
	}
	
	@Test(priority=4)
	public void deleteTest() {
		RestAssured.baseURI=prop.getProperty("baseURI");
		RestAssured.basePath="/3";
		
		given()
		.when()
		.delete()
		.then()
		.statusCode(200);
	}

}
