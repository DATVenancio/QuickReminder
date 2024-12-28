package project.quickreminder.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TemporaryCode {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String email;
	private String code;
	private LocalDateTime expiredDatetime;
	
	public TemporaryCode() {}
	
	public TemporaryCode(String email, String code, LocalDateTime expiredDatetime) {
		super();
		this.email = email;
		this.code = code;
		this.expiredDatetime = expiredDatetime;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public LocalDateTime getExpiredDatetime() {
		return expiredDatetime;
	}
	public void setExpiredDatetime(LocalDateTime datetime) {
		this.expiredDatetime = datetime;
	}
	
	
}
