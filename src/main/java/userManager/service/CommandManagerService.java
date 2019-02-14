package userManager.service;

import javax.jws.WebService;

@WebService(name = "CommandManagerService")
public interface CommandManagerService {
	
	boolean command(String token, int pizza);
	

}
