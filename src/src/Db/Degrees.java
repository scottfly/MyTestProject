package src.Db;

import java.lang.Long;
import java.sql.Date;

public class Degrees {
	private Long id;
	private String object_id;						//¹ØÁªcb_people
	private String degree_type;
	private String subject;
	private String institution;
	private String graduated_at;
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
	public String getDegree_type() {
		return degree_type;
	}
	public void setDegree_type(String degree_type) {
		this.degree_type = degree_type;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public String getGraduated_at() {
		return graduated_at;
	}
	public void setGraduated_at(String graduated_at) {
		this.graduated_at = graduated_at;
	}
	
	

}
