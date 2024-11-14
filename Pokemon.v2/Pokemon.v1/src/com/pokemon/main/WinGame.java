package com.pokemon.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WinGame {
    public static void main(String[] args) {
     
        JDialog dialog = new JDialog();
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setSize(800, 450); 
        dialog.setLocationRelativeTo(null); 

      
        dialog.setModal(true);

        
        ImageIcon backgroundImage = new ImageIcon("src/com/pokemon/main/wingame.jpg");

        
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

        
        JLabel label = new JLabel("Vitória! Você é um ótimo caçador pokemon conseguindo 6 pokemons", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(Color.WHITE);  
        panelFundo.add(label, BorderLayout.CENTER);

        
        dialog.add(panelFundo);

       
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);  
            }
        });

      
        dialog.setVisible(true);
    }
}
