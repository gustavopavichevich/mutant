package com.mutant.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mutant.util.Mutante;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"*"})
public class MutantRest {
	
	@PostMapping("/mutant")
	public ResponseEntity<?> obtenerPersonal(@RequestBody List<String> dna, BindingResult result){
		Map<String, Object> response = new HashMap<>();	
		response.put("mensaje", "Hola mundo!");
		System.out.println(dna);
		/*
		for(String texto: dna) {
			System.out.println(texto);
		}*/

		String[] dnaOld = { "ATGCGA", "ATGCGA", "ATGCGA", "ATGCGA", "CCCCTA", "TCACTG" };
		Mutante mutante = new Mutante();
		response.put("mensaje",String.valueOf(mutante.isMutant(mutante.armaMatriz(dnaOld))));

		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}
}
