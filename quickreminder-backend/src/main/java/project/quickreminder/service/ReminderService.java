package project.quickreminder.service;



import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.quickreminder.model.Reminder;
import project.quickreminder.repository.ReminderRepository;

@Service
public class ReminderService {
	@Autowired
	ReminderRepository reminderRepository;
	public Iterable<Reminder> getAllReminders(){
		return reminderRepository.findAll();
	}
	public Iterable<Reminder> findRemindersForNow(){
		ZonedDateTime currentZonedDateTime = ZonedDateTime.now(ZoneId.of("UTC"));
		LocalDateTime currentDatetime = currentZonedDateTime.toLocalDateTime().truncatedTo(ChronoUnit.MINUTES);
		return reminderRepository.findByDatetime(currentDatetime);
	}
	
	public Iterable<Reminder> getRemindersForEmail(String email){
		return reminderRepository.findAllByEmail(email);
	}
	
	public void saveReminder(Reminder reminder) {
		reminderRepository.save(reminder);
	}
	
	public void deleteReminder(Long id) {
		reminderRepository.deleteById(id);
	}
}
