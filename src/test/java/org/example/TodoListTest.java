package org.example;

import org.example.pages.TodoListPage;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class TodoListTest extends BaseTest{

    @Test
    public void shouldCreateNewTask() {
        String taskText = "My new task";
        TodoListPage todoListPage = (TodoListPage) homePage.clickOnSectionWithTitle("TO DO LIST");

        var tasksBefore = todoListPage.getAllTasksByText(taskText).size();
        todoListPage.toggleNewTaskField().addTask(taskText);
        var tasksAfter = todoListPage.getAllTasksByText(taskText).size();

        assertEquals(tasksAfter, tasksBefore+1, "Task counter should be increased by 1");
    }

    @Test
    public void shouldDeleteCreatedTask() {
        String taskText = "Delete me";
        TodoListPage todoListPage = (TodoListPage) homePage.clickOnSectionWithTitle("TO DO LIST");

        todoListPage.toggleNewTaskField().addTask(taskText).addTask(taskText);
        var tasksBefore = todoListPage.getAllTasksByText(taskText).size();
        todoListPage.deleteTask(taskText);
        var tasksAfter = todoListPage.getAllTasksByText(taskText).size();

        assertEquals(tasksAfter, tasksBefore-1, "Task counter should be decreased by 1");
    }
}
