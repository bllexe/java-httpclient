package org.tigris.service;

import org.junit.Test;
import org.tigris.client.JsonPlaceHolderClient;
import org.tigris.modal.Todo;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TodoServiceTest {

    TodoService todoService=new TodoService(new JsonPlaceHolderClient());
    @Test
    public void giveNothingWhenGetAllTodosThenReturnAllTodos() throws IOException, InterruptedException {
        List<Todo> allTodos = todoService.getAllTodos();
        assertNotNull(allTodos);
        assertEquals(200, allTodos.size());
    }
     @Test
     public void giveTodosIdWhenGetTodoByIdThenReturnTodo() throws IOException, InterruptedException {
         Todo todoInDb = todoService.getTodoById(1);
         assertEquals(1,todoInDb.userId());
         assertEquals(1,todoInDb.id());
         assertFalse(todoInDb.completed());
     }
     @Test
     public void giveTodosWhenCreateTodoThenReturnTodo() throws IOException, InterruptedException {
         Todo todo =new Todo(1,201,"Learn Java",false);
         Todo todoINDb = todoService.createTodo(todo);
         assertEquals(1,todoINDb.userId());
         assertEquals(201,todoINDb.id());
         assertFalse(todoINDb.completed());
         assertEquals("Learn Java",todoINDb.title());
     }
     @Test
     public void giveTodosIdWhenDeleteTodoThenReturnTodo() throws IOException, InterruptedException {
         Todo todoInDb = todoService.getTodoById(1);
         HttpResponse<String> stringHttpResponse = todoService.deleteTodo(todoInDb);
         assertEquals(200,stringHttpResponse.statusCode());
     }
}