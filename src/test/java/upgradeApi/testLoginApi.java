package upgradeApi;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import common.BaseClass;
import common.Constants;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import model.Borrower;
import model.LoansInReview;

public class testLoginApi extends BaseClass {

	Borrower borrower = new Borrower();

	@SuppressWarnings("unchecked")
	@Test(priority = 0, enabled = true, groups = { "regression", "functional" })
	public void testLogin() {

		Response response = given().headers(getHeaders())
				.body(getRequestBody(Constants.USERNAME, Constants.PASSWORD, Constants.TOKEN)).when().post(RestAssured.baseURI)
				.then()
				.statusCode(200)
				.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("output.json"))
				.contentType(ContentType.JSON).extract().response();

		recordResponse(response);

		report.testcase = report.extent.createTest("testLogin", "PASSED");

	}

	@Test(priority = 0, enabled = true, groups = { "regression"})
	public void testInvalidUserLogin() {

		given().headers(getHeaders())
				.body(getRequestBody(Constants.INVALID_USERNAME, Constants.PASSWORD, Constants.TOKEN)).when().post(RestAssured.baseURI)
				.then()
				.statusCode(401).contentType(ContentType.JSON).extract().response();

		report.testcase = report.extent.createTest("testInvalidUserLogin", "PASSED");
	}




	private void recordResponse(Response response) {

		borrower.setFirstName(response.jsonPath().getString("firstName"));
		borrower.setUserId(response.jsonPath().getString("userId"));
		borrower.setUserUuid(response.jsonPath().getString("userUuid"));

		List<Object> loanApplications = new ArrayList<Object>();
		for (int i = 0; i < response.jsonPath().getList("loanApplications").size(); i++) {
			loanApplications.add(response.jsonPath().getList("loanApplications").get(i));
		}
		borrower.setLoanApplications(loanApplications);

		List<LoansInReview> loansInReview = new ArrayList<LoansInReview>();
		for (int i = 0; i < response.jsonPath().getList("loansInReview").size(); i++) {
			String json = new Gson().toJson(response.jsonPath().getList("loansInReview").get(i));
			Gson gson = new Gson();
			LoansInReview loan = gson.fromJson(json, LoansInReview.class);
			Assert.assertEquals(loan.getProductType(), "PERSONAL_LOAN");
			loansInReview.add(loan);

		}
		borrower.setLoansInReview(loansInReview);
	}

	private Map<String, String> getHeaders() {
		Map<String, String> headers = new HashMap<String, String>();

		headers.put("Content-Type", "application/json");
		headers.put("x-cf-source-id", "coding-challenge");
		headers.put("x-cf-corr-id", "18201c68-3e72-11eb-b378-0242ac130002");

		return headers;
	}

	@SuppressWarnings("unchecked")
	private String getRequestBody(String username, String password, String token) {
		JSONObject body = new JSONObject();
		body.put("username", username);
		body.put("password", password);
		body.put("recaptchaToken", token);

		return body.toJSONString();
	}

	@AfterClass
	public void tearDown() {
		report.extent.flush();

	}

	@AfterMethod
	public void getResult(ITestResult result) {
		report.getResult(result);
	}
}
