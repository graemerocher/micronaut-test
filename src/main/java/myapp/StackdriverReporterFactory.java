package myapp;

import com.google.auth.oauth2.GoogleCredentials;
import io.grpc.CallOptions;
import io.grpc.auth.MoreCallCredentials;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import zipkin2.reporter.Sender;

import javax.inject.Singleton;
import java.io.IOException;
import java.util.Collections;

@Factory
public class StackdriverReporterFactory {
    @Bean
    @Singleton
    public Sender stackDriverSender(
        StackdriverConfiguration stackdriverConfiguration) throws IOException {

        var credentials = GoogleCredentials.getApplicationDefault()
            .createScoped(Collections.singletonList("https://www.googleapis.com/auth/trace.append"));

        var sender = stackdriverConfiguration.builder
            .callOptions(CallOptions.DEFAULT.withCallCredentials(MoreCallCredentials.from(credentials)))
            .build();

        return sender;
    }
}
