package PokeMON.src;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Loja {
    private Map<String, Integer> estoque; //armazena a quantidade de cada item, string é a chave que armazena o nome,
    private Map<String, Integer> inventarioJogador; //intereger é a quantidade em estoque.
    private Scanner scanner = new Scanner(System.in);

    public Loja() {
        estoque = new HashMap<>(); //cria um hashmap (armazena os pares de chave-valor)
        inventarioJogador = new HashMap<>();
        estoque.put("Poção", 50); //50 pocoes no estoque.
        estoque.put("Reviver", 75); //75 reviver no estoque.
    }

    public void exibirItens() {
        System.out.println("\n--- Loja de Itens ---");
        for (Map.Entry<String, Integer> item : estoque.entrySet()) { //percorre todos os pares de chave e valor.
            System.out.println(item.getKey() + " - " + item.getValue() + " moedas"); //retorna o nome do item e quantidade.
        }
    }

    public void comprarItem(String item, Jogador jogador) {
        int preco = estoque.getOrDefault(item, -1); // Verifica se o item está no estoque
        if (preco == -1) {
            System.out.println("Item não disponível.");
            return;
        }

        if (jogador.getMoedas() >= preco) {
            jogador.ganharMoedas(-preco);  // Deduz o preço das moedas do jogador
            jogador.adicionarItemAoInventario(item);  // Adiciona o item ao inventário do jogador
            System.out.println("Você comprou " + item + " por " + preco + " moedas!");
        } else {
            System.out.println("Você não tem moedas suficientes para comprar " + item + ".");
        }
    }

    public void usarItem(Pokemon pokemon, String item) {
        if (inventarioJogador.containsKey(item) && inventarioJogador.get(item) > 0) {
            inventarioJogador.put(item, inventarioJogador.get(item) - 1); //Reduz o item do inventário.
        } else {
            System.out.println("Você não tem " + item + " no inventário.");
        }
    }

    public int consultarEstoque(String item) {
        return inventarioJogador.getOrDefault(item, 0);
    }
}