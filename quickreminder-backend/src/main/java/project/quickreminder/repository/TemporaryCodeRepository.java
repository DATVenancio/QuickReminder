package project.quickreminder.repository;


import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;

import project.quickreminder.model.TemporaryCode;

public interface TemporaryCodeRepository extends CrudRepository<TemporaryCode, Integer> {
	List<TemporaryCode> findByEmailAndCode(String email,String code);
	List<TemporaryCode> findByExpiredDatetime(LocalDateTime datetime);
	@Modifying
    @Transactional
	void deleteByExpiredDatetimeBefore(LocalDateTime dateTime);
}
