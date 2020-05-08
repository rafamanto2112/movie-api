package br.com.vital.moviesapi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

	@Value("${info.app.version}")
	private String version;

	@ResponseBody
	@GetMapping("/healthCheck")
	public String healthCheck() {
		return "OK, version: " + version;
	}

}
