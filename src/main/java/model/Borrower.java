package model;

import java.util.ArrayList;
import java.util.List;

public class Borrower {
	private String firstName = "";
	private String userId = "";
	private String userUuid = "";
	private List<Object> loanApplications = new ArrayList<Object>();
	
	private List<LoansInReview> loansInReview = new ArrayList<LoansInReview>();

	public List<Object> getLoanApplications() {
		return loanApplications;
	}
	public List<LoansInReview> getLoansInReview() {
		return loansInReview;
	}
	public void setLoansInReview(List<LoansInReview> loansInReview) {
		this.loansInReview = loansInReview;
	}
	public void setLoanApplications(List<Object> loanApplications) {
		this.loanApplications = loanApplications;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserUuid() {
		return userUuid;
	}
	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}
	
	
}
