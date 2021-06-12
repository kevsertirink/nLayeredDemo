package nLayeredDemo.core;

import nLayeredDemo.entities.concretes.User;

public class JLoggerManager implements JLoggerService{

	public void mailLog(User user) {
        System.out.println("Dogrulama maili yollandý");	
	}

}
