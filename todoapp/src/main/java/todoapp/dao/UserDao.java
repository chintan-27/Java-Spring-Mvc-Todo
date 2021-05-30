package todoapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import todoapp.models.User;

@Repository
public class UserDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int register(User user) {
		int id = (Integer) this.hibernateTemplate.save(user);
		return id;
	}
	

	public int login(String email, String password) {
		List<User> users = (List<User>) this.hibernateTemplate.find("from User where email = ?",email);
		if(users.size() > 0) {
			User user = users.get(0);
			String pass = user.getPassword();
			if(pass.equals(password)) {
				return user.getId();
			}else {
				return 0;
			}
		}
		else {
			return 0;
		}
		
	}
	
	public User getUser(int id) {
		User user = this.hibernateTemplate.get(User.class,id);
		return user;
	}
	
}
