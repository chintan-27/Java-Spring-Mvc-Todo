package todoapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todoapp.dao.TaskDao;
import todoapp.models.Tasks;

@Service
public class TaskService {
	
	@Autowired(required = true)
	public TaskDao taskDao;
	
	public void addTask(Tasks task) {
		this.taskDao.addOrUpdateTask(task);
	}

	public List<Tasks> getTasks(int user_id){
		List<Tasks> tasks = this.taskDao.getTasks(user_id);
		return tasks;
	}
	
	public void deleteTask(int id) {
		taskDao.deleteTask(id);
	}
	
	public void updateTask(Tasks task) {
		this.taskDao.addOrUpdateTask(task);
	}
	
	public Tasks getTask(int id) {
		return this.taskDao.getTask(id);
	}
}
