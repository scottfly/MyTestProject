package src.Db;

import java.lang.Long;

public class Investments {

	private Long id;
	private Long funding_round_id;
	private String funded_object_id;					//¹ØÁªcb_object ÖÐid
	private String investor_object_id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getFunding_round_id() {
		return funding_round_id;
	}
	public void setFunding_round_id(Long funding_round_id) {
		this.funding_round_id = funding_round_id;
	}
	public String getFunded_object_id() {
		return funded_object_id;
	}
	public void setFunded_object_id(String funded_object_id) {
		this.funded_object_id = funded_object_id;
	}
	public String getInvestor_object_id() {
		return investor_object_id;
	}
	public void setInvestor_object_id(String investor_object_id) {
		this.investor_object_id = investor_object_id;
	}
	
	
	
}
