package fr.efrei.pokemon_tcg.repositories;

import fr.efrei.pokemon_tcg.constants.TypePokemon;
import fr.efrei.pokemon_tcg.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, String> {

	// SELECT * FROM pokemon WHERE type_pokemon = :type;
	List<Card> findAllByType(TypePokemon type);
}
