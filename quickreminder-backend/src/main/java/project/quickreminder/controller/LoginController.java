package project.quickreminder.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import project.quickreminder.model.Reminder;
import project.quickreminder.service.ReminderService;
import project.quickreminder.service.TemporaryCodeService;

@Controller
public class LoginController {
	
	@Autowired
	TemporaryCodeService temporaryCodeService;
	@Autowired
	ReminderService reminderService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping(path="login")
	public @ResponseBody Iterable<Reminder> login(@RequestBody Map<String, Object> jsonBody) {
		String email = jsonBody.get("email").toString();
		String code = jsonBody.get("code").toString();
		if(temporaryCodeService.checkValidEmailCode(email, code)) {
			return reminderService.getRemindersForEmail(email);
		}
		return null;
		
	}
}
