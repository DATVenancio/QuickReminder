package project.quickreminder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import project.quickreminder.service.EmailSenderService;

@RestController
public class TestController {
	@Autowired
	private EmailSenderService senderService;
	@GetMapping("/test")
	public String test(){
		senderService.sendMail("danielvenancio60@gmail.com","teste SUBJECT" , "teste Body" );
		return "ok";
	}
}
