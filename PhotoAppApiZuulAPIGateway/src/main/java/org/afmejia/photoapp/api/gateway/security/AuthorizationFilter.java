package org.afmejia.photoapp.api.gateway.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class AuthorizationFilter extends BasicAuthenticationFilter {
	Environment environment;
	
	@Autowired
	public AuthorizationFilter (AuthenticationManager authManager, Environment environment) {
		super(authManager);
		this.environment = environment;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res,
									FilterChain chain) throws IOException, ServletException {
		String authorizationHeader = req.getHeader(environment.getProperty("authorization.token.header.name"));
		
		if (authorizationHeader == null || 
			!authorizationHeader.startsWith(environment.getProperty("authorization.token.header"))) {
			chain.doFilter(req, res);
			return;
		}
		
		UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(req, res);
		
	}
}
