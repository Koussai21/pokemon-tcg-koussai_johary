package fr.efrei.pokemon_tcg.dto;

import fr.efrei.pokemon_tcg.constants.TypePokemon;
import fr.efrei.pokemon_tcg.models.Attaque;
import fr.efrei.pokemon_tcg.models.Card;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateCard {

	@Length(min = 3, max = 20)
	private String nom;

	@Positive
	private Integer pv;

	private TypePokemon type;
	
	@JsonProperty("attaque1")
	private String attaque1;
	
	@JsonProperty("attaque2")
	private String attaque2;

	public String getNom() {
		return nom;
	}

	public Integer getPv() {
		return pv;
	}

	public TypePokemon getType() {
		return type;
	}
	
	public String getAttaque1() {
		return attaque1;
	}
	
	public String getAttaque2() {
		return attaque2;
	}
}
