package com.pokemon.main;

import java.util.Random;
import javax.swing.JTextArea;

public class Planta extends Pokemon {
    private static final String[] nomes = {"Bulbasaur", "Oddish", "Bellossom", "Treecko", "Turtwig", "Chespin", "Rowlet", "Lurantis", "Bounsweet", "Grookey"};

    public Planta(String nome, int hp, int ataque) {
        super(nome, hp, ataque, "Planta");
    }

    public static Planta gerarPokemonAleatorio() {
        Random random = new Random();
        return new Planta(nomes[random.nextInt(nomes.length)], 300, 50);
    }

    @Override
    public void ataqueEspecial(Pokemon adversario, JTextArea jTextArea1) {
        int dano = calcularDano(adversario);
        jTextArea1.append(nome + " usa Folha Navalha e causa " + dano + " de dano em " + adversario.getNome() + "!\n");
        adversario.receberDano(dano);
    }
}
