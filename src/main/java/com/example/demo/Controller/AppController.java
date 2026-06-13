package com.example.demo.Controller;
import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.component.employee;
import com.example.demo.component.student;


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
	@GetMapping("/stuinfo")
	public student stuinfo() {
		return new student(101,120000,"abhinav prakash","Btech");
	}
	@GetMapping("/empinfo")
	public employee empinfo() {
		return new employee(100,"Abhinav","senior",40000);
	}
	@GetMapping("multirec")
	public List<student> multirec(){
		List<student> records = new ArrayList<>();
		records.add(new student(101,122222,"arun singh","btech"));
		records.add(new student(102,100000,"nihal kumbhak","mtech"));
		records.add(new student(103,200000,"sudheer ","high school"));
		records.add(new student(104,300000,"nitin","phd"));
		return records;
	}
	}

