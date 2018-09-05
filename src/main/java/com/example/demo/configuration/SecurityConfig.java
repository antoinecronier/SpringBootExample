package com.example.demo.configuration;

import java.util.ArrayList;

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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@EnableAutoConfiguration
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
        		.httpBasic()
        	.and()
        		.cors()
        	;
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("/register","/register/**");
	}
	
	@Bean
	public AuthenticationManager customAuthenticationManager() throws Exception {
	  return authenticationManager();
	}
	
//	@Bean
//	public CorsFilter corsFilter() { 
//	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//	    CorsConfiguration config = new CorsConfiguration();
//	    config.setAllowCredentials(true);
//	    config.addAllowedOrigin("*");
//	    config.addAllowedHeader("*");
//	    config.addAllowedMethod("*");
//	    source.registerCorsConfiguration("/**", config);
//	    FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
//	    bean.setOrder(0);
//	    return new CorsFilter(source);
//	}
	
//	@Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        final CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(new ArrayList<String>() {
//            {
//                add("");
//            }
//        });
//        configuration.setAllowedMethods(
//                new ArrayList<String>() {
//                    {
//                        add("HEAD");
//                        add("GET");
//                        add("POST");
//                        add("PUT");
//                        add("DELETE");
//                        add("PATCH");
//                    }
//                });
//
//        // setAllowCredentials(true) is important, otherwise:
//        // The value of the 'Access-Control-Allow-Origin' header in the response must
//        // not be the wildcard '' when the request's credentials mode is 'include'.
//        configuration.setAllowCredentials(true);
//        // setAllowedHeaders is important! Without it, OPTIONS preflight request
//        // will fail with 403 Invalid CORS request
//        configuration.setAllowedHeaders(
//                new ArrayList<String>() {
//                    {
////                    	add("OPTIONS");
//                        add("Authorization");
//                        add("Cache-Control");
//                        add("Content-Type");
//                        add("Access-Control-Allow-Origin");
//                    }
//                });
//
//        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
}
