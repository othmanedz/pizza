package userManager.service;

import java.util.List;

public class Command {
	static int random=0;
	

	int idCommand,idUser;
	List<Pizza> commandedPizzas;
	boolean isPaid;

	
	public Command() {}
	
	public Command(int idUser, List<Pizza> pizzas) {
		
		this.idUser=idUser;
		this.commandedPizzas=pizzas;
		
		this.idCommand=random++;
	}
	
	public int getIdCommand() {
		return idCommand;
	}

	public void setIdCommand(int idCommand) {
		this.idCommand = idCommand;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public List<Pizza> getCommandedPizzas() {
		return commandedPizzas;
	}

	public void setCommandedPizzas(List<Pizza> commandedPizzas) {
		this.commandedPizzas = commandedPizzas;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	
}
