package common;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseClass {

	public String url;
	public String OS;
	private Utility utility = new Utility();

	public Report report;
    public RequestSpecification REQUEST;

	
	public BaseClass() {
		
		RestAssured.baseURI = utility.getProperty(Constants.CONFIGURATION, "url");
		OS = utility.getProperty(Constants.CONFIGURATION, "OS");
		
		report = new Report(OS);
		report.startReport();

        //basic request setting
	}
	
	

}
