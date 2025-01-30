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

    private String attaque1;
    private int degats1;

    private String attaque2;
    private int degats2;

    private int rarete;
    public Pokemon() {
        this.rarete = genererRareteAleatoire();
    }

    private int genererRareteAleatoire() {
        return new Random().nextInt(5) + 1};

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

    public String getAttaque1() {
        return attaque1;
    }

    public void setAttaque1(String attaque1) {
        this.attaque1 = attaque1;
    }

    public int getDegats1() {
        return degats1;
    }

    public void setDegats1(int degats1) {
        this.degats1 = degats1;
    }

    public String getAttaque2() {
        return attaque2;
    }

    public void setAttaque2(String attaque2) {
        this.attaque2 = attaque2;
    }

    public int getDegats2() {
        return degats2;
    }

    public void setDegats2(int degats2) {
        this.degats2 = degats2;
    }

    public int getRarete() {
        return rarete;
    }

    public void setRarete(int rarete) {
        this.rarete = rarete;
    }
}
