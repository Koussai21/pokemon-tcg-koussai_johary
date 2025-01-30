package fr.efrei.pokemon_tcg.models;

import jakarta.persistence.*;

@Entity
public class Attaque {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String uuid;
	
	private String nom;
	
	private Integer degats;
	
	public String getNom() {
		return nom;
	}

	public void setnom(String nom) {
		this.nom = nom;
	}
	
	public Integer getDegats() {
		return degats;
	}
	
	public void setdegats(Integer Degats) {
		this.degats = Degats;
	}
	
	public String getUuid() {
		return uuid;
	}
}
