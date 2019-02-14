package userManager.service;


public class User {
	static int random=0;
	

	int id;
	String name,password;
	String role;
	
	
	String token=null; //i am not sure if i need it as an attribute or not !!

	public User() {
		
	}
	
	public User (String name, String password, String role) throws IllegalArgumentException
	{
			if(name.equals("") || name==null || password.equals("") || password == null || role.equals("") || role == null )
				throw new IllegalArgumentException();
			this.name = name;
			this.password = password;
			this.role=role;
			System.out.println(random);
			id = random++;

	}
	
	public static int getRandom() {
		return random;
	}

	public static void setRandom(int random) {
		User.random = random;
	}

	public int getId() {
		return id;
	}

	public void setId(int number) {
		this.id = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
	//verify user
	public boolean verifyUser(String name, String password)
	{
		return this.name.equals(name) && this.password.equals(password);
	}
	//verify Token
	public boolean verifyUserToken(String token)
	{
		return this.token.equals(token);
	}
}
