package com.pokemon.main;

import java.util.Random;
import javax.swing.JTextArea;

public abstract class Pokemon {
    protected String nome;
    protected int hp;
    protected int ataque;
    protected String tipo;

    public Pokemon(String nome, int hp, int ataque, String tipo) {
        this.nome = nome;
        this.hp = hp;
        this.ataque = ataque;
        this.tipo = tipo;
    }

    public void ataqueNormal(Pokemon adversario, JTextArea jTextArea1) {
        int dano = 50;
        jTextArea1.append(nome + " ataca com um ataque normal e causa " + dano + " de dano em " + adversario.getNome() + "!\n");
        adversario.receberDano(dano);
    }

  
    public abstract void ataqueEspecial(Pokemon adversario, JTextArea jTextArea);

    public void escolherAtaque(Pokemon adversario, JTextArea jTextArea1) {
        Random random = new Random();
        int escolha = random.nextInt(2);  

        if (escolha == 0) {
            ataqueNormal(adversario, jTextArea1); 
        } else {
            ataqueEspecial(adversario, jTextArea1); 
        }
    }

    public int calcularDano(Pokemon adversario) {
        double multiplicador = 1.0;

        switch (this.tipo) {
            case "Agua" -> {
            switch (adversario.tipo) {
                case "Fogo" -> multiplicador = 2.0;
                case "Agua" -> multiplicador = 1.0;
                case "Planta" -> multiplicador = 0.5;
                default -> {
                }
            }
            }
            case "Fogo" -> {
            switch (adversario.tipo) {
                case "Planta" -> multiplicador = 2.0;
                case "Agua" -> multiplicador = 0.5;
                case "Fogo" -> multiplicador = 1.0;
                default -> {
                }
            }
            }
            case "Planta" -> {
            switch (adversario.tipo) {
                case "Agua" -> multiplicador = 2.0;
                case "Fogo" -> multiplicador = 0.5;
                case "Planta" -> multiplicador = 1.0;
                default -> {
                }
            }
            }

        }

        return (int) (this.ataque * multiplicador);
    }
    public void receberDano(int dano) {
        this.hp -= dano;
        if (this.hp < 0) this.hp = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getHp() {
        return hp;
    }

    public String getTipo() {
        return tipo;
    }
}
