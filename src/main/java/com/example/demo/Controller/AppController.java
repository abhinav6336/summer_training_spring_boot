package com.example.demo.Controller;
import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.component.employee;
import com.example.demo.component.student;


@Controller
@ResponseBody
public class AppController {
	List<student> records = new ArrayList<>();
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
	//	List<student> records = new ArrayList<>();
		records.add(new student(101,122222,"arun singh","btech"));
		records.add(new student(102,100000,"nihal kumbhak","mtech"));
		records.add(new student(103,200000,"sudheer ","high school"));
		records.add(new student(104,300000,"nitin","phd"));
		records.add(new student(105,400000,"satish kumar","bsc"));
		return records;
	}
	@GetMapping("/whoami/{name}/{address}")
	public String whoami(@PathVariable String name ,@PathVariable String address) {
		String msg = "Name = "+name+"<br>"+" Address = "+address;
		return msg;
	}
	@GetMapping("/find/{rollno}")
	public String find(@PathVariable int rollno) {
		multirec();
		String message="";
		for(student s : records) {
			if(s.getRolno()==rollno) {
				message = "Name : "+s.getName()+"<br>"+"Fees : "+s.getFees()+"<br>"
						    +"Course : "+s.getCourse();
				return message;
			//	return new student(s.getRolno(),s.getFees(),s.getName(),s.getCourse());
			}
		}
		return "Student not found";
	}
	}

