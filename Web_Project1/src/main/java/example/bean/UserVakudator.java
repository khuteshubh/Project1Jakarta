package example.bean;

public class UserVakudator {
	public static boolean isValid(User userObject) {
		
		boolean result = false;
		String currentuserId = userObject.getUserName();
		String currentPassword = userObject.getPassword();
		
		if(currentuserId.equals("admin") && currentPassword.equals("phonix123")) {
			result = true;
			
		}
		return result;
	}

}

