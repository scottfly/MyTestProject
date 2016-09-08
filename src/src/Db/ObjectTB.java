package src.Db;
import java.sql.Date;
import java.math.BigDecimal;

public class ObjectTB {
	
	private String id;					//与其他的表关联 对应object_id   
	private String entity_type;			//分3种type  company person products 
	private Long entity_id;
	private String parent_id;			//parent_id 关联company？
	private String normalized_name;
	private String category_code;
	private String permalink;
	private String name;
	private String founded_at;
	private String closed_at;
	private String domain;
	private String homepage_url;	
	private String logo_url;
	private String description;
	private String overview;
	private String city;
	private String region;
	private String first_investment_at;
	private String last_investment_at;
	private String first_funding_at;
	private String last_funding_at;
	private BigDecimal funding_total_usd;
	private String first_milestone_at;
	private String last_milestone_at;
	private int funding_rounds;			//关联 cb_funding_rounds表   以及 cd_funds表
	private int relationships;			//关联cb_relationships表
	private int investment_rounds;
	private int invested_companies;
	private int milestones;				//数量说明与cb_milestones表关联
	
	
	public String getCategory_code() {
		return category_code;
	}
	public void setCategory_code(String category_code) {
		this.category_code = category_code;
	}
	public String getClosed_at() {
		return closed_at;
	}
	public void setClosed_at(String closed_at) {
		this.closed_at = closed_at;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getFirst_investment_at() {
		return first_investment_at;
	}
	public void setFirst_investment_at(String first_investment_at) {
		this.first_investment_at = first_investment_at;
	}
	public String getLast_investment_at() {
		return last_investment_at;
	}
	public void setLast_investment_at(String last_investment_at) {
		this.last_investment_at = last_investment_at;
	}
	public String getFirst_funding_at() {
		return first_funding_at;
	}
	public void setFirst_funding_at(String first_funding_at) {
		this.first_funding_at = first_funding_at;
	}
	public String getLast_funding_at() {
		return last_funding_at;
	}
	public void setLast_funding_at(String last_funding_at) {
		this.last_funding_at = last_funding_at;
	}
	public BigDecimal getFunding_total_usd() {
		return funding_total_usd;
	}
	public void setFunding_total_usd(BigDecimal funding_total_usd) {
		this.funding_total_usd = funding_total_usd;
	}
	public String getFirst_milestone_at() {
		return first_milestone_at;
	}
	public void setFirst_milestone_at(String first_milestone_at) {
		this.first_milestone_at = first_milestone_at;
	}
	public String getLast_milestone_at() {
		return last_milestone_at;
	}
	public void setLast_milestone_at(String last_milestone_at) {
		this.last_milestone_at = last_milestone_at;
	}
		
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEntity_type() {
		return entity_type;
	}
	public void setEntity_type(String entity_type) {
		this.entity_type = entity_type;
	}
	public String getName() {
		return name;
	}
	public Long getEntity_id() {
		return entity_id;
	}
	public void setEntity_id(Long entity_id) {
		this.entity_id = entity_id;
	}
	public String getNormalized_name() {
		return normalized_name;
	}
	public void setNormalized_name(String normalized_name) {
		this.normalized_name = normalized_name;
	}
	public String getPermalink() {
		return permalink;
	}
	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getFounded_at() {
		return founded_at;
	}
	public void setFounded_at(String founded_at) {
		this.founded_at = founded_at;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getHomepage_url() {
		return homepage_url;
	}
	public void setHomepage_url(String homepage_url) {
		this.homepage_url = homepage_url;
	}
	public String getLogo_url() {
		return logo_url;
	}
	public void setLogo_url(String logo_url) {
		this.logo_url = logo_url;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getFunding_rounds() {
		return funding_rounds;
	}
	public void setFunding_rounds(int funding_rounds) {
		this.funding_rounds = funding_rounds;
	}
	public int getRelationships() {
		return relationships;
	}
	public void setRelationships(int relationships) {
		this.relationships = relationships;
	}
	public int getInvestment_rounds() {
		return investment_rounds;
	}
	public void setInvestment_rounds(int investment_rounds) {
		this.investment_rounds = investment_rounds;
	}
	public int getInvested_companies() {
		return invested_companies;
	}
	public void setInvested_companies(int invested_companies) {
		this.invested_companies = invested_companies;
	}
	public int getMilestones() {
		return milestones;
	}
	public void setMilestones(int milestones) {
		this.milestones = milestones;
	}
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	
	

}
