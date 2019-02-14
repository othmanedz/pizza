package userManager.service;

import java.util.List;
import javax.jws.WebService;

@WebService(name = "UserManagerService")
public interface UserManagerService {
	
	boolean register (String name, String password, String role);
	String signIn (String name, String password) throws Exception;
	void signOut(String token) throws Exception;
	List<User> getUsers(String token) throws Exception;
	boolean deleteUser(String token , int id);
	
	boolean addPizza(String token , String name, int price)throws Exception;
	List<Pizza> getPizzas() throws Exception;
	
}
