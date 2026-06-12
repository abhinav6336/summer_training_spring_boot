package com.example.demo.Controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@ResponseBody
public class AppController {
	
	@GetMapping("/intro")
	public String intro() {
		String message = "this is just a test ";
		return message;
	}
	@GetMapping("/greet")
	public String greet(@RequestParam String name) {
		return "hello "+name;
		}
	}
