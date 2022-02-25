package com.techelevator;

import com.techelevator.dao.*;
import com.techelevator.model.*;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskListCLI {

    private final Scanner userInput = new Scanner(System.in);

    private final CategoryDao categoryDao;
    private final TaskDao taskDao;
    private final SubTaskDao subTaskDao;

    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/task-with-subtasks");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        TaskListCLI application = new TaskListCLI(dataSource);
        application.run();
    }

    public TaskListCLI(DataSource dataSource) {
        categoryDao = new JdbcCategoryDao(dataSource);
        taskDao = new JdbcTaskDao(dataSource);
        subTaskDao = new JdbcSubTaskDao(dataSource);
    }

    private void run() {
        displayBanner();
        boolean running = true;
        while (running) {
            displayMenu();
            int selection = promptForInt("Please select an option: ");
            if (selection == 1) {
                manageTaskInfo();
            } else if (selection == 2) {
                addNewTask();
            } else if (selection == 3) {
                running = false;
            } else {
                displayError("Invalid option selected.");
            }
        }
    }

    private void manageTaskInfo() {
        Task task = promptForTask();
        System.out.println();
        displayTask(task);
        String response = promptForString("(U)pdate this task, (D)elete this task, or press Enter to continue: ");
        if (response.equalsIgnoreCase("U")) {
            updateTask(task);
        } else if (response.equalsIgnoreCase("D")) {
            deleteTask(task);
        }
    }

    private void updateTask(Task taskToUpdate) {
        String newName = promptForString("New description (enter to leave unchanged): ");
        if (!newName.isBlank()) {
            taskToUpdate.setDescription(newName);
        }

        boolean complete = promptForYesNo("Is this task completed? ");
        taskToUpdate.setComplete(complete);

        LocalDate newDueDate = promptForDate("New due date (enter to leave unchanged): ");
        if (newDueDate != null) {
            taskToUpdate.setDueDate(newDueDate);
        }

        taskDao.updateTask(taskToUpdate);
        System.out.format("\nUpdated %s\n\n", taskToUpdate);
    }

    private void deleteTask(Task taskToDelete) {
        taskDao.deleteTask(taskToDelete.getId());
        System.out.format("\nDeleted %s\n\n", taskToDelete);
    }

    private void addNewTask() {
        Task newTask = promptForNewTaskData();
        newTask = taskDao.createTask(newTask);
        System.out.println("\nAdded the following task to the database:");
        displayTask(newTask);
    }

    private void displayBanner() {
        System.out.println("---------_--------------------------------");
        System.out.println("|  Welcome to the Task List Application  |");
        System.out.println("--------------------------_---------------");
    }

    private void displayMenu() {
        System.out.println("1. View or modify task information");
        System.out.println("2. Add new task");
        System.out.println("3. Exit");
        // TODO - Challenge (add ability to add/update/delete subtasks
    }

    private void displayError(String message) {
        System.out.println();
        System.out.println("***" + message + "***");
        System.out.println();
    }

    private void displayTask(Task task) {
        System.out.println(task);
        List<SubTask> subTasks = subTaskDao.getSubTasksByTask(task.getId());
        if (subTasks != null && subTasks.size() > 0) {
            System.out.println("Subtasks:");
            for (SubTask sub : subTasks) {
                System.out.println(sub);
            }
        }
    }

    private String promptForString(String prompt) {
        System.out.print(prompt);
        return userInput.nextLine();
    }

    private int promptForInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String response = userInput.nextLine();
            try {
                return Integer.parseInt(response);
            }  catch (NumberFormatException e) {
                if (response.isBlank()) {
                    return -1; //Assumes negative numbers are never valid entries.
                } else {
                    displayError("Numbers only, please.");
                }
            }
        }
    }

    private boolean promptForYesNo(String prompt) {
        while (true) {
            System.out.print(prompt);
            String response = userInput.nextLine();
            if (response.toUpperCase().startsWith("Y")) {
                return true;
            } else if (response.toUpperCase().startsWith("N")) {
                return false;
            } else {
                displayError("Enter (Y)es or (N)o, please.");
            }
        }
    }

    private LocalDate promptForDate(String prompt) {
        while (true) {
            System.out.print(prompt);
            String response = userInput.nextLine();
            if (response.isBlank()){
                return null;
            }
            try {
                return LocalDate.parse(response);
            }  catch (DateTimeParseException e) {
                displayError("Please format as YYYY-MM-DD.");
            }
        }
    }

    private Category promptForCategory() {
        while (true) {
            System.out.println("Category List:");
            List<Category> categoryList = categoryDao.getCategories();
            for (int i = 0; i < categoryList.size(); i++) {
                System.out.printf("%d %s\n", i+1, categoryList.get(i));
            }

            int response = promptForInt("Please enter a category number: ");
            if (response < 1 || response >= categoryList.size()) {
                displayError("Sorry that is not a valid option. Please try again.");
            } else {
                // Subtracting 1 to get zero based position
                Category result = categoryList.get(response-1);
                return result;
            }
        }
    }

    private Task promptForTask() {
        while (true) {
            List<Task> taskList = taskDao.getAllTasks();
            for (int i = 0; i < taskList.size(); i++) {
                System.out.printf("%d %s\n", i+1, taskList.get(i));
            }

            int response = promptForInt("Please enter a task number: ");
            if (response < 1 || response >= taskList.size()) {
                displayError("Sorry that is not a valid option. Please try again.");
            } else {
                // Subtracting 1 to get zero based position
                Task result = taskList.get(response-1);
                return result;
            }
        }
    }

    private Task promptForNewTaskData() {
        Task task = new Task();

        String description = "";
        while (description.isBlank()) {
            description = promptForString("Description: ");
        }
        task.setDescription(description);

        Category category = null;
        while (category == null) {
            category = promptForCategory();
        }
        task.setCategory(category);

        LocalDate date = null;
        date = promptForDate("Enter due date: ");
        task.setDueDate(date);

        return task;
    }

}
