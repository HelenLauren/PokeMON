package com.pokemon.main;

import javax.swing.*;
import java.awt.*;

public class GameOver {
    public static void main(String[] args) {
        // Cria o JDialog em vez do JOptionPane
        JDialog dialog = new JDialog();
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setSize(800, 450); 
        dialog.setLocationRelativeTo(null); 

      
        ImageIcon backgroundImage = new ImageIcon("src/com/pokemon/main/gameover.jpg");

       
        if (backgroundImage.getImageLoadStatus() != MediaTracker.COMPLETE) {
            System.out.println("Erro ao carregar a imagem!");
        }

     
        JPanel panelFundo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g); 
              
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        panelFundo.setLayout(new BorderLayout());

      
        JLabel label = new JLabel("GAME OVER: Todos seus pokemons estão esgotados", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(Color.WHITE);  
        panelFundo.add(label, BorderLayout.CENTER);

       
        dialog.add(panelFundo);

        dialog.setVisible(true);
    }
}
