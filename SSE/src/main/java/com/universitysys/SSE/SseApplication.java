package com.universitysys.SSE;

import com.universitysys.SSE.service.StatisticService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SseApplication {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SseApplication.class);
	}
	public static void main(String[] args)
	{
		SpringApplication.run(SseApplication.class, args);
	}
	}
