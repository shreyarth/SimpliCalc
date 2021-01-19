package com.springbootphase3end.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbootphase3end.entity.Tasks;
import com.springbootphase3end.service.TaskService;

@Controller
@SessionAttributes("name")
public class TaskController {
	@Autowired
	TaskService taskService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class,
				new CustomDateEditor(dateFormat, false));
	}
	
	@GetMapping("/list-tasks")
	public String showTasks(ModelMap model) {
		String username = (String) model.get("username");
		model.put("tasks", taskService.getAllTasks(username));
		return "list-tasks";
	}
	
	
	@GetMapping("/addtask")
	public String addTaskPage(ModelMap model) {
		model.addAttribute("task", new Tasks("Default Task Name", new Date(), 
				new Date(), "Default Desc", "Default email",
				"Default severity"));
		return "task";
	}
	
	@PostMapping("/addtask")
	public  String addTaskPost(ModelMap model, @Valid Tasks task, BindingResult result) {
		if(result.hasErrors()) {
			return "task";
		}
		taskService.addTask(task.getTaskName(),
				task.getStartDate(), task.getEndDate(),
				task.getDescription(), task.getEmail(),
				task.getSeverity());
		
		return "redirect:/list-tasks";
	}
	
	@GetMapping("/updatetask")
	public String showUpdatePage(@RequestParam int id, ModelMap model) {
		Tasks task = taskService.retrieveTask(id);
		model.put("task", task);
		return "task";
	}
	
	@PostMapping("/updatetask")
	public String updateTask(ModelMap model, @Valid Tasks task,
			BindingResult result) {
		if(result.hasErrors()) {
			return "task";
		}
		task.setUser((String)model.get("name"));
		taskService.updateTask(task);
		return "redirect:/list-tasks";
	}
	
	@GetMapping("/deletetask")
	public String deleteTask(@RequestParam int id) {
		taskService.deleteTask(id);
		return "redirect:/list-tasks";
	}
	
}
