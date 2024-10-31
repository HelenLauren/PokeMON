package PokeMON.src;

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

    public abstract void ataqueEspecial(Pokemon adversario);

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
