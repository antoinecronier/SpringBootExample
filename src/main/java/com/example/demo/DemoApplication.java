package com.example.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import com.example.demo.model.firebase.FirebaseDataConfig;
import com.example.demo.utils.JsonManager;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@SpringBootApplication
/**
 * For war deploiment see :
 * 	- https://www.baeldung.com/spring-boot-war-tomcat-deploy
 * 	- https://tomcat.apache.org/tomcat-8.0-doc/deployer-howto.html
 * 	- https://askubuntu.com/questions/135824/what-is-the-tomcat-installation-directory
 *
 * Firebase :
 * 	- https://firebase.google.com/docs/admin/setup?authuser=0
 *
 * @author tactfactory
 *
 */
public class DemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		try {
			FirebaseOptions options = new FirebaseOptions.Builder()
			  .setCredentials(GoogleCredentials.fromStream(new FileInputStream(FirebaseDataConfig.FIREBASE_AUTH)))
			  .setDatabaseUrl(JsonManager.getInstance().<FirebaseDataConfig>readFromFile(FirebaseDataConfig.KEY_FILE, FirebaseDataConfig.class).get(0).getUrl())
			  .build();
			FirebaseApp.initializeApp(options);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
