package jp.tsutajima.people.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import jp.tsutajima.poeple.entity.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {

	public List<Account> findByUserName(String userName);
}
