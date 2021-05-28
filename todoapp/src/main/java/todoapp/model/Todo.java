package todoapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todo {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String task;
	private String description;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Todo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Todo(int id, String task, String description, String status) {
		super();
		this.id = id;
		this.task = task;
		this.description = description;
		this.status = status;
	}
	
	
	
}
