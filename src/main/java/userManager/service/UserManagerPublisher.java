package userManager.service;

import javax.xml.ws.Endpoint;

public class UserManagerPublisher {
	public static void main(String[] args) throws ClassNotFoundException {
		Endpoint.publish("http://localhost:9999/ws/UserManager", new UserManagerImpl());
	}

}
