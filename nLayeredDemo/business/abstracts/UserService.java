package nLayeredDemo.business.abstracts;

import java.util.List;

import nLayeredDemo.entities.concretes.User;

public interface UserService {
	void signIn(User user);
	void signUp(User user);
	User getUser(String email);
	List<User> getAll();
}
