package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FarmDeConexao {
    //Metoddo pelo qual irá facilicar as chamadas de conexão. Será bem reutilizadaa.

    public static Connection getConnection() {

        try {
            //variáavel da URL para conexão com o banco
            final String url = "jdbc:postgresql://localhost:5432/postgres";
            //variável do usuário do banco
            final String usuario = "postgres";
            //variável da senha do banco
            final String senha = "123";

            //O método getConnection lança uma exceção que precisa ser tratada pelo Throws ou neste caso implementado
            //se acontecer uma exceção, a aplicação simplesmente sai.

            return DriverManager.getConnection(url, usuario, senha);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
}
