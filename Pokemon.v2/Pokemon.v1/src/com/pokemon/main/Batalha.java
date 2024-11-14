package com.pokemon.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Batalha {
    private final List<Pokemon> pokemonsInimigos;  
    private final List<Pokemon> pokemonsJogador; 
    private final JTextArea jTextArea1;  
    private JButton btnAtaqueNormal;
    private JButton btnAtaqueEspecial;
    private JFrame janelaBatalha;

    public Batalha(List<Pokemon> pokemonsInimigos, List<Pokemon> pokemonsJogador, JTextArea jTextArea) {
        // Inicializa as listas
        this.pokemonsInimigos = pokemonsInimigos != null ? pokemonsInimigos : new ArrayList<>();
        this.pokemonsJogador = pokemonsJogador != null ? pokemonsJogador : new ArrayList<>();
        this.jTextArea1 = jTextArea;
    }

    public void iniciarBatalha(Pokemon pokemonUsuario) {
        if (pokemonUsuario.getHp() <= 0) {
            JOptionPane.showMessageDialog(null, "Este Pokémon está fora de combate e não pode ser escolhido!", 
                                          "Erro", JOptionPane.ERROR_MESSAGE);
            return;  // Não continua com a batalha
        }
        
        
        List<Pokemon> inimigosDisponiveis = new ArrayList<>(pokemonsInimigos); 
        inimigosDisponiveis.removeAll(pokemonsJogador);  

        Pokemon pokemonInimigo = inimigosDisponiveis.get(new Random().nextInt(inimigosDisponiveis.size()));

        
        jTextArea1.setText(""); 
        jTextArea1.append("Você escolheu: " + pokemonUsuario.getNome() + "\n");
        jTextArea1.append("O Pokémon inimigo é: " + pokemonInimigo.getNome() + "\n");

        
        janelaBatalha = new JFrame("Batalha Pokémon");
        janelaBatalha.setLayout(new BorderLayout());

        JPanel panelBotoes = new JPanel();

      
        btnAtaqueNormal = new JButton("Ataque Normal");
         btnAtaqueNormal.setPreferredSize(new Dimension(150, 50));
        btnAtaqueNormal.setBackground(new Color(157, 153, 255)); 
        btnAtaqueNormal.setForeground(Color.WHITE); 
        btnAtaqueNormal.setFocusPainted(false);
        btnAtaqueNormal.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        
        btnAtaqueNormal.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAtaqueNormal.setBackground(new Color(177, 173, 255)); 
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAtaqueNormal.setBackground(new Color(157, 153, 255)); 
            }
        });

        
        btnAtaqueEspecial = new JButton("Ataque Especial"); 
            

        btnAtaqueEspecial.setPreferredSize(new Dimension(150, 50));
        btnAtaqueEspecial.setBackground(new Color(157, 153, 255));
        btnAtaqueEspecial.setForeground(Color.WHITE);
        btnAtaqueEspecial.setFocusPainted(false);
        btnAtaqueEspecial.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        
        btnAtaqueNormal.setBorderPainted(false);
        btnAtaqueNormal.setContentAreaFilled(false);
        btnAtaqueNormal.setOpaque(true);

        btnAtaqueEspecial.setBorderPainted(false);
        btnAtaqueEspecial.setContentAreaFilled(false);
        btnAtaqueEspecial.setOpaque(true);

        
        btnAtaqueEspecial.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAtaqueEspecial.setBackground(new Color(177, 173, 255));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAtaqueEspecial.setBackground(new Color(157, 153, 255));
            }
        });

       
        panelBotoes.add(btnAtaqueNormal);
        panelBotoes.add(btnAtaqueEspecial);

        janelaBatalha.add(panelBotoes, BorderLayout.SOUTH);
        janelaBatalha.setSize(400, 300);
        janelaBatalha.setLocationRelativeTo(null);
        janelaBatalha.setVisible(true);

        JScrollPane scrollPane = new JScrollPane(jTextArea1);
        janelaBatalha.add(scrollPane, BorderLayout.CENTER);

        janelaBatalha.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janelaBatalha.setVisible(true);

        
        btnAtaqueNormal.addActionListener((ActionEvent e) -> {
            executarTurnoJogador(pokemonUsuario, pokemonInimigo, "normal");
        });

       
        btnAtaqueEspecial.addActionListener((ActionEvent e) -> {
            executarTurnoJogador(pokemonUsuario, pokemonInimigo, "especial");
        });
    }

    private void executarTurnoJogador(Pokemon pokemonUsuario, Pokemon pokemonInimigo, String tipoAtaque) {
        jTextArea1.append("\n--- Turno do Jogador ---\n");

        if ("normal".equals(tipoAtaque)) {
            pokemonUsuario.ataqueNormal(pokemonInimigo, jTextArea1);
        } else if ("especial".equals(tipoAtaque)) {
            pokemonUsuario.ataqueEspecial(pokemonInimigo, jTextArea1);
        }

        jTextArea1.append(pokemonInimigo.getNome() + " - HP: " + pokemonInimigo.getHp() + "\n");

        if (pokemonInimigo.getHp() <= 0) {
            jTextArea1.append(pokemonInimigo.getNome() + " foi derrotado!\n");
            pokemonsJogador.add(pokemonInimigo);  
            btnAtaqueNormal.setEnabled(false);
            btnAtaqueEspecial.setEnabled(false);

            verificarVitoriaJogador();  
        } else {
           
            verificarFimDeTurno(pokemonUsuario, pokemonInimigo);
        }
    }

    private void verificarVitoriaJogador() {
        if (pokemonsJogador.size() >= 6) {
            janelaBatalha.dispose();
            WinGame.main(null);
        }
    }

    private void verificarFimDeTurno(Pokemon pokemonUsuario, Pokemon pokemonInimigo) {
        if (pokemonUsuario.getHp() > 0) {
            jTextArea1.append("\n--- Turno do Pokémon Adversário ---\n");
            pokemonInimigo.escolherAtaque(pokemonUsuario, jTextArea1); 
            jTextArea1.append(pokemonUsuario.getNome() + " - HP: " + pokemonUsuario.getHp() + "\n");

            if (pokemonUsuario.getHp() <= 0) {
                jTextArea1.append(pokemonUsuario.getNome() + " foi derrotado! Você perdeu a batalha.\n");
                btnAtaqueNormal.setEnabled(false);
                btnAtaqueEspecial.setEnabled(false);
            }
        }

        verificarDerrotaJogador();
    }

    private void verificarDerrotaJogador() {
        boolean todosDerrotados = true;

        for (Pokemon p : pokemonsJogador) {
            if (p.getHp() > 0) {
                todosDerrotados = false;
                break;
            }
        }

        if (todosDerrotados) {
            janelaBatalha.dispose();
            GameOver.main(null);
        }
    }
}
