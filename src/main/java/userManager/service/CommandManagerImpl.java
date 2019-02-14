package userManager.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

@WebService(endpointInterface="userManager.service.commandManagerService", serviceName="CommandManagerService", portName="CommandManagerPort")
public class CommandManagerImpl implements CommandManagerService {
	
	Map<User,List<Command>> commandItems;
	//UserManagerImpl userManagerImpl = new UserManagerImpl();
	
	@Override
	public boolean addCommand(String token, List<Pizza> pizzas) throws Exception {
		if(UserManagerImpl.isValidToken(token) && token.startsWith("customer")) {
			User user = UserManagerImpl.getUserByToken(token);
			if(user != null && pizzas != null) {
				if(commandItems.containsKey(user)) {
					commandItems.get(user).add(new Command (user.getId(),pizzas));
				}else {
					List<Command> newCustomerCommands = new ArrayList<Command>();
					newCustomerCommands.add(new Command(user.getId(),pizzas));
					commandItems.put(user,newCustomerCommands);
				}
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Command> getCommands(String token) throws Exception {
		if(UserManagerImpl.isValidToken(token) && token.startsWith("customer")) {
			User user = UserManagerImpl.getUserByToken(token);	
			List<Command> commands = new ArrayList<Command> ();
			
		    Iterator it = commandItems.entrySet().iterator();
		    
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        if(((User)pair.getKey()).getId() == user.getId()) {
		        	if(!((Command) pair.getValue()).isPaid) {
		        		commands.add((Command) pair.getValue());
		        	}
		        }
		        it.remove(); // avoids a ConcurrentModificationException
		    }
		    
		    return commands;
		}throw new Exception();
	}

	@Override
	public List<Pizza> getPizzasCard() throws Exception {
		return UserManagerImpl.pizzas ;
	}

	@Override
	public boolean removeCommand(String token, int idCommand) throws Exception {
		if(UserManagerImpl.isValidToken(token) && token.startsWith("customer")) {
			User user = UserManagerImpl.getUserByToken(token);
			
		    Iterator it = commandItems.entrySet().iterator();
		    
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        if(((User)pair.getKey()).getId() == user.getId()) {
		        	if(((Command) pair.getValue()).getIdCommand()== idCommand) {
		        		commandItems.remove(key)
		        	}
		        }
		        it.remove(); // avoids a ConcurrentModificationException
		    }
		    }
		return false;
	}




}
