package belama.eclipse.model;

public class ChefProject {
	private int id;
	private String name;
	private String email;
	private String country;
	private String department;
	public ChefProject(String name, String email, String country, String department) {
		super();
		this.name = name;
		this.email = email;
		this.country = country;
		this.department = department;
	}
	
	public ChefProject(int id, String name, String email, String country, String department) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.country = country;
		this.department = department;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
}
