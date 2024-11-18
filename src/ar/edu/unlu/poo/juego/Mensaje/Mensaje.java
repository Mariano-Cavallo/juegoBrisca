package ar.edu.unlu.poo.juego.Mensaje;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mensaje extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JLabel lblMensaje;

    public Mensaje(String mensaje) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        lblMensaje.setText(mensaje);
        setLocationRelativeTo(null);
        pack();

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }
}
