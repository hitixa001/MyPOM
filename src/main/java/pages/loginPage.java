package pages;

public class loginPage {

	int size;
	String username;
	String password;

	public loginPage(int size, String username, String password) {
		this.size = size;
		this.username = username;
		this.password = password;
	}

	public void login(String username, String password) {
		System.out.println("login to app.....");
	}

}
