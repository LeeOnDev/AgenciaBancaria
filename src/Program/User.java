package Program;

public class User {
	
	private static int counter = 1;
	
	private String name;
	private String nif;
	private String email;
	
	
	public User(String name, String nif, String email) {
		this.name = name;
		this.nif = nif;
		this.email = email;
		counter +=1;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String toString () {
		return "\nName: " + this.getName() + 
				"\nNif: " + this.getNif() +
				"\nEmail: " + this.getEmail();
	}
	
}
