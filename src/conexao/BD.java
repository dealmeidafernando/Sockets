
package conexao;

import java.sql.*;

public class BD {
static Connection conexao;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        conecta();
        executa("insert into job(title, description, salary, state, city) values('t','t',2,'sp','sp')");
        lista();
        desconecta();
        
    }
    public static void conecta(){
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
    public static void executa(String sql) throws Exception{
        Statement st = null;
        st = conexao.createStatement();
        st.executeUpdate(sql);
    }
    public static void lista() throws Exception{
        Statement st;
        st = conexao.createStatement();
        ResultSet rs = st.executeQuery("SELECT * from job");
        System.out.println("-----------------------");
        while(rs.next()){
            System.out.println("Cod: " + rs.getString(1));
        }
}
    public static void desconecta() throws Exception {
        conexao.close();
    }
}