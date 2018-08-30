package conexao;

import java.net.*;

public class Servidor {

    static ServerSocket serversocket;
    static Socket client_socket;
    static Conexao c;
    static String msg;

    public Servidor() {

        try {
            serversocket = new ServerSocket(9600);
            System.out.println("Criando o Server Socket");
        } catch (Exception e) {
            System.out.println("Nao criei o server socket...");
        }
    }

    public static void main(String args[]) {
        String texto;
        String resposta = "Servidor envia: eai Cliente";
        new Servidor();
        c = new Conexao();
        if (connect()) {
            for (int i = 0; i < 10; i++) {
                texto = c.receive(client_socket);
                System.out.println(texto);
                c.send(client_socket, resposta);
            }
            try {
                client_socket.close();
                serversocket.close();
            } // desconexao
            catch (Exception e) {
                System.out.println("Deu ruim");
            }
        }
    }    
        static boolean connect() {
        boolean ret;
        try {
            client_socket = serversocket.accept();             
            ret = true;
        } catch (Exception e) {
            System.out.println("Não fez conexão" + e.getMessage());
            ret = false;
        }
        return ret;
    }
}


