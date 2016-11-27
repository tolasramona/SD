package org.task;

import java.util.ArrayList;

import org.model.DVD;

public class TasksExecutor {
	
	private static final  ArrayList<Task> NEXT_TASKS= new ArrayList<Task>() {{
	    add(new LogginTask());
	    add(new EmailTask());
	   
	}};
	
	private Task start;
	
	public TasksExecutor(){
		start=new PersistanceTask();
		for (Task t: NEXT_TASKS){
			start.setNextTask(t);
		}
	}
	
	
	public void startExecution(DVD d){
		
		
		start.startExecution(d);
		
	}

}
