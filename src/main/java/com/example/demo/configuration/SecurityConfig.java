package com.example.demo.configuration;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableAutoConfiguration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableGlobalMethodSecurity(securedEnabled = true)
/**
 * For external connection use :
 * 		- 127.0.0.1:1234/login (GET)
 * 		- in postman use x-www-form-urlencode with next fields :
 * 			- username
 * 			- password
 * 			- _csrf
 * @author tactfactory
 *
 */
public class SecurityConfig extends WebSecurityConfigurerAdapter  {

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		//httpSecurity.csrf().disable();
		httpSecurity
				.authorizeRequests()
				.anyRequest()
				.authenticated()
			.and()
				.formLogin()
					.loginPage("/login")
					.usernameParameter("username").passwordParameter("password")
					.permitAll()
			.and()
				.logout()
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
					.logoutSuccessUrl("/login")
			.and()
				.csrf()
					.ignoringAntMatchers("/MonModele/**")
					.ignoringAntMatchers("/M2/**")
					.ignoringAntMatchers("/M3/**")
					.ignoringAntMatchers("/M4/**")
					.ignoringAntMatchers("/M51/**")
					.ignoringAntMatchers("/M51M52/**")
					.ignoringAntMatchers("/M52/**")
			.and()
        		.httpBasic()
        	.and()
        		.cors()
//        	.and()
//    			.authorizeRequests().anyRequest().anonymous()
//    			.antMatchers("/home","/home/**")
//    			.permitAll()
        	;
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("/register","/register/**");
//	    // Allow all GET for every controllers
//	    web.ignoring().antMatchers(HttpMethod.GET);
//	    // Ignoring only get only for M3
//	    web.ignoring().antMatchers(HttpMethod.GET,"/M3","/M3/**");
	    
	    // Ignoring all methods for M3
	    web.ignoring().antMatchers("/M3","/M3/**");
	}
	
	@Bean
	public AuthenticationManager customAuthenticationManager() throws Exception {
	  return authenticationManager();
	}
	
	@Bean
	public CorsFilter corsFilter() { 
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    CorsConfiguration config = new CorsConfiguration();
	    config.setAllowCredentials(true);
	    config.addAllowedOrigin("*");
	    config.addAllowedHeader("*");
	    config.addAllowedMethod("*");
	    config.addExposedHeader("WWW-Authenticate");
	    source.registerCorsConfiguration("/**", config);
	    FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
	    bean.setOrder(0);
	    return new CorsFilter(source);
	}
}
