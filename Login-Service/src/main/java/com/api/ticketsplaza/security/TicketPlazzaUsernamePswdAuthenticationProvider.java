package com.api.ticketsplaza.security;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.api.ticketsplaza.model.User;
import com.api.ticketsplaza.repository.UserDAO;

@Component
public class TicketPlazzaUsernamePswdAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userName = authentication.getName();
		String pwd = authentication.getCredentials().toString();

		List<User> user = userDAO.findByEmail(userName);
		if (user.size() > 0) {
			if (passwordEncoder.matches(pwd, user.get(0).getPassword())) {
				
				return new UsernamePasswordAuthenticationToken(user, pwd);
			} else {
				throw new BadCredentialsException("Invalid Password");
			}
		} else {
			throw new BadCredentialsException("No User Registered with this details");
		}

	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
