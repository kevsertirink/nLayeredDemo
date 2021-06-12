package nLayeredDemo.GoogleAuthorization;

import nLayeredDemo.business.abstracts.VerificationService;
import nLayeredDemo.entities.concretes.User;

public class AuthenticatorManager implements VerificationService{
    
	
	
	
	@Override

	public boolean checkIfRealPerson(User user) {
		AuthenticatorManager googleAuth = new AuthenticatorManager();
		googleAuth.register();
		
		return true;
	}

	public void register() {
		System.out.println("Google Authorization kullanilarak üye olundu.");
		
	}
}