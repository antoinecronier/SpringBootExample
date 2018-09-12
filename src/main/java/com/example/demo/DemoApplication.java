package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/**
 * For war deploiment see :
 * 	- https://www.baeldung.com/spring-boot-war-tomcat-deploy
 * 	- https://tomcat.apache.org/tomcat-8.0-doc/deployer-howto.html
 * 	- https://askubuntu.com/questions/135824/what-is-the-tomcat-installation-directory
 * @author tactfactory
 *
 */
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
