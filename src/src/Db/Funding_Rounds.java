package src.Db;

import java.lang.Long;
import java.sql.Date;
import java.math.BigDecimal;

public class Funding_Rounds {
	private Long id;
	private String object_id;						//¹ØÁªcb_object
	private Long funding_round_id;
	private Date funded_at;
	private String funding_round_type;
	private String funding_round_code;
	private BigDecimal raised_amount_usd;
	private BigDecimal raised_amount;
	
	private String raised_currency_code;
	private BigDecimal pre_money_valuation_usd;
	private BigDecimal pre_money_valuation;
	private String pre_money_currency_code;
	private BigDecimal post_money_valuation_usd;
	private BigDecimal post_money_valuation;
	private String post_money_currency_code;
	private int participants;
	private Boolean is_first_round;
	private Boolean is_last_round;
	private String source_url;
	private String source_description;
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
	public Date getFunded_at() {
		return funded_at;
	}
	public void setFunded_at(Date funded_at) {
		this.funded_at = funded_at;
	}
	public String getFunding_round_type() {
		return funding_round_type;
	}
	public void setFunding_round_type(String funding_round_type) {
		this.funding_round_type = funding_round_type;
	}
	public String getFunding_round_code() {
		return funding_round_code;
	}
	public void setFunding_round_code(String funding_round_code) {
		this.funding_round_code = funding_round_code;
	}
	public BigDecimal getRaised_amount_usd() {
		return raised_amount_usd;
	}
	public void setRaised_amount_usd(BigDecimal raised_amount_usd) {
		this.raised_amount_usd = raised_amount_usd;
	}
	public BigDecimal getRaised_amount() {
		return raised_amount;
	}
	public void setRaised_amount(BigDecimal raised_amount) {
		this.raised_amount = raised_amount;
	}
	public String getRaised_currency_code() {
		return raised_currency_code;
	}
	public void setRaised_currency_code(String raised_currency_code) {
		this.raised_currency_code = raised_currency_code;
	}
	public BigDecimal getPre_money_valuation_usd() {
		return pre_money_valuation_usd;
	}
	public void setPre_money_valuation_usd(BigDecimal pre_money_valuation_usd) {
		this.pre_money_valuation_usd = pre_money_valuation_usd;
	}
	public BigDecimal getPre_money_valuation() {
		return pre_money_valuation;
	}
	public void setPre_money_valuation(BigDecimal pre_money_valuation) {
		this.pre_money_valuation = pre_money_valuation;
	}
	public String getPre_money_currency_code() {
		return pre_money_currency_code;
	}
	public void setPre_money_currency_code(String pre_money_currency_code) {
		this.pre_money_currency_code = pre_money_currency_code;
	}
	public BigDecimal getPost_money_valuation_usd() {
		return post_money_valuation_usd;
	}
	public void setPost_money_valuation_usd(BigDecimal post_money_valuation_usd) {
		this.post_money_valuation_usd = post_money_valuation_usd;
	}
	public BigDecimal getPost_money_valuation() {
		return post_money_valuation;
	}
	public void setPost_money_valuation(BigDecimal post_money_valuation) {
		this.post_money_valuation = post_money_valuation;
	}
	public String getPost_money_currency_code() {
		return post_money_currency_code;
	}
	public void setPost_money_currency_code(String post_money_currency_code) {
		this.post_money_currency_code = post_money_currency_code;
	}
	public int getParticipants() {
		return participants;
	}
	public void setParticipants(int participants) {
		this.participants = participants;
	}
	public Boolean getIs_first_round() {
		return is_first_round;
	}
	public void setIs_first_round(Boolean is_first_round) {
		this.is_first_round = is_first_round;
	}
	public Boolean getIs_last_round() {
		return is_last_round;
	}
	public void setIs_last_round(Boolean is_last_round) {
		this.is_last_round = is_last_round;
	}
	public String getSource_url() {
		return source_url;
	}
	public void setSource_url(String source_url) {
		this.source_url = source_url;
	}
	public String getSource_description() {
		return source_description;
	}
	public void setSource_description(String source_description) {
		this.source_description = source_description;
	}
	public String getObject_id() {
		return object_id;
	}
	public void setObject_id(String object_id) {
		this.object_id = object_id;
	}
	
	
	
	

}
