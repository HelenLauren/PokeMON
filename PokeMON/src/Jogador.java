package PokeMON.src;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static PokeMON.src.Main.scanner;

public class Jogador {
    private String nome;
    private int moedas;
    private Map<String, Integer> inventario;
    private List<Pokemon> pokemons;

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

    public boolean temItem(String item) {
        return inventario.getOrDefault(item, 0) > 0;
    }

    public Pokemon getPokemon() {
        if (pokemons.isEmpty()) {
            System.out.println("Você não possui nenhum Pokémon.");
            return null;
        }
        System.out.println("\nEscolha um Pokémon:");
        for (int i = 0; i < pokemons.size(); i++) {
            System.out.println((i + 1) + ". " + pokemons.get(i).getNome() + " - HP: " + pokemons.get(i).getHp());
        }
        int escolha;
        do {
            System.out.print("Digite o número do Pokémon que deseja escolher: ");
            escolha = scanner.nextInt();
        } while (escolha < 1 || escolha > pokemons.size());

        return pokemons.get(escolha - 1); // Retorna o Pokémon escolhido
    }


}
