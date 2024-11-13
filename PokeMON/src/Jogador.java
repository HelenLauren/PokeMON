package PokeMON.src;

import java.util.HashMap;
import java.util.Map;

public class Jogador {
    private String nome;
    private int moedas;
    private Map<String, Integer> inventario;

    // usa nome padrão se não for fornecido
    public Jogador(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            this.nome = "Ash";  // nome padrão se o usuário não fornecer um nome.
        } else {
            this.nome = nome;  // caso o nome seja válido, usa o nome fornecido.
        }
        this.moedas = 0;
        this.inventario = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }

    // método para ganhar moedas
    public void ganharMoedas(int valor) {
        this.moedas += valor;
    }

    // retorna o número de moedas
    public int getMoedas() {
        return moedas;
    }

    // Método para usar um item do inventário
    public void usarItem(String item, Pokemon pokemon) {
        Loja loja = new Loja();  // Instancia a loja
        loja.usarItem(pokemon, item);  // Usa o item na loja
    }

    // Método para mostrar o inventário do jogador
    public void mostrarInventario() {
        System.out.println("\n--- Inventário de " + nome + " ---");
        if (inventario.isEmpty()) {
            System.out.println("Seu inventário está vazio.");
        } else {
            for (Map.Entry<String, Integer> item : inventario.entrySet()) {
                System.out.println(item.getKey() + " - " + item.getValue() + " unidades");
            }
        }
    }

    // Método para adicionar um item ao inventário do jogador
    public void adicionarItemAoInventario(String item) {
        inventario.put(item, inventario.getOrDefault(item, 0) + 1); // Adiciona o item
    }
}
