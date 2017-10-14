package jp.tsutajima.people;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler {
	@Override
	public void onAuthenticationFailure(
			HttpServletRequest req,
			HttpServletResponse res,
			AuthenticationException exp)
			throws IOException, ServletException {
		res.sendRedirect(req.getContextPath() + "/login?exception=t");
	}

}
