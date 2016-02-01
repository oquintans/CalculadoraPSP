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
public class Hilo extends Thread {

    private int numH;

    public Hilo(int numH) {
        this.numH = numH;
    }

    @Override
    public void run() {
        Cliente cli = new Cliente();
        cli.conexion();
        cli.msj(numH);
        cli.close();
    }

}
