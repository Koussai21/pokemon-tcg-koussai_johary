package fr.efrei.pokemon_tcg.services.implementations;

import fr.efrei.pokemon_tcg.constants.TypePokemon;
import fr.efrei.pokemon_tcg.dto.CreateCard;
import fr.efrei.pokemon_tcg.models.Attaque;
import fr.efrei.pokemon_tcg.models.Card;
import fr.efrei.pokemon_tcg.repositories.CardRepository;
import fr.efrei.pokemon_tcg.services.IAttaquesService;
import fr.efrei.pokemon_tcg.services.ICardService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements ICardService {

	private final CardRepository repository;
	private final IAttaquesService attaqueService;

	public CardServiceImpl(CardRepository repository, AttaqueServiceImpl attaqueService) {
		this.repository = repository;
		this.attaqueService = attaqueService;
	}

	@Override
	public List<Card> findAll(TypePokemon typePokemon) {
		if(typePokemon == null) {
			return repository.findAll();
		}
		return repository.findAllByType(typePokemon);
	}
	

	@Override
	public void create(CreateCard card) {
		Card cardACreer = new Card();
		cardACreer.setType(card.getType());
		cardACreer.setNom(card.getNom());
		cardACreer.setPv(card.getPv());
		Attaque attaque1 = attaqueService.findById(card.getAttaque1());
		Attaque attaque2 = attaqueService.findById(card.getAttaque2());
		cardACreer.setAttaque1(attaque1);
		cardACreer.setAttaque2(attaque2);
		repository.save(cardACreer);
	}

	@Override
	public Card findById(String uuid) {
		// renvoie soit un pokemon soit null
		return repository.findById(uuid).orElse(null);
	}

	@Override
	public boolean update(String uuid, Card card) {
		Card cardAModifier = findById(uuid);
		if(cardAModifier == null) {
			return false;
		}
		cardAModifier.setNom(card.getNom());
		cardAModifier.setPv(card.getPv());
		cardAModifier.setType(card.getType());
		cardAModifier.setAttaque1(card.getAttaque1());
		cardAModifier.setAttaque2(card.getAttaque2());
		repository.save(cardAModifier);
		return true;
	}

	@Override
	public boolean delete(String uuid) {
		Card cardAModifier = findById(uuid);
		if(cardAModifier == null) {
			return false;
		}
		repository.deleteById(uuid);
		return true;
	}
}
