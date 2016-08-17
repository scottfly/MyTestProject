package src.Db;

import java.lang.Long;
import java.sql.Date;

public class Milestones {

	private Long id;
	private String object_id;				//关联cb_object中数据
	private Date milestone_at;
	private String milestone_code;
	private String description;
	private String source_url;
	private String source_description;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getObject_id() {
		return object_id;
	}
	public void setObject_id(String object_id) {
		this.object_id = object_id;
	}
	public Date getMilestone_at() {
		return milestone_at;
	}
	public void setMilestone_at(Date milestone_at) {
		this.milestone_at = milestone_at;
	}
	public String getMilestone_code() {
		return milestone_code;
	}
	public void setMilestone_code(String milestone_code) {
		this.milestone_code = milestone_code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
