package com.epam.liavitskaya.main.controller.command.impl;

import com.epam.liavitskaya.main.controller.command.Command;
import com.epam.liavitskaya.main.service.ClientService;
import com.epam.liavitskaya.main.service.exception.ServiceException;
import com.epam.liavitskaya.main.service.provider.ServiceProvider;

public class DeleteUser implements Command {

	@Override
	public String execute(String request) {

		String response = null;
		
		// parse request		
		String substringWithId = request.substring(request.indexOf(" ") + 1, request.length());
		int id = Integer.parseInt(substringWithId);		
		ServiceProvider provider = ServiceProvider.getInstance();
		ClientService clientServiceImpl = provider.getClientServiceImpl();
		try {
			clientServiceImpl.deleteUser(id);
			response = "User is deleted";
		} catch (ServiceException e) {
			// log
			response = "Error during delete user procedure";
		}

		return response;
	}
}