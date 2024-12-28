package project.quickreminder.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import project.quickreminder.model.Reminder;
import project.quickreminder.repository.ReminderRepository;
import project.quickreminder.service.ReminderService;

@Controller
public class ReminderController {

	@Autowired
	ReminderService reminderService;
	
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping(path="/add-reminder")
	public @ResponseBody HashMap<String, String> addReminder(@RequestBody Map<String,Object> jsonBody) {
		Reminder reminder = new Reminder();
		LocalDateTime date = LocalDateTime.parse(jsonBody.get("datetime").toString(),DateTimeFormatter.ISO_DATE_TIME);
		reminder.setTitle(jsonBody.get("title").toString());
		reminder.setBody(jsonBody.get("body").toString());
		reminder.setEmail(jsonBody.get("email").toString());
		reminder.setDate(date);
		reminder.setExecuted(false);
		reminderService.saveReminder(reminder);
		
	
		return reminder.toJson();
	}
	@Transactional
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping(path="delete-reminder/{id}")
	public @ResponseBody String removeReminder(@PathVariable("id") Long id ) {
		reminderService.deleteReminder(id);
		return "ok";
	}
	
	@GetMapping(path="/get-all")
	public @ResponseBody Iterable<Reminder> getAllReminders(){
		return reminderService.getAllReminders();
	}
	
	
	
}
