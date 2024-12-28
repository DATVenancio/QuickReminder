package project.quickreminder.controller;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Random;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import project.quickreminder.model.TemporaryCode;
import project.quickreminder.repository.TemporaryCodeRepository;
import project.quickreminder.service.EmailSenderService;

@Controller
public class TemporaryCodeController {
	@Autowired 
	EmailSenderService emailSenderService;
	@Autowired
	TemporaryCodeRepository temporaryCodeRepository;
	
	
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping(path="send-code")
	public @ResponseBody void sendCode(@RequestBody Map<String,Object> jsonBody) {
		String code = generateCode();
		String email = jsonBody.get("email").toString();
		LocalDateTime expiredDateTime = LocalDateTime.now().plusMinutes(5);
		
		TemporaryCode temporaryCode = new TemporaryCode(email, code, expiredDateTime);
		temporaryCodeRepository.save(temporaryCode);
		
		emailSenderService.sendTemporaryCode(temporaryCode);
	}
	
	public String generateCode() {
		Random random = new Random();
        int code = 1000 + random.nextInt(9000);
		
		return String.valueOf(code);
	}
}
