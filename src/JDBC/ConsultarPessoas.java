package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConsultarPessoas {

    public static void main(String[] args) throws SQLException {

        //Para consultar algo incialmente é preciso ter uma conexão
        Connection conexao = FarmDeConexao.getConnection();

        //Comando sql a ser executado
        String sql = "Select * from pessoas";

        //Cria a declaração para receber um resultado sql
        Statement stmt = conexao.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);

        //Criar uma lista de pessoas para armazenar os dados vindo do banco
        List<Pessoa> pessoas = new ArrayList<>();

        //percorre todas as linhas de Resultset
        while (resultado.next()){
            //pega o resultado do código e nome
            int codigo = resultado.getInt ("codigo");
            String nome = resultado.getString("nome");

            //criar uma pessoa
            pessoas.add(new Pessoa(codigo,nome));

        }

        for (Pessoa p: pessoas) {
            System.out.println(p.getCodigo() + " --->> " + p.getNome());
        }

        stmt.close();
        conexao.close();
    }
}
