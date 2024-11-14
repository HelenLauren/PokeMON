package com.pokemon.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class Main extends javax.swing.JFrame {

    private Animator animatorLogin;
    private Animator animatorBody;
    private boolean signIn;
    public static Scanner scanner = new Scanner(System.in);
    private static final List<Pokemon> pokemons = new ArrayList<>();
    private static final List<Pokemon> pokemonsInimigos = new ArrayList<>();

    public Main() {
        initComponents();
        jComboBoxPokemons.setVisible(false);
        getContentPane().setBackground(new Color(245, 245, 245));
        TimingTarget targetLogin = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                if (signIn) {
                    background1.setAnimate(fraction);
                } else {
                    background1.setAnimate(1f - fraction);
                }
            }

            @Override
            public void end() {
                if (signIn) {
                    panelLogin.setVisible(false);
                    background1.setShowPaint(true);
                    panelBody.setAlpha(0);
                    panelBody.setVisible(true);
                    animatorBody.start();
                } else {
                    enableLogin(true);
                    txtUser.grabFocus();
                }
            }
        };
        TimingTarget targetBody = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                if (signIn) {
                    panelBody.setAlpha(fraction);
                } else {
                    panelBody.setAlpha(1f - fraction);
                }
            }

            @Override
            public void end() {
                if (signIn == false) {
                    panelBody.setVisible(false);
                    background1.setShowPaint(false);
                    background1.setAnimate(1);
                    panelLogin.setVisible(true);
                    animatorLogin.start();
                }
            }
        };
        animatorLogin = new Animator(1500, targetLogin);
        animatorBody = new Animator(500, targetBody);
        animatorLogin.setResolution(0);
        animatorBody.setResolution(0);
        
        inicializarPokemons();
        inicializarPokemonsInimigos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background1 = new com.raven.swing.Background();
        panelLogin = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        cmdSignIn = new com.raven.swing.Button();
        txtUser = new com.raven.swing.TextField();
        jLabel2 = new javax.swing.JLabel();
        panelBody = new com.raven.swing.PanelTransparent();
        header1 = new com.raven.component.Header();
        cmdSignIn2 = new com.raven.swing.Button();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        cmdSignIn3 = new com.raven.swing.Button();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jComboBoxPokemons = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        background1.setLayout(new java.awt.CardLayout());

        panelLogin.setOpaque(false);

        jPanel1.setOpaque(false);

        cmdSignIn.setBackground(new java.awt.Color(157, 153, 255));
        cmdSignIn.setForeground(new java.awt.Color(255, 255, 255));
        cmdSignIn.setText("JOGAR");
        cmdSignIn.setEffectColor(new java.awt.Color(199, 196, 255));
        cmdSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSignInActionPerformed(evt);
            }
        });

        txtUser.setBackground(new java.awt.Color(245, 245, 245));
        txtUser.setLabelText("Qual seu nome treinador(a)?");
        txtUser.setLineColor(new java.awt.Color(131, 126, 253));
        txtUser.setSelectionColor(new java.awt.Color(157, 153, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/favpng_pikachu-pokémon-gold-and-silver-gengar-drawing_resized (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdSignIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(101, 101, 101))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(cmdSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addContainerGap(109, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
        );

        background1.add(panelLogin, "card2");

        cmdSignIn2.setBackground(new java.awt.Color(157, 153, 255));
        cmdSignIn2.setForeground(new java.awt.Color(255, 255, 255));
        cmdSignIn2.setText("Reiniciar");
        cmdSignIn2.setEffectColor(new java.awt.Color(199, 196, 255));
        cmdSignIn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSignIn2BDeslogar(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(157, 153, 255));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Ver Pokemons");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerPokemons(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        cmdSignIn3.setBackground(new java.awt.Color(157, 153, 255));
        cmdSignIn3.setForeground(new java.awt.Color(255, 255, 255));
        cmdSignIn3.setText("Sair");
        cmdSignIn3.setBorderPainted(false);
        cmdSignIn3.setEffectColor(new java.awt.Color(199, 196, 255));
        cmdSignIn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sair(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(157, 153, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Como jogar?");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComoJogar(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(157, 153, 255));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Batalhar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Batalhar(evt);
            }
        });

        jComboBoxPokemons.setForeground(new java.awt.Color(255, 51, 153));
        jComboBoxPokemons.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolher" }));
        jComboBoxPokemons.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jComboBoxPokemons.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBoxPokemons.setRequestFocusEnabled(false);
        jComboBoxPokemons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPokemonsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBodyLayout = new javax.swing.GroupLayout(panelBody);
        panelBody.setLayout(panelBodyLayout);
        panelBodyLayout.setHorizontalGroup(
            panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
            .addGroup(panelBodyLayout.createSequentialGroup()
                .addGroup(panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBodyLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBodyLayout.createSequentialGroup()
                        .addContainerGap(64, Short.MAX_VALUE)
                        .addComponent(jComboBoxPokemons, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBodyLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmdSignIn3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(183, 183, 183))
            .addGroup(panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBodyLayout.createSequentialGroup()
                    .addContainerGap(550, Short.MAX_VALUE)
                    .addComponent(cmdSignIn2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(12, 12, 12)))
        );
        panelBodyLayout.setVerticalGroup(
            panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBodyLayout.createSequentialGroup()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBodyLayout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120)
                        .addComponent(jComboBoxPokemons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBodyLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(cmdSignIn3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBodyLayout.createSequentialGroup()
                    .addContainerGap(489, Short.MAX_VALUE)
                    .addComponent(cmdSignIn2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(21, 21, 21)))
        );

        background1.add(panelBody, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmdSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSignInActionPerformed
         if (!animatorLogin.isRunning()) {
            signIn = true;
            String user = txtUser.getText().trim();
            boolean action = true;
            // Verificação do comprimento do nome de usuário
            try {
                if (user.length() < 5) {
                    throw new StringTooLong("Nome de usuário deve ter pelo menos 5 caracteres");
                }
            } catch (StringTooLong e) {
                // Exibindo a mensagem de erro e retornando a atenção para o campo
                txtUser.setHelperText(e.getMessage());
                txtUser.grabFocus();
                action = false;
            }

            if (action) {
                animatorLogin.start();
                enableLogin(false);
            // Salvar o nome de usuário no arquivo .txt
            try {
                    try (
                            FileWriter fw = new FileWriter("src/com/pokemon/main/usuarios.txt", true) // 'true' para adicionar ao final do arquivo
;                   BufferedWriter bw = new BufferedWriter(fw)                    ) {

                        bw.write(user);
                        bw.newLine();
                    }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar o nome de usuário", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    }//GEN-LAST:event_cmdSignInActionPerformed

    private void reiniciarJogo() {
    // Limpa os pokémons do jogador
    pokemons.clear();
    jTextArea1.setText("");
    // Recria os pokémons
    inicializarPokemons();

    // Limpa os pokémons inimigos
    pokemonsInimigos.clear();

    // Recria os pokémons inimigos
    inicializarPokemonsInimigos();

    // Você pode adicionar outros elementos para reiniciar o estado do jogo, se necessário
    atualizarMensagem("Jogo reiniciado!");
}
      
    private void cmdSignIn2BDeslogar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSignIn2BDeslogar
    signIn = false;  // Marca o usuário como deslogado
    clearLogin();  // Limpa os campos de login
    reiniciarJogo();  // Reinicia o jogo

    animatorBody.start();  // Inicia a animação de transiçãoo
    }//GEN-LAST:event_cmdSignIn2BDeslogar

    
    
    private void VerPokemons(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerPokemons
        // Limpar o JTextArea antes de adicionar a nova mensagem
    jTextArea1.setText("");
    
    // Exibir as informações atualizadas dos Pokémons
    atualizarMensagem("\n--- Seus Pokémon ---");
    for (Pokemon pokemon : pokemons) {
        String mensagem = pokemon.getNome() + " - HP: " + pokemon.getHp() + " - Tipo: " + pokemon.getTipo();
        
        // Adicionando a nova mensagem ao JTextArea
        jTextArea1.append(mensagem + "\n");
    }
    }//GEN-LAST:event_VerPokemons

    private void Sair(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sair
        System.exit(0);
    }//GEN-LAST:event_Sair

    private void ComoJogar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComoJogar
    // Limpa o JTextArea antes de adicionar o conteúdo
    jTextArea1.setText("");
    jTextArea1.setLineWrap(true);
    
    // Cria uma instância do FileManager com o caminho do arquivo
    FileManager fileManager = new FileManager("src/com/pokemon/main/comoJogar.txt");
    
        // Lê o conteúdo do arquivo e adiciona ao JTextArea
        String conteudo = null;
        try {
            conteudo = fileManager.lerArquivoComoString();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTextArea1.setText(conteudo);
    }//GEN-LAST:event_ComoJogar
    
    private void Batalhar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Batalhar
// Caminho para a imagem
    String caminhoImagem = "src/com/pokemon/main/snorlax.png"; // Substitua com o caminho correto

    // Criação do ImageIcon
    ImageIcon icon = new ImageIcon(caminhoImagem);
    jTextArea1.setEditable(false);  // Torna o JTextArea não editável
    jTextArea1.setText("");  // Limpa o JTextArea
    jTextArea1.append("\n--- Escolha seu Pokémon ---\n");
    
    // Exibe os Pokémons disponíveis
    for (int i = 0; i < pokemons.size(); i++) {
        Pokemon pokemon = pokemons.get(i);
        jTextArea1.append((i + 1) + ". " + pokemon.getNome() + " - HP: " + pokemon.getHp() + "\n");
    }

    // Criar uma lista de opções para o usuário escolher
    String[] opcoes = new String[pokemons.size()];
    for (int i = 0; i < pokemons.size(); i++) {
        opcoes[i] = pokemons.get(i).getNome();  // Nome dos Pokémons
    }

    // Exibir a caixa de diálogo para o usuário escolher
    String escolha;  
    escolha = (String) JOptionPane.showInputDialog(
            null,
            "Escolha um de seus pokemons para batalhar!",
            "",
            JOptionPane.QUESTION_MESSAGE,
            icon,
            opcoes,
            opcoes[0]);

    if (escolha != null) {
        // Encontrar o Pokémon escolhido
        Pokemon pokemonUsuario = null;
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getNome().equals(escolha)) {
                pokemonUsuario = pokemon;
                break;
            }
        }

        if (pokemonUsuario != null) {
            // Inicializa a janela da batalha
            JFrame janela = new JFrame("Batalha Pokémon");
            janela.setLayout(new BorderLayout());

            // JTextArea para mostrar a batalha
            JTextArea jTextAreaBatalha = new JTextArea(20, 40);
            jTextAreaBatalha.setEditable(false);  // Torna o JTextArea não editável
            JScrollPane scrollPane = new JScrollPane(jTextAreaBatalha);
            janela.add(scrollPane, BorderLayout.CENTER);

            // Inicia a batalha com o Pokémon escolhido
            new Batalha(pokemonsInimigos, pokemons, jTextAreaBatalha).iniciarBatalha(pokemonUsuario);
        }
    }
    }//GEN-LAST:event_Batalhar

    private void jComboBoxPokemonsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPokemonsActionPerformed

    }//GEN-LAST:event_jComboBoxPokemonsActionPerformed

    private void enableLogin(boolean action) {
        txtUser.setEditable(action);
        cmdSignIn.setEnabled(action);
    }

    public void clearLogin() {
        txtUser.setText("");
        txtUser.setHelperText("");
    }

    private static void inicializarPokemons() {
        pokemons.add(Fogo.gerarPokemonAleatorio());
        pokemons.add(Agua.gerarPokemonAleatorio());
        pokemons.add(Planta.gerarPokemonAleatorio());
    }

    private static void inicializarPokemonsInimigos() {
        for (int i = 0; i < 30; i++) {
            if (i < 10) {
                pokemonsInimigos.add(Fogo.gerarPokemonAleatorio());
            } else if (i < 20) {
                pokemonsInimigos.add(Agua.gerarPokemonAleatorio());
            } else {
                pokemonsInimigos.add(Planta.gerarPokemonAleatorio());
            }
        }
    }
    
    private void atualizarMensagem(String mensagem) {
    jTextArea1.append(mensagem + "\n");
    jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());  // Move o cursor para o final
}
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.Background background1;
    private com.raven.swing.Button cmdSignIn;
    private com.raven.swing.Button cmdSignIn2;
    private com.raven.swing.Button cmdSignIn3;
    private com.raven.component.Header header1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBoxPokemons;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private com.raven.swing.PanelTransparent panelBody;
    private javax.swing.JPanel panelLogin;
    private com.raven.swing.TextField txtUser;
    // End of variables declaration//GEN-END:variables
}
