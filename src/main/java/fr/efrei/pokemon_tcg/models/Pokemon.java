package fr.efrei.pokemon_tcg.models;

import jakarta.persistence.*;
import java.util.Random;

@Entity
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    @OneToOne
    private Pokemon pokemon;

    private int pv;


    public String getUuid() {
        return uuid;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

}
