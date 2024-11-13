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

    public void comprarItem(String item, int moedas) {
        if (estoque.containsKey(item)) {
            int preco = estoque.get(item);
            if (moedas >= preco) {
                System.out.println("Você comprou " + item + " por " + preco + " moedas!");
                inventarioJogador.put(item, inventarioJogador.getOrDefault(item, 0) + 1);//Se o item já existe, ele soma 1 ao atual. Se nao, adiciona o item com quantidade inicial igual a 1.
            } else {
                System.out.println("Você não tem moedas suficientes para comprar " + item + ".");
            }
        } else {
            System.out.println("Item não disponível.");
        }
    }

    public void usarItem(Pokemon pokemon, String item) {
        if (inventarioJogador.containsKey(item) && inventarioJogador.get(item) > 0) {
            pokemon.usarItem(item);
            inventarioJogador.put(item, inventarioJogador.get(item) - 1); //Reduz o item do inventário.
        } else {
            System.out.println("Você não tem " + item + " no inventário.");
        }
    }

    public int consultarEstoque(String item) {
        return inventarioJogador.getOrDefault(item, 0);
    }
}