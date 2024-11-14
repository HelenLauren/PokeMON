//package PokeMON.src;
//
//import java.util.Scanner;
//
//public class BatalhaBoss {
//    private Jogador jogador;
//    private Boss boss;
//    private Scanner scanner = new Scanner(System.in);
//
//public BatalhaBoss(Jogador jogador) {
//        this.jogador = jogador;
//        this.boss = new Boss("Capivara");
//}
//
//public void iniciarBatalha() {
//    if (jogador.getInventarioPokemon().size() <= 5) {
//            System.out.println("Você precisa ter mais de 5 Pokémons para lutar contra o Boss Capivara.");
//            return;
//    }
//
//    System.out.println("Iniciando batalha contra a " + boss.getNome() + "!");
//
//    while (jogador.getPokemon().getHp() > 0 && boss.getHp() > 0) {
//        System.out.println("\n--- Turno do Jogador ---");
//        System.out.println("Escolha o tipo de ataque:");
//        System.out.println("1. Ataque Normal");
//        System.out.println("2. Ataque Especial");
//        System.out.println("3. Usar item de cura.");
//
//
//        int escolha = scanner.nextInt();
//
//        switch (escolha) {
//            case 1 -> jogador.getPokemon().ataqueNormal(boss);
//            case 2 -> jogador.getPokemon().ataqueEspecial(boss);
//            case 3 -> {
//                System.out.println("Escolha um item de cura:");
//                if (jogador.temItem("Poção")) System.out.println("1 - Poção");
//                if (jogador.temItem("Reviver")) System.out.println("2 - Reviver");
//
//                int itemEscolhido = scanner.nextInt();
//                if (itemEscolhido == 1 && jogador.temItem("Poção")) {
//                    jogador.usarItem("Poção", jogador.getPokemon());
//                } else if (itemEscolhido == 2 && jogador.temItem("Reviver")) {
//                    jogador.usarItem("Reviver", jogador.getPokemon());
//                } else {
//                    System.out.println("Item inválido ou não disponível.");
//                }
//            }
//            default -> System.out.println("Escolha inválida! O Pokémon apenas ataca normalmente.");
//            pokemonUsuario.ataqueNormal(boss);
//        }
//            System.out.println(boss.getNome() + " - HP: " + boss.getHp());
//
//            //ataque do boss se ele ainda tiver HP.
//            if (pokemonInimigo.getHp() <= 0) {
//                System.out.println("Parabéns! Você derrotou o Boss"+ boss.getNome + "!!");
//                //System.out.println("mensagem bonita");
//                jogador.ganharMoedas(500);
//                return;
//            }
//            else {
//                System.out.println("Você foi derrotado pelo Boss Capivara.");
//                jogador.ganharMoedas(100);
//            }
//            System.out.println("\n--- Turno do Boss ---");
//            boss.ataqueEspecial(pokemonUsuario);
//            System.out.println(pokemonUsuario.getNome() + " - HP: " + pokemonUsuario.getHp());
//
//            //verifica se o jogador foi derrotado.
//            if (pokemonUsuario.getHp() <= 0) {
//                System.out.println(pokemonUsuario.getNome() + " foi derrotado! Você perdeu a batalha.");
//                return;
//            }
//    }
//}
