package com.taskmanager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    // Add a Task
    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Task added successfully!");
    }

    // List all Tasks
    public List<Task> getTasks() {
        return tasks;
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    // Update a Task
    public boolean updateTask(int id, String newTitle, String newDescription, String newPriority) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setTitle(newTitle);
                task.setDescription(newDescription);
                task.setPriority(newPriority);
                System.out.println("Task updated successfully!");
                return true;
            }
        }
        System.out.println("Task not found!");
        return false;
    }

    // Delete a Task
    public boolean deleteTask(int id) {
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getId() == id) {
                iterator.remove();
                System.out.println("Task deleted successfully!");
                return true;
            }
        }
        System.out.println("Task not found!");
        return false;
    }
}
