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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oquintansocampo
 */
public class Servidor {

    ServerSocket serverSocket;
    InetSocketAddress addr;
    OutputStream os;
    InputStream is;
    Socket newSocket;

    public void conexion() {
        try {
            System.out.println("Creando socket servidor");
            serverSocket = new ServerSocket();
            System.out.println("Realizando el bind");
            addr = new InetSocketAddress("localhost", 5555);
            serverSocket.bind(addr);

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void read() {
        try {
            String[] msj;

            System.out.println("Aceptando conexiones");
            newSocket = serverSocket.accept();
            System.out.println("Conexiónn recibida");

            is = newSocket.getInputStream();
            os = newSocket.getOutputStream();
            
            byte[] mensaje = new byte[25];
            is.read(mensaje);
            msj = new String(mensaje).split("-");
            System.out.println("Op1: " + msj[0]);
            System.out.println("Op2: " + msj[1]);
            System.out.println("Operación: " + msj[2]);
            System.out.println("Codigo: " + msj[3]);
            
            int ope = Integer.parseInt(msj[2]);
            if (ope == 1) {
                System.out.println("Resultado: " + (Integer.valueOf(msj[0]) + Integer.valueOf(msj[1])));
            }
            if (ope == 2) {
                System.out.println("Resultado: " + (Integer.valueOf(msj[0]) - Integer.valueOf(msj[1])));
            }
            if (ope == 3) {
                System.out.println("Resultado: " + (Integer.valueOf(msj[0]) * Integer.valueOf(msj[1])));
            }
            if (ope == 4) {
                System.out.println("Resultado: " + (Integer.valueOf(msj[0]) / Integer.valueOf(msj[1])));
            }

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void close() {
        try {
            System.out.println("Cerrando el nuevo socket");
            newSocket.close();
            System.out.println("Cerrando el socket servidor");
            serverSocket.close();
            System.out.println("Terminado");
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
