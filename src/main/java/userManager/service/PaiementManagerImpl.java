package userManager.service;

import javax.jws.WebService;

@WebService(endpointInterface="userManager.service.PaiementManagerService", serviceName="PaiementManagerService", portName="PaiementManagerPort")
public class PaiementManagerImpl implements PaiementManagerService {

	@Override
	public float getPrice(String token, Command commande) {
		System.out.println("getPrice method has been invoked");


		return 0;
	}

	@Override
	public void pay(String token, Command commande) {
		System.out.println("pay method has been invoked");
		
		
		System.out.println(commande + " paye!");
	}



}
