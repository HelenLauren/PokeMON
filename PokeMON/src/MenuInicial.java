import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuInicial extends InterfaceGrafica {

    @Override  //metodo abstrato da classe interface grafica.
    public JPanel mostrar() {
        JPanel panel = new JPanel(); //cria o painel
        panel.setLayout(new GridLayout(3, 1));  

        JButton iniciarButton = new JButton("Iniciar"); //cria o botao iniciar
        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  
                System.out.println("Iniciar jogo!");
            }
        });

        JButton comoJogarButton = new JButton("Como jogar?");
        comoJogarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //cria um pop up ds instrucoes
                JOptionPane.showMessageDialog(null, "Instruções do jogo aqui."); 
            }
        });

        JButton sairButton = new JButton("Sair"); //outro botao so que de sair agr
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panel.add(iniciarButton);  //vai adicionar no painel os botoes criados antes ali em cima
        panel.add(comoJogarButton);
        panel.add(sairButton);

        return panel;  //quando no main chamar a funcao mostrar(), vai retortar tudo issso de cima.
    }
}
