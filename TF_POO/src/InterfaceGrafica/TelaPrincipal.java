package InterfaceGrafica;

import Controller.AcademiaController;
import javax.swing.*;
import java.awt.*;

public class TelaPrincipal extends JFrame {

    private JTextArea areaTexto;

    public TelaPrincipal(
            AcademiaController controller) {

        setTitle("Sistema Academia");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        areaTexto = new JTextArea();

        areaTexto.setEditable(false);

        JButton btnListar =
                new JButton("Listar Plano");

        btnListar.addActionListener(e -> {

            areaTexto.setText(
                    controller.listarPlano()
            );

        });

        JPanel painel =
                new JPanel();

        painel.add(btnListar);

        add(
                painel,
                BorderLayout.NORTH
        );

        add(
                new JScrollPane(areaTexto),
                BorderLayout.CENTER
        );
    }
}