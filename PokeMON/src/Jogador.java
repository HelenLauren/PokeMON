package PokeMON.src;

import java.util.HashMap;
import java.util.Map;

public class Jogador {
    private String nome;
    private int moedas;
    private Map<String, Integer> inventario;

    public Jogador(String nome) {
        this.nome = nome;
        this.moedas = 0;  // o jogador inicia sem moedas.
        this.inventario = new HashMap<>();
    }

    public void ganharMoedas(int valor) {
        this.moedas += valor;
    }

    public int getMoedas() {
        return moedas;
    }

    public void usarItem(String item, Pokemon pokemon) {
        Loja loja = new Loja();  // instancia a loja
        loja.usarItem(pokemon, item);
    }

    public void mostrarInventario() {
        System.out.println("\n--- Inventário do Jogador ---");
        for (Map.Entry<String, Integer> item : inventario.entrySet()) {
            System.out.println(item.getKey() + " - " + item.getValue() + " unidades"); //mostra a quant. de cada item e nome.
        }
    }

    public void adicionarItemAoInventario(String item) {
        inventario.put(item, inventario.getOrDefault(item, 0) + 1);
    }
}
