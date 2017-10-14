package jp.tsutajima.people.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jp.tsutajima.people.repository.AccountRepository;
import jp.tsutajima.people.repository.UserRepository;
import jp.tsutajima.poeple.entity.Account;
import jp.tsutajima.poeple.entity.User;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository users;
	
	@Autowired
	private AccountRepository accounts;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		List<Account> accountList = accounts.findByUserName(userName);
		if (accountList.isEmpty())
			return null;
		Account account = accountList.get(0);
		List<User> userList = users.findByAccountId(account.getId());
		if (userList.isEmpty())
			return null;
		return new UserDetailImpl(userList.get(0));
	}

}
