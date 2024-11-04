package org.tigris.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.tigris.modal.Todo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JsonPlaceHolderClient {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/todos";
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public JsonPlaceHolderClient() {
        this.httpClient = HttpClient.newHttpClient();
        objectMapper=new ObjectMapper();
    }

    public String getTodos() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .GET()
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String getTodoById(int id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/" + id))
                .GET()
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String  createTodo(Todo todo) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .setHeader("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(todo)))
                .build();
        return   httpClient.send(request, HttpResponse.BodyHandlers.ofString()).body();
    }

    public HttpResponse<String> deleteTodo(Todo todo) throws IOException, InterruptedException {
        HttpRequest request=HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/" + todo.id()))
                .DELETE()
                .build();
        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
