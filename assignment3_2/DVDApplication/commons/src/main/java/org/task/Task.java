package org.task;

import org.model.DVD;

public abstract class Task {

	private Task nextTask = null;

	public void setNextTask(Task t) {
		if (nextTask == null) {
			nextTask = t;
		} else {
			nextTask.setNextTask(t);
		}
	}

	public void startExecution(DVD d) {
		this.execute(d);
		if (nextTask != null) {
			nextTask.startExecution(d);
		}
	}

	protected abstract void execute(DVD d);

}
