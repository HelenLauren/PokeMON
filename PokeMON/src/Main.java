package PokeMON.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    private static List<Pokemon> pokemons = new ArrayList<>();
    private static List<Pokemon> pokemonsInimigos = new ArrayList<>();

    public static void main(String[] args) throws Exception {
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
            System.out.println("Olá " + nome);
            exibirMenuJogo();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void exibirMenuJogo() {
        while (true) {
            System.out.println("\n--- Menu de Jogo ---");
            System.out.println("1. Batalhar");
            System.out.println("2. Ver Pokémons");
            System.out.println("3. Loja");
            System.out.println("4. Sair");

            int escolha = scanner.nextInt();
            scanner.nextLine();
            switch (escolha) {
                case 1 -> batalhar();
                case 2 -> verPokemons();
                case 3 -> lojaMenu();
                case 4 -> {
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

        Pokemon pokemonInimigo = gerarPokemonAleatorio();  // Gera o Pokémon aleatório

        // Criando uma instância de Batalha e iniciando a batalha
        Batalha batalha = new Batalha(pokemonsInimigos, pokemons);  // Passando pokemons para o jogador
        batalha.iniciarBatalha(pokemonUsuario);  // Chamando com apenas um argumento
    }
     private static void lojaMenu() {
        while (true) {
            System.out.println("\n--- Loja de Itens ---");
            loja.exibirItens();
            System.out.println("\nSeu saldo de moedas: " + jogador.getMoedas()); //diz o saldo
            System.out.println("Digite o item que você deseja comprar ou 'sair' para voltar:"); //para comprar tem que digitar o nome do item. 

            String itemEscolhido = scanner.nextLine(); //pega pelo q o usuario digitou
            if (itemEscolhido.equalsIgnoreCase("sair")) { //se for igual 'sair' ele sai
                return; //volta pro menu inicial.
            }

            loja.comprarItem(itemEscolhido, jogador.getMoedas());
        }
    }

    private static void verPokemons() {
        System.out.println("\n--- Seus Pokémon ---");
        for (Pokemon pokemon : pokemons) {
            System.out.println(pokemon.getNome() + " - HP: " + pokemon.getHp() + " - Tipo: " + pokemon.getTipo());
        }
    }
}