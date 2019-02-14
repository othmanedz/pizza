package userManager.service;

import javax.jws.WebService;

@WebService(name = "PaiementManagerService")
public interface PaiementManagerService {

	float getPrice(String token, Command commande);
	
	void pay(String token, Command commande);
}
