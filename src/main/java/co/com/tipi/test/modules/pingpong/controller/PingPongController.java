package co.com.tipi.test.modules.pingpong.controller;

import org.springframework.web.bind.annotation.RestController;

import co.com.tipi.test.modules.pingpong.service.PingPongService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin(origins = "*")
@RestController
public class PingPongController {
	
	@Autowired
	private PingPongService service;
	
	@GetMapping(path = "/ping-pong/{count}")
	public ResponseEntity<List<String>> pingPong(@PathVariable int count) {
		List<String> response = service.pingPong(count);
		return new ResponseEntity<List<String>>(response,HttpStatus.OK);
		
	}

}
