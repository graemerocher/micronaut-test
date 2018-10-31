package myapp;

import io.micronaut.context.annotation.ConfigurationBuilder;
import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.runtime.ApplicationConfiguration;
import zipkin2.reporter.stackdriver.StackdriverSender;

import java.util.Optional;
import java.util.function.Consumer;

@ConfigurationProperties("stackdriver")
public class StackdriverConfiguration {

    @ConfigurationBuilder(prefixes = "") // stackdriver.project-id: blah
    StackdriverSender.Builder builder = StackdriverSender.newBuilder();

    public StackdriverConfiguration(ApplicationConfiguration applicationConfiguration) {
    }
}
