package dev.danvega.jpasecurity;

import dev.danvega.jpasecurity.Netty.TCPServer;
import dev.danvega.jpasecurity.model.User;
import dev.danvega.jpasecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@RequiredArgsConstructor
public class JpaSecurityApplication {

	@Autowired
	UserRepository userRepository;


	public static void main(String[] args) {
		SpringApplication.run(JpaSecurityApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner( UserRepository user, PasswordEncoder encoder) {
		if(!(userRepository.findByEmailAddress("movahedi78@gmail.com").isPresent())) {
			return args -> {
				user.save(new User("user", encoder.encode("password"), "movahedi78@gmail.com", "ROLE_USER"));
				user.save(new User("admin", encoder.encode("password"), "movahedisajjad@gmail.com", "ROLE_USER,ROLE_ADMIN"));
			};
		}

		return null;
	}

	private final TCPServer tcpServer;


	/**
	 * This can not be implemented with lambda, because of the spring framework limitation
	 * (https://github.com/spring-projects/spring-framework/issues/18681)
	 *
	 * @return
	 */
	@SuppressWarnings({"Convert2Lambda", "java:S1604"})
	@Bean
	public ApplicationListener<ApplicationReadyEvent> readyEventApplicationListener() {
		return new ApplicationListener<ApplicationReadyEvent>() {
			@Override
			public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
				tcpServer.start();

			}
		};
	}

}
