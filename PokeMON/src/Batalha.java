package PokeMON.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Batalha {
    private Scanner scanner = new Scanner(System.in);
    private Pokemon pokemonUsuario;
    private List<Pokemon> pokemonsInimigos;
    private List<Pokemon> pokemonsJogador;

    public Batalha(List<Pokemon> pokemonsInimigos, List<Pokemon> pokemonsJogador) {
        this.pokemonsInimigos = pokemonsInimigos != null ? pokemonsInimigos : new ArrayList<>();
        this.pokemonsJogador = pokemonsJogador != null ? pokemonsJogador : new ArrayList<>();
    }


    public void iniciarBatalha(Pokemon pokemonUsuario) {
        // Escolher aleatoriamente um Pokémon inimigo
        Pokemon pokemonInimigo = pokemonsInimigos.get(new Random().nextInt(pokemonsInimigos.size()));

        System.out.println("\nVocê escolheu: " + pokemonUsuario.getNome());
        System.out.println("O Pokémon inimigo é: " + pokemonInimigo.getNome());

        while (pokemonUsuario.getHp() > 0 && pokemonInimigo.getHp() > 0) {
            System.out.println("\n--- Turno do Jogador ---");
            System.out.println("Escolha o tipo de ataque:");
            System.out.println("1. Ataque Normal");
            System.out.println("2. Ataque Especial");
            System.out.println("3. Usar item de cura.");
            
            int escolhaAtaque = scanner.nextInt();

            // Jogador escolhe o tipo de ataque
            if (escolhaAtaque == 1) {
                pokemonUsuario.ataqueNormal(pokemonInimigo);
            } else if (escolhaAtaque == 2) {
                pokemonUsuario.ataqueEspecial(pokemonInimigo);
            } else if (escolhaAtaque == 3) {
                    System.out.println("Escolha um item de cura:");
                    if (jogador.temItem("Poção")) System.out.println("1 - Poção");
                    if (jogador.temItem("Reviver")) System.out.println("2 - Reviver");
                    
                    int itemEscolhido = scanner.nextInt();

                    if (itemEscolhido == 1 && jogador.temItem("Poção")) {
                        jogador.usarItem("Poção", jogador.getPokemon());
                        continue;
                    } else if (itemEscolhido == 2 && jogador.temItem("Reviver")) {
                        jogador.usarItem("Reviver", jogador.getPokemon());
                        continue;
                    } else {
                        System.out.println("Item inválido ou não disponível.");
                    }
            }
            else {
                System.out.println("Escolha inválida! O Pokémon apenas ataca normalmente.");
                pokemonUsuario.ataqueNormal(pokemonInimigo);
            }

            System.out.println(pokemonInimigo.getNome() + " - HP: " + pokemonInimigo.getHp());

            if (pokemonInimigo.getHp() <= 0) {
                System.out.println(pokemonInimigo.getNome() + " foi derrotado!");
                pokemonsJogador.add(pokemonInimigo);  // Adiciona o Pokémon inimigo à lista do jogador
                return;
            }

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
