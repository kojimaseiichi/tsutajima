package jp.tsutajima.people.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import jp.tsutajima.poeple.entity.Account;
import jp.tsutajima.poeple.entity.Role;
import jp.tsutajima.poeple.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository users;
	
	@Autowired
	private RoleRepository roles;
	
	@Autowired
	private AccountRepository accounts;
	
	@Test
	public void testUser() {
		Account account = accounts.findByUserName("kojima").get(0);
		User user = users.findByAccountId(account.getId()).get(0);
		Account account1 = user.getAccount();
		Assert.assertEquals("kojima", account1.getUserName());
		Assert.assertEquals("kojima", account1.getPassword());
		List<Role> roleList = user.getRoles();
		Assert.assertEquals(1, roleList.size());
		Role role = roleList.get(0);
		Assert.assertEquals("role", role.getName());
	}
}
