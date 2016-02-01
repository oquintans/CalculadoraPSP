/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoratcpip;

import javax.swing.JOptionPane;

/**
 *
 * @author oquintansocampo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Servidor sv = new Servidor();
        sv.conexion();
        int bucle = Integer.parseInt(JOptionPane.showInputDialog("Numero de clientes: "));
        for (int i = 1; i <= bucle; i++) {
            Hilo h = new Hilo(i);
            h.start();
            sv.read();
        }

        sv.close();
    }

}
