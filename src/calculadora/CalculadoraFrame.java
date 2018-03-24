package calculadora;

import javax.swing.*;

/**
 *
 * @author Emmanuel Valenzuela
 */
public class CalculadoraFrame extends JFrame {

    public CalculadoraFrame() {
        setSize(335, 550);
        setTitle("Calculadora");
        setLocationRelativeTo(null);
        add(new PanelOne());
     //   pack();// tama;o por defecto   
    }
}
