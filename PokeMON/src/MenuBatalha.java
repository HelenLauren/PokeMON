import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBatalha extends InterfaceGrafica {

    @Override
    public JPanel mostrar() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        JLabel titulo = new JLabel("Batalha Pokémon");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        JButton batalharButton = new JButton("Iniciar Batalha");
        batalharButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Batalha iniciada!");
            }
        });

        panel.add(titulo);
        panel.add(batalharButton);

        return panel;
    }
}