package fr.efrei.pokemon_tcg.services;

import fr.efrei.pokemon_tcg.constants.TypePokemon;
import fr.efrei.pokemon_tcg.controllers.CardController;
import fr.efrei.pokemon_tcg.dto.CreateCard;
import fr.efrei.pokemon_tcg.models.Card;

import java.util.List;

public interface ICardService {

	List<Card> findAll(TypePokemon type);

	Card findById(String uuid);

	void create(CreateCard card);

	boolean update(String uuid, Card cards);

	boolean delete(String uuid);
}
