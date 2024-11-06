package PokeMON.src;

import java.util.Random;
import java.util.Scanner;

public class Batalha {
    private Scanner scanner = new Scanner(System.in);

    public void iniciarBatalha(Pokemon pokemonUsuario, Pokemon pokemonInimigo) {
        System.out.println("\nVocê escolheu: " + pokemonUsuario.getNome());
        System.out.println("O Pokémon inimigo é: " + pokemonInimigo.getNome());

        // Começo da batalha
        while (pokemonUsuario.getHp() > 0 && pokemonInimigo.getHp() > 0) {
            System.out.println("\n--- Turno do Jogador ---");
            System.out.println("Escolha o tipo de ataque:");
            System.out.println("1. Ataque Normal");
            System.out.println("2. Ataque Especial");

            int escolhaAtaque = scanner.nextInt();

            // Jogador escolhe o tipo de ataque
            if (escolhaAtaque == 1) {
                pokemonUsuario.ataqueNormal(pokemonInimigo);
            } else if (escolhaAtaque == 2) {
                pokemonUsuario.ataqueEspecial(pokemonInimigo);
            } else {
                System.out.println("Escolha inválida! O Pokémon apenas ataca normalmente.");
                pokemonUsuario.ataqueNormal(pokemonInimigo);
            }

            System.out.println(pokemonInimigo.getNome() + " - HP: " + pokemonInimigo.getHp());

            // Verificar se o inimigo foi derrotado
            if (pokemonInimigo.getHp() <= 0) {
                System.out.println(pokemonInimigo.getNome() + " foi derrotado!");
                break;  // Fim da batalha
            }

            // Turno do adversário (ele escolhe o tipo de ataque aleatoriamente)
            System.out.println("\n--- Turno do Pokémon Adversário ---");
            pokemonInimigo.escolherAtaque(pokemonUsuario);
            System.out.println(pokemonUsuario.getNome() + " - HP: " + pokemonUsuario.getHp());

            // Verificar se o jogador foi derrotado
            if (pokemonUsuario.getHp() <= 0) {
                System.out.println(pokemonUsuario.getNome() + " foi derrotado! Você perdeu a batalha.");
                break;  // Fim da batalha
            }
        }
    }
}

