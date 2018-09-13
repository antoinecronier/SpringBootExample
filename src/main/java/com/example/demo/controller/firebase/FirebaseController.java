package com.example.demo.controller.firebase;

import java.io.UnsupportedEncodingException;

import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.M2;
import com.example.demo.model.firebase.FirebaseDataConfig;
import com.example.demo.model.firebase.FirebaseResponse;
import com.example.demo.utils.JacksonUtility;
import com.example.demo.utils.JsonManager;
import com.google.firebase.FirebaseException;

@RestController
@RequestMapping(value= {"/firebase"})
public class FirebaseController {
	
	Firebase firebase;
	
	public FirebaseController() {
		super();
		try {
			this.firebase = new Firebase(JsonManager.getInstance().<FirebaseDataConfig>readFromFile(FirebaseDataConfig.KEY_FILE, FirebaseDataConfig.class).get(0).getUrl());
		} catch (FirebaseException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value= {"/post/m2"}, method=RequestMethod.POST)
	public ResponseEntity<FirebaseResponse> postM2ToFirebase(@RequestBody M2 m2) throws UnsupportedEncodingException, FirebaseException{
		return ResponseEntity.ok(this.firebase.post(JsonManager.getInstance().addItem(m2).toJSON()));
	}
}
