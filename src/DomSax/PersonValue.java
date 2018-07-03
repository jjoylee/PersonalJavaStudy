package DomSax;

public class PersonValue {
	
	private long id;
	private String name;
	private String company;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCompany() {
		return company;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("PersonValue [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", company=");
		builder.append(company);
		builder.append("]");
		return builder.toString();
	}
}
