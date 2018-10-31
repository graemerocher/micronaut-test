package myapp;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.HttpStatus;
import io.micronaut.tracing.annotation.ContinueSpan;

@Controller("/hello")
public class HelloController {

    @ContinueSpan
    @Get("/")
    public HttpStatus index() {
        System.out.println("hi");
        return HttpStatus.OK;
    }
}