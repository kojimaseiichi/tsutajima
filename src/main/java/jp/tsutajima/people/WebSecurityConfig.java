package jp.tsutajima.people;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jp.tsutajima.people.service.impl.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
@EntityScan(basePackages= {"jp.tsutajima.poeple.entity"})
@EnableJpaRepositories(basePackages= {"jp.tsutajima.people.repository"})
@EnableTransactionManagement
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.mvcMatchers("/login")
					.permitAll()
				.anyRequest()
					.authenticated()
				.anyRequest()
					.hasRole("USER")
		.and()
			.formLogin()
				.loginProcessingUrl("/login/authenticate")
				.loginPage("/login")
				.defaultSuccessUrl("/")
				.failureForwardUrl("/login")
				.usernameParameter("username")
				.passwordParameter("password")
		.and()
			.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout**"))
				.logoutSuccessUrl("/login");
	}
	
	@Configuration
	protected static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {
		@Autowired
		private UserDetailServiceImpl userDetailService;
		
		@Override
		public void init(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailService);
		}
	}
}
