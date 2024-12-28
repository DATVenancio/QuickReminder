package project.quickreminder.model;

import java.time.LocalDateTime;
import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reminder {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String email;
	private String title;
	private String body;
	private LocalDateTime datetime;
	private Boolean executed;
	public Reminder() {}
	public Reminder(String email, String title, String body, LocalDateTime datetime, Boolean executed) {
		super();
		this.email = email;
		this.title = title;
		this.body = body;
		this.datetime = datetime;
	}
	
	public HashMap<String, String> toJson(){
		HashMap<String, String> jsonReminder = new HashMap<>();
		
		jsonReminder.put("id", this.id.toString());
		jsonReminder.put("email", this.email);
		jsonReminder.put("title", this.title);
		jsonReminder.put("body", this.body);
		jsonReminder.put("datetime", this.datetime.toString());
		jsonReminder.put("executed", this.executed.toString());
		
		return jsonReminder;
	}
	
	
	public Long getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public LocalDateTime getDatetime() {
		return datetime;
	}
	public void setDate(LocalDateTime datetime) {
		this.datetime = datetime;
	}
	public Boolean getExecuted() {
		return executed;
	}
	public void setExecuted(Boolean executed) {
		this.executed = executed;
	}
	
	
	
	
}
