package src.Db;

import java.lang.Long;
import java.sql.Date;
import java.math.BigDecimal;


public class Funds {
	private Long id;
	private Long fund_id;
	private String object_id;						//¹ØÁªcb_object
	private String name;
	private Date funded_at;
	private BigDecimal raised_amount;
	private String raised_currency_code;
	private String source_url;
	private String source_description;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getFund_id() {
		return fund_id;
	}
	public void setFund_id(Long fund_id) {
		this.fund_id = fund_id;
	}
	public String getObject_id() {
		return object_id;
	}
	public void setObject_id(String object_id) {
		this.object_id = object_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getFunded_at() {
		return funded_at;
	}
	public void setFunded_at(Date funded_at) {
		this.funded_at = funded_at;
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
	
	

}
