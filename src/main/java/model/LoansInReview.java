package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoansInReview {

	private String id = "";
	private String uuid = "";
	private String status = "";
	private String productType = "";
	private String sourceSystem = "";
	private String hasOpenBackendCounter = "";
	private String purpose = "";
	private String createDate = "";
	private String postIssuanceStatus = "";
	
	@JsonProperty("id")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@JsonProperty("uuid")
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	@JsonProperty("status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@JsonProperty("productType")
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	@JsonProperty("sourceSystem")
	public String getSourceSystem() {
		return sourceSystem;
	}
	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}
	
	@JsonProperty("hasOpenBackendCounter")
	public String getHasOpenBackendCounter() {
		return hasOpenBackendCounter;
	}
	public void setHasOpenBackendCounter(String hasOpenBackendCounter) {
		this.hasOpenBackendCounter = hasOpenBackendCounter;
	}
	
	@JsonProperty("purpose")
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	
	@JsonProperty("createDate")
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	@JsonProperty("postIssuanceStatus")
	public String getPostIssuanceStatus() {
		return postIssuanceStatus;
	}
	public void setPostIssuanceStatus(String postIssuanceStatus) {
		this.postIssuanceStatus = postIssuanceStatus;
	}
}
