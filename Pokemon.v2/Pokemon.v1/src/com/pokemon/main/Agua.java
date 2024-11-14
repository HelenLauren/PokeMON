package com.pokemon.main;

import java.util.Random;
import javax.swing.JTextArea;

public class Agua extends Pokemon {
    private static final String[] nomes = {"Squirtle", "Psyduck", "Poliwag", "Totodile", "Mudkip", "Wingull", "Buizel", "Oshawott", "Froakie", "Popplio"};

    public Agua(String nome, int hp, int ataque) {
        super(nome, hp, ataque, "Agua");
    }

    public static Agua gerarPokemonAleatorio() {
        Random random = new Random();
        return new Agua(nomes[random.nextInt(nomes.length)], 300, 50);
    }

    @Override
    public void ataqueEspecial(Pokemon adversario, JTextArea jTextArea1) {
        int dano = calcularDano(adversario);
        jTextArea1.append(nome + " usa Jato de Água e causa " + dano + " de dano em " + adversario.getNome() + "!\n");
        adversario.receberDano(dano);
    }
}