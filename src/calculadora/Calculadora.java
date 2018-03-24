package calculadora;

import javax.swing.JFrame;

/**
 *
 * @author Emmanuel Valenzuela
 */
public class Calculadora {

    public static void main(String[] args) {
        
        CalculadoraFrame Calculator = new CalculadoraFrame();
        Calculator.setVisible(true);
        Calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
