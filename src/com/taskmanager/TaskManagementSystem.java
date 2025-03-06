package com.taskmanager;

import java.util.Scanner;
import java.util.Date;

public class TaskManagementSystem {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTask Management System");
            System.out.println("1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Open GUI");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add Task
                    System.out.print("Enter Task ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter Description: ");
                    String description = scanner.nextLine();

                    System.out.print("Enter Priority (High/Medium/Low): ");
                    String priority = scanner.nextLine();

                    manager.addTask(new Task(id, title, description, priority, new Date()));
                    break;

                case 2:
                    // List Tasks
                    manager.listTasks();
                    break;

                case 3:
                    // Update Task
                    System.out.print("Enter Task ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter New Title: ");
                    String newTitle = scanner.nextLine();

                    System.out.print("Enter New Description: ");
                    String newDescription = scanner.nextLine();

                    System.out.print("Enter New Priority (High/Medium/Low): ");
                    String newPriority = scanner.nextLine();

                    manager.updateTask(updateId, newTitle, newDescription, newPriority);
                    break;

                case 4:
                    // Delete Task
                    System.out.print("Enter Task ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();

                    manager.deleteTask(deleteId);
                    break;

                case 5:
                    // Open GUI
                    System.out.println("Launching GUI...");
                    new TaskManagerGUI();
                    break;

                case 6:
                    // Exit
                    System.out.println("Exiting Task Management System...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
