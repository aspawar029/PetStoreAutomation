package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProvider;
import io.restassured.response.Response;

public class DDTests {

	@Test(priority = 1 ,dataProvider ="Data", dataProviderClass =DataProvider.class)
	public void testPostUser(String userID , String userName , String fname ,String lname, String userEmail ,String pwd, String ph )
	{
		User userPayload = new User();
		
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUserName(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(userEmail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
		
		Response response = UserEndPoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority =2 , dataProvider = "UserNames" ,dataProviderClass = DataProvider.class)
	public void testDeleteUserByName(String userName)
	{
		Response response = UserEndPoints.deleteUser(userName);
		Assert.assertEquals(response.getStatusCode(),404);
	}
}
