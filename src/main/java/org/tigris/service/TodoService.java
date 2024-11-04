package org.tigris.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.tigris.client.JsonPlaceHolderClient;
import org.tigris.modal.Todo;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

public class TodoService {

    private final JsonPlaceHolderClient client;
    private final ObjectMapper objectMapper;

    public TodoService(JsonPlaceHolderClient client) {
        this.client=client;
        this.objectMapper=new ObjectMapper();
    }

    public List<Todo> getAllTodos() throws IOException, InterruptedException {
        String todos = client.getTodos();
        return objectMapper.readValue(todos, new TypeReference<List<Todo>>() {});
    }

    public Todo getTodoById(int id) throws IOException, InterruptedException {
        String todo = client.getTodoById(id);
        return objectMapper.readValue(todo, new TypeReference<Todo>() {});
    }

    public Todo createTodo(Todo todo) throws IOException, InterruptedException {
        String todoInDb = client.createTodo(todo);
        return objectMapper.readValue(todoInDb, new TypeReference<Todo>() {});
    }

    public HttpResponse<String> deleteTodo(Todo todo) throws IOException, InterruptedException {
        return client.deleteTodo(todo);
    }



}
