package fr.efrei.pokemon_tcg.controllers;

import fr.efrei.pokemon_tcg.constants.TypePokemon;
import fr.efrei.pokemon_tcg.dto.CreateCard;
import fr.efrei.pokemon_tcg.models.Card;
import fr.efrei.pokemon_tcg.services.ICardService;
import fr.efrei.pokemon_tcg.services.implementations.CardServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {
	private final ICardService cardService;

	public CardController(CardServiceImpl cardService) {
		this.cardService = cardService;
	}

	@GetMapping
	public ResponseEntity<List<Card>> getAll(@RequestParam(required = false) TypePokemon type) {
		// SELECT * from pokemon;
		return new ResponseEntity<>(cardService.findAll(type), HttpStatus.OK);
	}

	@GetMapping("/{uuid}")
	public ResponseEntity<Card> getById(@PathVariable String uuid) {
		Card card = cardService.findById(uuid);
		if(card == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(cardService.findById(uuid), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> createPokemon(@Valid @RequestBody CreateCard card) {
		// INSERT INTO pokemon(nom, niveau, type) VALUES (pokemon.nom, pokemon.niveau, pokemon.type);
		cardService.create(card);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/{uuid}")
	public ResponseEntity<?> updatePokemon(@PathVariable String uuid, @RequestBody Card card) {
		boolean isModifier = cardService.update(uuid, card);
		if(!isModifier) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/{uuid}")
	public ResponseEntity<?> updatePokemon(@PathVariable String uuid) {
		boolean isSupprimer = cardService.delete(uuid);
		if(!isSupprimer) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
