package todoapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import todoapp.models.Tasks;
import todoapp.models.User;
import todoapp.services.AuthService;
import todoapp.services.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskController {
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(path = "")
	public String tasks(@RequestParam String user_id, Model model) {
		int id = Integer.parseInt(user_id);
		List<Tasks> tasks = this.taskService.getTasks(id); 
		model.addAttribute("user_id", id);
		model.addAttribute("tasks",tasks);
		return "tasks";
	}
	
	@RequestMapping(path = "/add_task")
	public String addtask(@RequestParam String user_id, Model model) {
		int id = Integer.parseInt(user_id);
		model.addAttribute("user_id", id);
		return "add_task";
	}
	@RequestMapping(path = "/handletask", method = RequestMethod.POST)
	public RedirectView handleTask(@RequestParam("task") String task, @RequestParam String user_id, HttpServletRequest s) {
		int id = Integer.parseInt(user_id);
		User user = authService.getUser(id); 
		Tasks task1 = new Tasks();
		task1.setUser(user);
		task1.setCompleted(false);
		task1.setTask(task);
		taskService.addTask(task1);
		RedirectView view = new RedirectView();
		view.setUrl("/todoapp/tasks?user_id="+user_id);
		return view;
	}
	
	@RequestMapping(path="/deletetask")
	public RedirectView deleteTask(@RequestParam String id, @RequestParam String user_id) {
		this.taskService.deleteTask(Integer.parseInt(id));
		RedirectView view = new RedirectView("/todoapp/tasks?user_id="+user_id);
		return view;
	}
	
	@RequestMapping(path="/taskcomplete")
	public RedirectView updateTask(@RequestParam String id, @RequestParam String user_id) {
		Tasks task = this.taskService.getTask(Integer.parseInt(id));
		this.taskService.updateTask(task); 
		RedirectView view = new RedirectView("/todoapp/tasks?user_id="+user_id);
		return view;
	}
}
