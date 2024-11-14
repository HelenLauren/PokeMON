package PokeMON.src;

import java.util.Random;

public class Boss extends Pokemon {
    public Boss(String nome) {
        super(nome, 1500, 100, "Normal"); //o normal do boss é ter os 3 tipos juntos :)
    }

    @Override
    public void ataqueEspecial(Pokemon adversario) {
        Random random = new Random();
        int tipoAtaque = random.nextInt(3); // randomiza o proximo ataque
        int dano;

        switch (tipoAtaque) {
            case 0 -> {
                System.out.println(nome + " usa o ataque especial de Grama!");
                adversario.receberDano(calcularDanoBoss(adversario, "Planta"));
            }
            case 1 -> {
                System.out.println(nome + " usa Lança-Chamas!");
                adversario.receberDano(calcularDanoBoss(adversario, "Fogo"));
            }
            case 2 -> {
                System.out.println(nome + " usa !");
                adversario.receberDano(calcularDanoBoss(adversario, "Agua"));
            }
        }
    }

    private int calcularDanoBoss(Pokemon adversario, String tipoAtaque) {
        double multiplicador = 1.0;

        switch (tipoAtaque) {
            case "Agua" -> {
                if (adversario.tipo.equals("Fogo")) multiplicador = 2.0;
                else if (adversario.tipo.equals("Agua")) multiplicador = 1.0;
                else if (adversario.tipo.equals("Planta")) multiplicador = 0.5;
            }
            case "Fogo" -> {
                if (adversario.tipo.equals("Planta")) multiplicador = 2.0;
                else if (adversario.tipo.equals("Agua")) multiplicador = 0.5;
                else if (adversario.tipo.equals("Fogo")) multiplicador = 1.0;
            }
            case "Planta" -> {
                if (adversario.tipo.equals("Agua")) multiplicador = 2.0;
                else if (adversario.tipo.equals("Fogo")) multiplicador = 0.5;
                else if (adversario.tipo.equals("Planta")) multiplicador = 1.0;
            }
        }

        return (int) (this.ataque * multiplicador);
    }
}
