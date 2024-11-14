package com.pokemon.main;

import java.util.Random;
import javax.swing.JTextArea;

public class Fogo extends Pokemon {
    private static final String[] nomes = {"Charmander", "Vulpix", "Growlithe", "Ponyta", "Flareon", "Magmar", "Houndour", "Torchic", "Cyndaquil", "Numel"};

    public Fogo(String nome, int hp, int ataque) {
        super(nome, hp, ataque, "Fogo");
    }

    public static Fogo gerarPokemonAleatorio() {
        Random random = new Random();
        return new Fogo(nomes[random.nextInt(nomes.length)], 300, 50);
    }

    @Override
    public void ataqueEspecial(Pokemon adversario, JTextArea jTextArea1) {
        int dano = calcularDano(adversario);
        jTextArea1.append(nome + " usa Chama Infernal e causa " + dano + " de dano em " + adversario.getNome() + "!\n");
        adversario.receberDano(dano);
    }
}
