package src.Db;

import java.lang.Long;
import java.sql.Date;;

public class Relationships {

	private Long id;
	private Long relationship_id;
	private String person_object_id;			//关联cb_people
	private String relationship_object_id;		//关联cb_object
	private Date start_at;
	private Date end_at;
	private Boolean is_past;
	private int sequence;
	private String title;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRelationship_id() {
		return relationship_id;
	}
	public void setRelationship_id(Long relationship_id) {
		this.relationship_id = relationship_id;
	}
	public String getPerson_object_id() {
		return person_object_id;
	}
	public void setPerson_object_id(String person_object_id) {
		this.person_object_id = person_object_id;
	}
	public String getRelationship_object_id() {
		return relationship_object_id;
	}
	public void setRelationship_object_id(String relationship_object_id) {
		this.relationship_object_id = relationship_object_id;
	}
	public Date getStart_at() {
		return start_at;
	}
	public void setStart_at(Date start_at) {
		this.start_at = start_at;
	}
	public Date getEnd_at() {
		return end_at;
	}
	public void setEnd_at(Date end_at) {
		this.end_at = end_at;
	}
	public Boolean getIs_past() {
		return is_past;
	}
	public void setIs_past(Boolean is_past) {
		this.is_past = is_past;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
}
