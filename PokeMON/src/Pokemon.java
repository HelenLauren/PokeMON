package PokeMON.src;

import java.util.Random;

public abstract class Pokemon {
    protected String nome;
    protected int hp;
    protected int ataque;
    protected String tipo;

    public Pokemon(String nome, int hp, int ataque, String tipo) {
        this.nome = nome;
        this.hp = hp;
        this.ataque = ataque;
        this.tipo = tipo;
    }
    // Método para ataque normal
    public void ataqueNormal(Pokemon adversario) {
        int dano = 50;
        System.out.println(nome + " ataca com um ataque normal e causa " + dano + " de dano em " + adversario.getNome() + "!");
        adversario.receberDano(dano);
    }

    // Método para ataque especial (a ser implementado pelas subclasses)
    public abstract void ataqueEspecial(Pokemon adversario);

    // Método para escolher aleatoriamente entre ataque normal e especial
    public void escolherAtaque(Pokemon adversario) {
        Random random = new Random();
        int escolha = random.nextInt(2);  // 0 para ataque normal, 1 para ataque especial

        if (escolha == 0) {
            ataqueNormal(adversario);
        } else {
            ataqueEspecial(adversario);
        }
    }

    // Método para calcular dano com base nas vantagens de tipo
    public int calcularDano(Pokemon adversario) {
        double multiplicador = 1.0;

        switch (this.tipo) {
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

    // método para usar itens (poção e reviver)
     public void usarItem(String item) {
        switch (item) {
            case "Poção":
                if (hp < 300) { 
                    hp += 50; //recupera 50 de vida somente se o pokemon tiver menos de 300 HP
                    if (hp > 300) hp = 300;
                    System.out.println(nome + " usou uma Poção e recuperou 50 HP!");
                }
                break;
            case "Reviver":
                // Implementação de Reviver (recupera HP para Pokémon que foi derrotado)
                if (hp == 0) {
                    hp = 100; 
                    System.out.println(nome + " foi revivido e agora tem 100 HP!");
                }
                break;
            default:
                System.out.println("Item desconhecido.");
        }
    }
    // Método para aplicar dano
    public void receberDano(int dano) {
        this.hp -= dano;
        if (this.hp < 0) this.hp = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getHp() {
        return hp;
    }

    public String getTipo() {
        return tipo;
    }
}
