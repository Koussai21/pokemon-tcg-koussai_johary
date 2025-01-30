package fr.efrei.pokemon_tcg.services.implementations;

import fr.efrei.pokemon_tcg.dto.CreateAttaque;
import fr.efrei.pokemon_tcg.models.Attaque;
import fr.efrei.pokemon_tcg.models.Item;
import fr.efrei.pokemon_tcg.repositories.AttaqueRepository;
import fr.efrei.pokemon_tcg.services.IAttaquesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttaqueServiceImpl implements IAttaquesService {

	private final AttaqueRepository repository;

	public AttaqueServiceImpl(AttaqueRepository repository) {
		this.repository = repository;
	}

	@Override
	public void create(CreateAttaque attaque) {
		Attaque attaqueACreer = new Attaque();
		attaqueACreer.setnom(attaque.getNom());
		attaqueACreer.setdegats(attaque.getDegats());
		repository.save(attaqueACreer);
	}

	@Override
	public Attaque findById(String uuid) {
		// renvoie soit une Attaque soit null
		return repository.findById(uuid).orElse(null);
	}
	
	@Override
	public List<Attaque> findAll() {
		return repository.findAll();
	}

	@Override
	public boolean update(String uuid, Attaque attaque) {
		Attaque attaqueAModifier = findById(uuid);
		if(attaqueAModifier == null) {
			return false;
		}
		attaqueAModifier.setnom(attaque.getNom());
		attaqueAModifier.setdegats(attaque.getDegats());
		repository.save(attaqueAModifier);
		return true;
	}

	@Override
	public boolean delete(String uuid) {
		Attaque attaqueAModifier = findById(uuid);
		if(attaqueAModifier == null) {
			return false;
		}
		repository.deleteById(uuid);
		return true;
	}
}
