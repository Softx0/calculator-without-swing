package calculadora;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * @author Emmanuel Valenzuela
 */
public class PanelOne extends JPanel {

    private final JPanel PanelTwo;
    private final JTextField Screen;
    private String TerminoCalculo;
    private double Resultado;
    private boolean Inicio;
    private int coma;

    public PanelOne() {
        coma = 0;
        Inicio = true;//Limpiar el display

        setLayout(new BorderLayout());//Layout = disposicion de la ventana
        Screen = new JTextField("0");

        Screen.setEnabled(false);//Pantalla
        Screen.setFont(new java.awt.Font("Arial", 3, 25));
        add(Screen, BorderLayout.NORTH);

        PanelTwo = new JPanel();
        PanelTwo.setLayout(new GridLayout(6, 4));//Filas y conlumnas (6,4)

        ActionListener Display = new NumOnScreen(); //Principio de Sustitucion aplicado
        ActionListener AgregarOperacion = new Opera();

        CrearBoton_Listen("%", AgregarOperacion);

        CrearBoton_Listen("Raiz 2", AgregarOperacion);

        CrearBoton_Listen("x²", AgregarOperacion);

        CrearBoton_Listen("1⁄x", AgregarOperacion);

        CrearBoton_Listen("CE", AgregarOperacion);

        CrearBoton_Listen("C", AgregarOperacion);

        CrearBoton_Listen("<|", AgregarOperacion);

        CrearBoton_Listen("÷", AgregarOperacion);

        CrearBoton_Listen("7", Display);

        CrearBoton_Listen("8", Display);

        CrearBoton_Listen("9", Display);

        CrearBoton_Listen("X", AgregarOperacion);

        CrearBoton_Listen("4", Display);

        CrearBoton_Listen("5", Display);

        CrearBoton_Listen("6", Display);

        CrearBoton_Listen("-", AgregarOperacion);

        CrearBoton_Listen("1", Display);

        CrearBoton_Listen("2", Display);

        CrearBoton_Listen("3", Display);

        CrearBoton_Listen("+", AgregarOperacion);

        CrearBoton_Listen("±", AgregarOperacion);

        CrearBoton_Listen("0", Display);

        CrearBoton_Listen(",", AgregarOperacion);

        CrearBoton_Listen("=", AgregarOperacion);
        TerminoCalculo = "=";

        add(PanelTwo, BorderLayout.CENTER);

    }

    //Metodo para crear botones eficientemente
    private void CrearBoton_Listen(String nombreBoton, ActionListener Escuchen) {

        JButton BotonDios = new JButton(nombreBoton);
        BotonDios.addActionListener(Escuchen);
        BotonDios.setFont(new java.awt.Font("Arial", 3, 22));
        BotonDios.setBackground(Color.LIGHT_GRAY);
        PanelTwo.add(BotonDios);

    }

//Clase interna para mostrar los numeros en el display
    private class NumOnScreen implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            String vInput = event.getActionCommand();
            //  PanelOne PO = new PanelOne();
            if (Inicio) {
                Screen.setText("");

                Inicio = false;
            }
            if (vInput.equals(",") && coma == 0) {
                Screen.setText(Screen.getText() + vInput);
                coma++;
            } else if (!vInput.equals(",")) {
                Screen.setText(Screen.getText() + vInput);

            } else if (vInput.equals(",") && coma >= 1) {

            }
            // Screen.setText(Screen.getText() + vInput);

        }
    }

    //Classe interna para las operaciones matematicas
    private class Opera extends AbstractAction implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            coma = 0;
            String signoOperacion = event.getActionCommand();//Caturar el signo de operacion

            Math(Double.parseDouble(Screen.getText()));
            TerminoCalculo = signoOperacion;

            Inicio = true;
        }

        public Opera() {
            putValue(Action.SHORT_DESCRIPTION, "Presiona 2 veces el boton y luego el boton igual");
        }

        //Metodo para calcular las operaciones
        public void Math(Double Valor) {

            if (TerminoCalculo.equals("X")) {
                Resultado = Resultado * Valor;
            } else if (TerminoCalculo.equals("-")) {
                Resultado = Resultado - Valor;
            } else if (TerminoCalculo.equals("+")) {
                Resultado = Resultado + Valor;
            } else if (TerminoCalculo.equals("÷")) {
                Resultado = Resultado / Valor;
            } else if (TerminoCalculo.equals("=")) {
                Resultado = Valor;
            } else if (TerminoCalculo.equals("C")) {
                Screen.setText("0");
                String caja = Screen.getText().toString();
                Double caja2 = Double.parseDouble(caja);
                Resultado = caja2;
            }
            Screen.setText(" " + Resultado);

        }
    }
}
