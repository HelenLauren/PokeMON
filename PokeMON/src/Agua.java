package PokeMON.src;

import java.util.Random;

public class Agua extends Pokemon {
    private static String[] nomes = {"Squirtle", "Psyduck", "Poliwag", "Totodile", "Mudkip", "Wingull", "Buizel", "Oshawott", "Froakie", "Popplio"};

    public Agua(String nome, int hp, int ataque) {
        super(nome, hp, ataque, "Agua");
    }

    public static Agua gerarPokemonAleatorio() {
        Random random = new Random();
        return new Agua(nomes[random.nextInt(nomes.length)], 300, 50);
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
        System.out.println(nome + " usa Jato de Água e causa " + dano + " de dano em " + adversario.getNome() + "!");
        adversario.receberDano(dano);
    }
}