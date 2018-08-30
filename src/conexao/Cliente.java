
package conexao;

import java.io.IOException;
import java.net.*;


public class Cliente {
  static Conexao c;
  static Socket socket;
  
  public Cliente() {
    try {
      socket = new Socket("10.159.26.219",9600); 
    }    
    catch (Exception e) {
      System.out.println("Nao consegui resolver o host...");
    }
  }
  public static void main(String args[]) throws IOException{
     String msg = "Cliente envia : Olá Servidor";
     String texto;
     new Cliente();  
     for (int i=0; i<10; i++){                
        c.send(socket, msg);                           
        texto = c.receive(socket);                    
        System.out.println(texto);                         
     }
     try {
        socket.close();                               
     } catch (IOException e){
         System.out.println("Não encerrou a conexão corretamente" + e.getMessage());
     }
  }
}


