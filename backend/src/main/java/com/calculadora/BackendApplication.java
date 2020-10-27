package com.calculadora;

import java.util.Collections;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.calculadora.runner.OperationRunner;

@SpringBootApplication
@RestController
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	@CrossOrigin
	@PutMapping("/api/soma")
	public Map<String, Double> soma(@RequestBody Operation op) {
		OperationRunner or = new OperationRunner();
		or.setOp(op);
		Double result = or.soma();
		
		return  Collections.singletonMap("result", result);
	}
	@CrossOrigin
	@PutMapping("/api/subtracao")
	public Map<String, Double> subtracao(@RequestBody Operation op) {
		OperationRunner or = new OperationRunner();
		or.setOp(op);
		Double result = or.subtracao();
		
		return  Collections.singletonMap("result", result);
	}
	@CrossOrigin
	@PutMapping("/api/multiplicacao")
	public Map<String, Double> multiplicacao(@RequestBody Operation op) {
		OperationRunner or = new OperationRunner();
		or.setOp(op);
		Double result = or.multiplicacao();
		
		return  Collections.singletonMap("result", result);
	}
	@CrossOrigin
	@PutMapping("/api/divisao")
	public ResponseEntity<Object> divisao(@RequestBody Operation op) {
		if(op.getB() == 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		OperationRunner or = new OperationRunner();
		or.setOp(op);
		Double result = or.divisao();
		
		return  ResponseEntity.ok(Collections.singletonMap("result", result));
	}

}
