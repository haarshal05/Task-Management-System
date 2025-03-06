package com.taskmanager;

import java.util.Date;

public class Task {
    private int id;
    private String title;
    private String description;
    private String priority;
    private Date deadline;

    public Task(int id, String title, String description, String priority, Date deadline) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.deadline = deadline;
    }

    // Getters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getPriority() { return priority; }
    public Date getDeadline() { return deadline; }

    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setPriority(String priority) { this.priority = priority; }
    public void setDeadline(Date deadline) { this.deadline = deadline; }

    // Readable Task Representation
    @Override
    public String toString() {
        return "Task ID: " + id + " | Title: " + title + " | Priority: " + priority +
                "\nDescription: " + description + " | Deadline: " + deadline + "\n";
    }
}
