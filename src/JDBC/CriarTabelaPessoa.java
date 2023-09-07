package JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelaPessoa {
    public static void main(String[] args) throws SQLException {
        Connection conexao = FarmDeConexao.getConnection();

        String sql = "create table pessoas (" + "Codigo serial Primary Key," + "nome varchar(60) not null" + ")";

        Statement stmt = conexao.createStatement();

        stmt.execute(sql);

        System.out.println("Tabela criada com sucesso!");

        conexao.close();

    }
}
