package project.quickreminder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.web.reactive.function.server.RouterFunction;

import project.quickreminder.service.EmailSenderService;

@SpringBootApplication
public class App {

	@Autowired
	private EmailSenderService senderService;
	
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

 
    
    
    @Bean
    public RouterFunction<?> routes(WelcomeHandler welcomeHandler, GreetingHandler greetingHandler) {
        return welcomeHandler.routes()
            .and(greetingHandler.routes());
    }
}

