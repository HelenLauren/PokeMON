package PokeMON.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Pokemon> pokemons = new ArrayList<>();
    private static List<Pokemon> pokemonsInimigos = new ArrayList<>();

    public static void main(String[] args) throws Exception  {
        inicializarPokemons();
        inicializarPokemonsInimigos();
        exibirMenuInicial();

    }

    private static void inicializarPokemons() {
        pokemons.add(Fogo.gerarPokemonAleatorio());
        pokemons.add(Agua.gerarPokemonAleatorio());
        pokemons.add(Planta.gerarPokemonAleatorio());
    }

    private static void inicializarPokemonsInimigos() {
        for (int i = 0; i < 30; i++) {
            if (i < 10) {
                pokemonsInimigos.add(Fogo.gerarPokemonAleatorio());
            } else if (i < 20) {
                pokemonsInimigos.add(Agua.gerarPokemonAleatorio());
            } else {
                pokemonsInimigos.add(Planta.gerarPokemonAleatorio());
            }
        }
    }
    private static void exibirMenuInicial() {
        while (true) {
            System.out.println("\n--- PokéMON - Menu Inicial ---");
            System.out.println("1. Iniciar");
            System.out.println("2. Como jogar?");
            System.out.println("3. Sair");

            int escolha = scanner.nextInt();
            scanner.nextLine();
            switch (escolha) {
                case 1 -> iniciarTreinador();
                case 2 -> comoJogar();
                case 3 -> {
                    System.out.println("Obrigado por jogar!");
                    System.exit(0);
                }
                default -> System.out.println("Escolha inválida.");
            }
        }
    }

    private static void comoJogar() {
        FileManager fm = new FileManager("./text/comoJogar.txt");
        fm.lerArquivoScanner();
    }

    private static void iniciarTreinador() {
        System.out.println("Qual seu nome treinador(a)?");
        String nome = scanner.nextLine();
        try {
            if (nome.length() > 12) throw new StringTooLong("Nome não aceito");
            System.out.println("Olá "+ nome);
            exibirMenuJogo();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    private static void exibirMenuJogo() {
        while (true) {
            System.out.println("\n--- Menu de Jogo ---");
            System.out.println("1. Batalhar");
            System.out.println("2. Ver Pokémons");
            System.out.println("3. Sair");

            int escolha = scanner.nextInt();
            scanner.nextLine();
            switch (escolha) {
                case 1 -> batalhar();
                case 2 -> verPokemons();
                case 3 -> {
                    System.out.println("Obrigado por jogar!");
                    System.exit(0);
                }
                default -> System.out.println("Escolha inválida.");
            }
        }
    }

    private static void batalhar() {
        System.out.println("\n--- Escolha seu Pokémon ---");
        for (int i = 0; i < pokemons.size(); i++) {
            Pokemon pokemon = pokemons.get(i);
            System.out.println((i + 1) + ". " + pokemon.getNome() + " - HP: " + pokemon.getHp());
        }

        int escolhaPokemon = scanner.nextInt() - 1;
        Pokemon pokemonUsuario = pokemons.get(escolhaPokemon);
        Pokemon pokemonInimigo = pokemonsInimigos.get(new Random().nextInt(pokemonsInimigos.size()));

        System.out.println("\nVocê escolheu: " + pokemonUsuario.getNome());
        System.out.println("O Pokémon inimigo é: " + pokemonInimigo.getNome());

        while (pokemonUsuario.getHp() > 0 && pokemonInimigo.getHp() > 0) {
            int dano = pokemonUsuario.calcularDano(pokemonInimigo);
            pokemonInimigo.receberDano(dano);
            System.out.println(pokemonUsuario.getNome() + " ataca e causa " + dano + " de dano em " + pokemonInimigo.getNome() + "!");
            System.out.println(pokemonInimigo.getNome() + " - HP: " + pokemonInimigo.getHp());

            if (pokemonInimigo.getHp() <= 0) {
                System.out.println(pokemonInimigo.getNome() + " foi derrotado!");
                pokemons.add(pokemonInimigo);
                return;
            }

            dano = pokemonInimigo.calcularDano(pokemonUsuario);
            pokemonUsuario.receberDano(dano);
            System.out.println(pokemonInimigo.getNome() + " ataca e causa " + dano + " de dano em " + pokemonUsuario.getNome() + "!");
            System.out.println(pokemonUsuario.getNome() + " - HP: " + pokemonUsuario.getHp() + " / " + pokemonUsuario.getHp());

            if (pokemonUsuario.getHp() <= 0) {
                System.out.println(pokemonUsuario.getNome() + " foi derrotado! Você perdeu a batalha.");
            }
        }
    }

    private static void verPokemons() {
        System.out.println("\n--- Seus Pokémon ---");
            for (Pokemon pokemon : pokemons) {
                System.out.println(pokemon.getNome() + " - HP: " + pokemon.getHp() + " - Tipo: " + pokemon.getTipo());
            }
        }
    }