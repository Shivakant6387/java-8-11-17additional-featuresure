package org.example.java11;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsyncHttpClientExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        HttpClient client=HttpClient.newHttpClient();
        HttpRequest request=HttpRequest.newBuilder()
                .uri(URI.create("http://www.google.com")).build();
        CompletableFuture<Void>voidCompletableFuture=client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println);
        voidCompletableFuture.get();
    }
}
