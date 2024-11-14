package PokeMON.src;

import java.util.Random;

public class Planta extends Pokemon {
    private static String[] nomes = {"Bulbasaur", "Oddish", "Bellossom", "Treecko", "Turtwig", "Chespin", "Rowlet", "Lurantis", "Bounsweet", "Grookey"};

    public Planta(String nome, int hp, int ataque) {
        super(nome, hp, ataque, "Planta");
    }

    public static Planta gerarPokemonAleatorio() {
        Random random = new Random();
        return new Planta(nomes[random.nextInt(nomes.length)], 300, 50);
    }

    public void usarPoção(Jogador jogador) {
        jogador.usarItem("Poção", this);  //chama o metodo usar item pelo nome da String entre parenteses.
    }

    public void usarReviver(Jogador jogador) {
        jogador.usarItem("Reviver", this);
    }

    @Override
    public void ataqueEspecial(Pokemon adversario) {
        int dano = calcularDano(adversario);
        System.out.println(nome + " usa Folha Navalha e causa " + dano + " de dano em " + adversario.getNome() + "!");
        adversario.receberDano(dano);
    }
}
