package src.Db;

public class PeopleTB 
{
	private int id; 				//¹ØÁªcb_degrees±í
	private String object_id;
	private String first_name;
	private String last_name;
	private String bithplace;
	private String affiliation_name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getObject_id() {
		return object_id;
	}
	public void setObject_id(String object_id) {
		this.object_id = object_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getBithplace() {
		return bithplace;
	}
	public void setBithplace(String bithplace) {
		this.bithplace = bithplace;
	}
	public String getAffiliation_name() {
		return affiliation_name;
	}
	public void setAffiliation_name(String affiliation_name) {
		this.affiliation_name = affiliation_name;
	}
	
	
}
