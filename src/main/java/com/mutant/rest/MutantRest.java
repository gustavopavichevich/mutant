package com.mutant.rest;

import com.mutant.model.*;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = { "*" })
public class MutantRest {

	@PostMapping(path = "/mutant", consumes = "application/json")
	public ResponseEntity<?> obtenerPersonal(@RequestBody Data dna) {

		Map<String, Object> response = new HashMap<>();

		response.put("mensajeTitle", dna.getTitle());
		response.put("mensajeGroup", dna.getGroup());

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}