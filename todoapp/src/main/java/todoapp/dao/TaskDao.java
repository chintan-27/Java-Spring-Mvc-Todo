package todoapp.dao;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.scheduling.config.Task;

@Entity
public class TaskDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public void addOrUpdateTask(Task task) {
		
	}
	
	public void deleteTask(int id) {
		
	}

	public void getTasks(int userId) {
		
	}
}
 