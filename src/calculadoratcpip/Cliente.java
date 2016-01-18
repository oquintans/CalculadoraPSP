/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoratcpip;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author oquintansocampo
 */
public class Cliente {

    Socket clienteSocket;
    InetSocketAddress addr;
    InputStream is;
    OutputStream os;

    public void conexion() {
        try {
            System.out.println("Creando socket cliente");
            clienteSocket = new Socket();
            System.out.println("Estableciendo la conexión");

            addr = new InetSocketAddress("localhost", 5555);
            clienteSocket.connect(addr);
            is = clienteSocket.getInputStream();
            os = clienteSocket.getOutputStream();

        } catch (IOException e) {
            System.out.println("ERROR");
        }
    }

    public void msj() {
        try {
            System.out.println("Enviando mensaje");
            String op1 = JOptionPane.showInputDialog("Numero 1:\n");
            op1 = op1 + "-";
            String op2 = JOptionPane.showInputDialog("Numero 2:\n");
            op2 = op2 + "-";
            String ope = JOptionPane.showInputDialog("Operación:\n1=suma\n2=resta\n3=producto\n4=division");
            ope = ope + "-";
            String msj = op1 + op2 + ope;
            os.write(msj.getBytes());

            System.out.println("Mensaje enviado");

        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void close() {
        try {
            System.out.println("Cerrando el socket cliente");
            clienteSocket.close();
            System.out.println("Terminado");
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
