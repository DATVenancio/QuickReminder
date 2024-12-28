package project.quickreminder.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import project.quickreminder.model.Reminder;
import project.quickreminder.model.TemporaryCode;
import project.quickreminder.repository.ReminderRepository;

@EnableScheduling
@Service
public class DatabaseChecker {
	@Autowired
	ReminderService reminderService;
	
	@Autowired
	TemporaryCodeService temporaryCodeService;
	
	
	
	@Autowired
	private EmailSenderService emailSenderService;
	
	@Scheduled(fixedRate=10000)
	public void databaseCheckForEmail(){
		
		Iterable<Reminder> reminders = reminderService.findRemindersForNow();
		for(Reminder reminder : reminders) {
			if(reminder.getExecuted()==false) {
				emailSenderService.sendMail(reminder.getEmail(), reminder.getTitle(), reminder.getBody());
				reminder.setExecuted(true);
				reminderService.saveReminder(reminder);
			}
			
		}
		
	}
	
	@Scheduled(fixedRate=1000000)
	public void databaseCheckForTemporaryCode(){
		temporaryCodeService.deleteTemporaryCodesForNow();
		
		
	}
	
	

}
