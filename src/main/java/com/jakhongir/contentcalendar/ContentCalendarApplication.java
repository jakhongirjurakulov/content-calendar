package com.jakhongir.contentcalendar;

import com.jakhongir.contentcalendar.model.Content;
import com.jakhongir.contentcalendar.model.Status;
import com.jakhongir.contentcalendar.model.Type;
import com.jakhongir.contentcalendar.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class ContentCalendarApplication {
	public static void main(String[] args) {
		SpringApplication.run(ContentCalendarApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ContentRepository contentRepository) {
//		insert some data into the database
		return args -> {
			Content c = new Content(
					null,
					"Hello ChatGPT",
					"All about ChatGPT",
					Status.IDEA,
					Type.VIDEO,
					LocalDateTime.now(),
					null,
					""
			);
			contentRepository.save(c);
		};
	}
}
