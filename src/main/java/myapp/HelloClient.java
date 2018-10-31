package myapp;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;

@Client("/")
public interface HelloClient {

    @Get("/{name}")
    String greet(String name);
}
