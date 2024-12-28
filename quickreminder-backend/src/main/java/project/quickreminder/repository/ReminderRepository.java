package project.quickreminder.repository;

import project.quickreminder.model.*;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface ReminderRepository extends CrudRepository<Reminder, Integer>{

	List<Reminder> findByDatetime(LocalDateTime datetime);
	List<Reminder> findByEmail(String email);
	Iterable<Reminder> findAllByEmail(String email);
	void deleteById(Long id);
}
