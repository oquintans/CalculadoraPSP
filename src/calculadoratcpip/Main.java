/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calculadoratcpip;

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
        Servidor sv= new Servidor();
        Cliente cl= new Cliente();
        sv.conexion();
        cl.conexion();
        cl.msj();
        sv.read();
        cl.close();
        sv.close();
    }
    
}
