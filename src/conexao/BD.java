
package conexao;

import java.sql.*;

public class BD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        conecta();
        
    }
    public static void conecta(){
        Connection conexao;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/vagas";
        String login = "root";
        String senha = "1234";
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, login, senha);
            System.out.println("Conexao bem sucedida");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
