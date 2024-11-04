package org.tigris;

import org.tigris.client.JsonPlaceHolderClient;
import org.tigris.modal.Todo;
import org.tigris.service.TodoService;

import java.io.IOException;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException, InterruptedException {

        JsonPlaceHolderClient client=new JsonPlaceHolderClient();
        TodoService todoService = new TodoService(client);
       //GetAllTodos
       //List<Todo> allTodos = todoService.getAllTodos();
       //allTodos.forEach(System.out::println);
       //GetOneTodoById
       //Todo todo = todoService.getTodoById(1);
       //System.out.println(todo);

        //createTodoOperation
//        Todo todo =new Todo(1,201,"Learn Java",false);
//        Todo todoINDb = todoService.createTodo(todo);
//        System.out.println(todoINDb);

        //deleteTodo operation
//        Todo todo =new Todo(1,201,"Learn Java",false);
//        Todo savedTodo = todoService.createTodo(todo);
//        System.out.println("Added successfully" + savedTodo);
//
//        String s = todoService.deleteTodo(todo);
//        System.out.println("Deleted successfully " + s);


    }
}