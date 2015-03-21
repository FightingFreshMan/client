/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author my
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    static DataInputStream dataFromServer = null;
    static DataOutputStream dataToServer = null;

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        ClientJFrame cjf = new ClientJFrame();
        cjf.show();
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        dataFromServer = new DataInputStream(socket.getInputStream());
        dataToServer = new DataOutputStream(socket.getOutputStream());
        //dataToServer.writeChar('C');
        while (true) {
            ClientJFrame.clientMessageArea.append("Server:\n\t"+dataFromServer.readUTF()+'\n');
        }
        //System.out.println(dataFromServer.readUTF());

    }

}
