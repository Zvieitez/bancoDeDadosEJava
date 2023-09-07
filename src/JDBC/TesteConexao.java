package JDBC;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {

    public static void main(String[] args) throws SQLException {

        //variável da URL para conexão com o vbanco
        final String url = "jdbc:postgresql://localhost:5432/postgres";
        //variável do usuário do banco
        final String usuario = "postgres";
        //variável da senha do banco
        final String senha = "123";

        //O método getConnection lança uma exceção que precisa ser tratada pelo Throws ou try cat
        //Neste caso implementado se acontecer uma conexão. A aplicação simplesmente sai do método Main
        Connection conexao = DriverManager.getConnection(url,usuario,senha);

        //Caso elepasse do método acima, esta mensagem será exibida no console
        System.out.println("Conexão efetuada com sucesso!");

        //Caso ele passe pelo método acima, esta mensagem será exibida no painel do Java
        JOptionPane.showMessageDialog(null, "Conexão realizada com sucesso!");

        //Finalizae a conexão
        conexao.close();

    }

}
