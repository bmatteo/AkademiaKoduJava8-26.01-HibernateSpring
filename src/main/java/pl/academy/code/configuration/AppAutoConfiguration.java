package pl.academy.code.configuration;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("pl.academy.code.services.impl")
public class AppAutoConfiguration {
}
