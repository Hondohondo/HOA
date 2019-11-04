package hoa.api.services.ticket.microservices.basic_auth_service;

import com.github.cliftonlabs.json_simple.Jsoner;

import hoa.api.services.Services;
import hoa.api.services.ticket.microservices.basic_auth_service.verify.AllUsersVerify;

public class Basic_AuthFactory {
	
	public String init(String userName, String password) {
		AllUsersVerify allUsersVerify = new AllUsersVerify(userName, password);
		String json = allUsersVerify.toJson(Services.BasicAuthVerify);
		System.out.println("Factory: " + json);
		return Jsoner.prettyPrint(json);
	}

}
