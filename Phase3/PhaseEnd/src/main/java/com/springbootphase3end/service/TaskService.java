package com.springbootphase3end.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootphase3end.dao.TaskDao;
import com.springbootphase3end.entity.Tasks;

@Service
public class TaskService {
	private static List<Tasks> tasks = new ArrayList<Tasks>();

	@Autowired
	private TaskDao taskDao;

	public void addTask(String taskName, Date startDate, Date endDate, String description,
			String email, String severity) {
		tasks.add(new Tasks( taskName, startDate, endDate, description, email, severity));
		taskDao.save((new Tasks(taskName, startDate, endDate, description, email, severity)));
	}

	public List<Tasks> getAllTasks(String user) {
		List<Tasks> taskList = (List<Tasks>) taskDao.findAll();
		return taskList;
	}
	
	public Tasks retrieveTask(int id) {
        return taskDao.findById(id).get();
    }

    public void updateTask(Tasks task){
    		Optional<Tasks> t = Optional.ofNullable(taskDao.findById(task.getId()).get());
    		if (t.isPresent()){
    		    taskDao.delete(t.get());
    		    taskDao.save(t.get());
            }
    }
    public void deleteTask(int id) {
        taskDao.deleteById(id);
    }

}
