package todoapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import todoapp.models.Tasks;

@Repository
public class TaskDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public void addOrUpdateTask(Tasks task) {
		this.hibernateTemplate.saveOrUpdate(task);
	}
	
	@Transactional
	public void deleteTask(int id) {
		Tasks task = this.hibernateTemplate.load(Tasks.class, id);
		this.hibernateTemplate.delete(task);
	}
	
	@SuppressWarnings("deprecation")
	@Transactional
	public void taskComplete(int id) {
		String query = "update Tasks set isCompleted = ? where id = ?";
		Object[] queryparam = {true, id};
		this.hibernateTemplate.bulkUpdate(query, queryparam);
	}
	public Tasks getTask(int id) {
		Tasks task = (Tasks) this.hibernateTemplate.load(Tasks.class, id);
		return task;
	}
	
	public List<Tasks> getTasks(int userId) {
		
		List<Tasks> tasks = (List<Tasks>)this.hibernateTemplate.find("from Tasks where user_id=?", userId);
		return tasks;
	}
}
 