package com.taskmanager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TaskManagerGUI {
    private TaskManager taskManager;
    private JTextField titleField, descField, idField;
    private JComboBox<String> priorityBox;
    private JTextArea taskListArea;

    public TaskManagerGUI() {
        taskManager = new TaskManager();

        // Create Main Frame
        JFrame frame = new JFrame("Task Management System");
        frame.setSize(700, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create Panel for Input Fields
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        // Labels and Text Fields
        panel.add(new JLabel("Task ID:"));
        idField = new JTextField(5);
        panel.add(idField);

        panel.add(new JLabel("Title:"));
        titleField = new JTextField(20);
        panel.add(titleField);

        panel.add(new JLabel("Description:"));
        descField = new JTextField(20);
        panel.add(descField);

        panel.add(new JLabel("Priority:"));
        String[] priorities = {"High", "Medium", "Low"};
        priorityBox = new JComboBox<>(priorities);
        panel.add(priorityBox);

        // Buttons Panel
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Task");
        JButton listButton = new JButton("List Tasks");
        JButton updateButton = new JButton("Update Task");
        JButton deleteButton = new JButton("Delete Task");

        // Styling Buttons
        addButton.setBackground(Color.GREEN);
        addButton.setForeground(Color.WHITE);

        listButton.setBackground(Color.BLUE);
        listButton.setForeground(Color.WHITE);

        updateButton.setBackground(Color.ORANGE);
        updateButton.setForeground(Color.WHITE);

        deleteButton.setBackground(Color.RED);
        deleteButton.setForeground(Color.WHITE);

        buttonPanel.add(addButton);
        buttonPanel.add(listButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        // Task List Display Area
        taskListArea = new JTextArea(12, 50);
        taskListArea.setEditable(false);
        taskListArea.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(taskListArea);

        // Adding Components to Frame
        frame.add(panel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(scrollPane, BorderLayout.SOUTH);

        // Button Actions
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String description = descField.getText();
                String priority = (String) priorityBox.getSelectedItem();

                if (!title.isEmpty() && !description.isEmpty()) {
                    Task newTask = new Task(taskManager.getTasks().size() + 1, title, description, priority, new Date());
                    taskManager.addTask(newTask);
                    JOptionPane.showMessageDialog(frame, "Task Added Successfully!");
                    titleField.setText("");
                    descField.setText("");
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter Title and Description.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        listButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                taskListArea.setText("ID | Title | Description | Priority | Deadline\n");
                taskListArea.append("---------------------------------------------------------\n");
                for (Task task : taskManager.getTasks()) {
                    taskListArea.append(task.getId() + " | " + task.getTitle() + " | " + task.getDescription() + " | " + task.getPriority() + " | " + task.getDeadline() + "\n");
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    String newTitle = titleField.getText();
                    String newDescription = descField.getText();
                    String newPriority = (String) priorityBox.getSelectedItem();

                    if (!newTitle.isEmpty() && !newDescription.isEmpty()) {
                        taskManager.updateTask(id, newTitle, newDescription, newPriority);
                        JOptionPane.showMessageDialog(frame, "Task Updated Successfully!");
                        idField.setText("");
                        titleField.setText("");
                        descField.setText("");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Please enter valid details for updating.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid ID format!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    taskManager.deleteTask(id);
                    JOptionPane.showMessageDialog(frame, "Task Deleted Successfully!");
                    idField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid ID format!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new TaskManagerGUI();
    }
}
