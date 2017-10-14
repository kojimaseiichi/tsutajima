package jp.tsutajima.people.service.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jp.tsutajima.poeple.entity.Account;
import jp.tsutajima.poeple.entity.Role;
import jp.tsutajima.poeple.entity.User;

public class UserDetailImpl implements UserDetails {

	private User user;
	
	public UserDetailImpl(User user) {
		this.user = user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<SimpleGrantedAuthority> grantSet = new HashSet<>();
		if (user != null) {
			for (Role role : user.getRoles()) {
				grantSet.add(new SimpleGrantedAuthority(role.getName()));
			}
		}
		return grantSet;
	}

	@Override
	public String getPassword() {
		if (user == null) 
			return null;
		Account account = user.getAccount();
		if (account == null)
			return null;
		return account.getPassword();
	}

	@Override
	public String getUsername() {
		if (user == null) 
			return null;
		Account account = user.getAccount();
		if (account == null)
			return null;
		return account.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return isEnabled();
	}

	@Override
	public boolean isAccountNonLocked() {
		if (user != null && user.getAccount() != null && user.getAccount().isLocked() == false)
			return true;
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return isEnabled();
	}

	@Override
	public boolean isEnabled() {
		if (user != null && user.getAccount() != null)
			return true;
		return false;
	}

	
}
