package jp.tsutajima.people.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import jp.tsutajima.poeple.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	public List<User> findByAccountId(String accountId);
	
}
