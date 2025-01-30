package fr.efrei.pokemon_tcg.controllers;

import fr.efrei.pokemon_tcg.dto.CreateAttaque;
import fr.efrei.pokemon_tcg.models.Attaque;
import fr.efrei.pokemon_tcg.services.IAttaquesService;
import fr.efrei.pokemon_tcg.services.implementations.AttaqueServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attaques")
public class AttaqueController {

	private IAttaquesService attaqueService;

	public AttaqueController(AttaqueServiceImpl attaqueService) {
		this.attaqueService = attaqueService;
	}

	@GetMapping
	public ResponseEntity<List<Attaque>> findAll() {
		return new ResponseEntity<>(attaqueService.findAll(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody CreateAttaque attaque) {
		attaqueService.create(attaque);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
