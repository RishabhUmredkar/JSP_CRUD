package Model;

public class User {
	
	private int id;
	private String uname;
	private String email;
	private String pass;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id) {
		super();
		this.id = id;
	}
	public User(String uname, String email, String pass) {
		super();
		this.uname = uname;
		this.email = email;
		this.pass = pass;
	}
	public User(int id, String uname, String email, String pass) {
		super();
		this.id = id;
		this.uname = uname;
		this.email = email;
		this.pass = pass;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "user [id=" + id + ", uname=" + uname + ", email=" + email + ", pass=" + pass + "]";
	}
	
	

}
