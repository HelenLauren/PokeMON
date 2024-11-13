package PokeMON.src;

import java.util.Random;

public class Fogo extends Pokemon {
    private static String[] nomes = {"Charmander", "Vulpix", "Growlithe", "Ponyta", "Flareon", "Magmar", "Houndour", "Torchic", "Cyndaquil", "Numel"};

    public Fogo(String nome, int hp, int ataque) {
        super(nome, hp, ataque, "Fogo");
    }

    public static Fogo gerarPokemonAleatorio() {
        Random random = new Random();
        return new Fogo(nomes[random.nextInt(nomes.length)], 300, 50);
    }
     public void usarPoção() {
        usarItem("Poção");  //chama o metodo usar item pelo nome da String entre parenteses.
    }

    public void usarReviver() {
        usarItem("Reviver"); 
    }

    @Override
    public void ataqueEspecial(Pokemon adversario) {
        int dano = calcularDano(adversario);
        System.out.println(nome + " usa Lança-Chamas e causa " + dano + " de dano em " + adversario.getNome() + "!");
        adversario.receberDano(dano);
    }
}
