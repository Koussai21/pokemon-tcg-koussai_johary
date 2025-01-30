package fr.efrei.pokemon_tcg.services;

import fr.efrei.pokemon_tcg.constants.TypePokemon;
import fr.efrei.pokemon_tcg.controllers.PokemonController;
import fr.efrei.pokemon_tcg.dto.CreatePokemon;
import fr.efrei.pokemon_tcg.models.Card;

import java.util.List;

public interface ICardService {

	List<Pokemon> findAll(TypePokemon type);

	Pokemon findById(String uuid);

	void create(CreatePokemon pokemon);

	boolean update(String uuid, Pokemon pokemon);

	boolean delete(String uuid);
}
