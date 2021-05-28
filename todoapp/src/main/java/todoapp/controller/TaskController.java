package todoapp.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/tasks")
public class TaskController {
	
	@RequestMapping(path = "/add_task")
	public String addtask() {
		return "add_task";
	}
	@RequestMapping(path = "/handletask", method = RequestMethod.POST)
	public RedirectView handleTask(@RequestParam("task") String task,@RequestParam("isCompleted") Boolean isCompleted,@RequestParam("user") int user_id
			,HttpServletRequest s) {
		System.out.println(task+" "+isCompleted+" "+ user_id);
		RedirectView view = new RedirectView();
		String path = s.getContextPath();
		System.out.println(path);
		view.setUrl("/todoapp/auth/login");
		return view;
	}
}
