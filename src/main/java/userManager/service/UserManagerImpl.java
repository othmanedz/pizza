package userManager.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;


@WebService(endpointInterface="userManager.service.UserManagerService", serviceName="UserManagerService", portName="UserManagerPort")
public class UserManagerImpl implements UserManagerService{
	
	 List<User> users;
	 static List<String> usedTokens = new ArrayList<String>();
	 
	 List<Pizza> pizzas;
	 
	 
	 public UserManagerImpl()
	 {
		 users =  new ArrayList<User>();
		 
	 }
	@Override
	public boolean register (String name, String password, String role){
		System.out.println("register method has been invoked:" + name);
		
		if (name == null || password == null || role==null) throw new NullPointerException("User is null");
			User user = new User(name,password,role);
			
			if(user != null) {
				for (User s : this.users) {
					 if ( s.verifyUser(name, password) ) {
						 return false;
					 }
				}
				users.add(user);
				return true;
			}
			return false;
	}
	 
	@Override
	public String signIn(String name, String password) throws Exception {
		System.out.println("SignIn method has been invoked:" + name);
		 String token="";
			for (User s : this.users) {
				   if ( s.verifyUser(name, password) ) {
					   switch(s.getRole()) {
					   case "admin":
						   token = getToken("admin"); 
						   break;
						case "customer":
							token = getToken("customer"); 
							break;
					   }
					   s.setToken(token);
					   this.usedTokens.add(token);
					   System.out.println("Token : "+token);
					   return token;
				   }
				} throw new Exception();
		}
		
	@Override
	public void signOut(String token) throws Exception{
		System.out.println("SignOut method has been invoked:" + token);
		
		boolean found=false;
		for (String s : usedTokens) {
			   if (s.contains(token)) {
				   for (User user : this.users) {
					   if(user.verifyUserToken(s)) {
						   user.setToken(null);
						   usedTokens.remove(s);;
						   found=true;
						   break;
					   }
				break;
			   }
			}
	}
		if(!found) throw new Exception();
	}
	
	@Override
	public List<User> getUsers(String token) throws Exception {
		System.out.println("getUsers method has been invoked");
		if(isValidToken(token) && token.startsWith("admin"))
		return users;
		else throw new Exception();
	}
	
	@Override
	public boolean deleteUser(String token, int id) {
		System.out.println("deleteUser method has been invoked:" + id);
		if(isValidToken(token) && token.startsWith("admin")) {
			for (User s : this.users) {
				if(s.getId()==id) {
					users.remove(id);
					return true;
				}
			}
		}
		return false;
	}
	@Override
	public boolean addPizza(String token, String name, int price) throws Exception {
		System.out.println("addPizza method has been invoked:" + name);
		if(isValidToken(token) && token.startsWith("admin")) {
			Pizza p = new Pizza(name, price);
			return pizzas.add(p);
		}return false;
	}
	
	@Override
	public List<Pizza> getPizzas() throws Exception {
		return pizzas;
	}
	
	
	//Manage tokens
	private String getToken(String role){
		StringBuilder builder = new StringBuilder();
		do {
		int count = 30;
		String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		while (count-- != 0) {
		int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
		builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		} while(isValidToken(builder.toString()));
		return role+builder.toString();
	}
	
	private boolean isValidToken(String test) {
		for (String s : this.usedTokens) {
			   if (s.contains(test)) {
			      return true;
			   }
			}
		   return false;
	}


	

}
