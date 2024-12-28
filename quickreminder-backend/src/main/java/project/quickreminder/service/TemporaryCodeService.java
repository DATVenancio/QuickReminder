package project.quickreminder.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.quickreminder.model.Reminder;
import project.quickreminder.model.TemporaryCode;
import project.quickreminder.repository.ReminderRepository;
import project.quickreminder.repository.TemporaryCodeRepository;

@Service
public class TemporaryCodeService {
	@Autowired
	TemporaryCodeRepository temporaryCodeRepository;
	
	public Boolean checkValidEmailCode(String email, String code) {
		List<TemporaryCode> temporaryCodes = temporaryCodeRepository.findByEmailAndCode(email, code);
		if(temporaryCodes.isEmpty()) {
			return false;
		}
		return true;
	}
	public void deleteTemporaryCodesForNow(){
		ZonedDateTime currentZonedDateTime = ZonedDateTime.now(ZoneId.of("UTC"));
		LocalDateTime currentDatetime = currentZonedDateTime.toLocalDateTime().truncatedTo(ChronoUnit.MINUTES);
		temporaryCodeRepository.deleteByExpiredDatetimeBefore(currentDatetime);
	}
}
