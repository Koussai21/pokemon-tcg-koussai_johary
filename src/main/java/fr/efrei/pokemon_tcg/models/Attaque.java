package fr.efrei.pokemon_tcg.models;

import jakarta.persistence.*;

@Entity
public class Attaque {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String uuid;
	
	private String nom;
	
	private Integer degats;
	
	public String nom() {
		return nom;
	}

	public void setnom(String nom) {
		this.nom = nom;
	}
	
	public Integer degats() {
		return degats;
	}
	
	public void degats(Integer Degats) {
		this.degats = Degats;
	}
}
