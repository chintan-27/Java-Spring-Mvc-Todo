package todoapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todoapp.dao.UserDao;
import todoapp.models.User;

@Service
public class AuthService {

	@Autowired
	public UserDao userDao;
	
	public int register(User user) {
		return userDao.register(user);
	}
	
	public int login(String email, String password) {
		int id = userDao.login(email, password);
		return id;
	}
	
	public User getUser(int id) {
		return userDao.getUser(id);
	}
}
