package nLayeredDemo.business.concretes;

import java.util.List;
import java.util.Scanner;

import nLayeredDemo.business.abstracts.UserService;
import nLayeredDemo.business.abstracts.VerificationService;
import nLayeredDemo.core.JLoggerService;
import nLayeredDemo.dataAccess.abstracts.UserDao;
import nLayeredDemo.entities.concretes.User;

public class UserManager implements UserService{

	static Scanner scan = new Scanner(System.in);
	private VerificationService verificationService;
	private UserDao dao;
	private JLoggerService jloggerService;
	
	
	
	
	
	
	public UserManager(VerificationService verificationService, UserDao dao, JLoggerService jloggerService) {
		super();
		this.verificationService = verificationService;
		this.dao = dao;
		this.jloggerService= jloggerService;
	}

	@Override
	public void signIn(User user) {
		if (user.geteMail() != null) {
			if (verificationService.checkIfRealPerson(user)) {
				System.out.println("Giris basarili.\nHosgeldiniz: " + user.getFirstName()+" "+user.getLastName());
			}else {
				System.out.println("Kullanici eklenemedi.");
			}
		}
		System.out.println("E-Mail bos geçilemez");
			
	}
 
	@Override
	public void signUp(User user) {

		System.out.print("Adinizi girin: ");
		user.setFirstName(scan.next());
		System.out.print("Soyadinizi girin: ");
		user.setLastName(scan.next());
		System.out.println("E-Mail adresinizi girin: ");
		user.seteMail(scan.next());
		System.out.println("Sifrenizi girin: ");
		user.setPassword(scan.next());
		if (!verificationService.checkIfRealPerson(user)) {
			System.out.println("Kullanici eklenemedi.");
			return;
		}
		for (User u : dao.getAll()) {
			if (u.geteMail().equals(user.geteMail())) {
				System.out.println("Kullanici zaten kayitli");
				return;
			}
			dao.add(user);
			JLoggerService.mailLog(user);
			System.out.println("Kullanici basariyla kayit oldu.");
		}
		
	}

	@Override
	public User getUser(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
