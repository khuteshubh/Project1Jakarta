package example.bean;

public class User {
	private String userName ;
	private String password ;
	
//	public User(String userName, String password) {
//		
//		this.userName = userName;
//		this.password = password;
//	}

	public User(String userId, String password1) {
		// TODO Auto-generated constructor stub
		userName = userId;
		password = password1;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + "]";
	}
	

}
