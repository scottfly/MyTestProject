package src.Db;


import java.lang.Long;
import java.sql.Date;
import java.math.BigDecimal;


public class Acquisitions {
	private Long id;
	private Long acquisition_id;
	private String acquiring_object_id;					//这两个id均与cb_object相关
	private String acquired_object_id;					//
	private String term_code;
	private BigDecimal price_amount;
	private String price_currency_code;
	private Date acquired_at;
	private String source_url;
	private String source_description;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getAcquisition_id() {
		return acquisition_id;
	}
	public void setAcquisition_id(Long acquisition_id) {
		this.acquisition_id = acquisition_id;
	}
	public String getAcquiring_object_id() {
		return acquiring_object_id;
	}
	public void setAcquiring_object_id(String acquiring_object_id) {
		this.acquiring_object_id = acquiring_object_id;
	}
	public String getAcquired_object_id() {
		return acquired_object_id;
	}
	public void setAcquired_object_id(String acquired_object_id) {
		this.acquired_object_id = acquired_object_id;
	}
	public String getTerm_code() {
		return term_code;
	}
	public void setTerm_code(String term_code) {
		this.term_code = term_code;
	}
	public BigDecimal getPrice_amount() {
		return price_amount;
	}
	public void setPrice_amount(BigDecimal price_amount) {
		this.price_amount = price_amount;
	}
	public String getPrice_currency_code() {
		return price_currency_code;
	}
	public void setPrice_currency_code(String price_currency_code) {
		this.price_currency_code = price_currency_code;
	}
	public Date getAcquired_at() {
		return acquired_at;
	}
	public void setAcquired_at(Date acquired_at) {
		this.acquired_at = acquired_at;
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
