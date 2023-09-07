package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DesafioConsultarPessoa {

    public static void main(String[] args) throws SQLException {

        Scanner scn = new Scanner(System.in);

        //para consultar algo inicialmente é preciso estabelecer uma conexão
        //abertura do banco de dados
        Connection conexao = FarmDeConexao.getConnection();

        //comando sql a ser executado
        String sql = "Select * from pessoas where nome like ?";

        //mensagem para usuário digitar
        System.out.println("Informe um dado para a pesquisa");
        String valor = scn.nextLine();

        //criar a preparação da declaração para recebr um resultado sql
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, "%" + valor + "%");
        ResultSet resultado = stmt.executeQuery(); //não passar nessa parte o comando sql

        //criar lista para armazenar pessoas
        List<Pessoa> pessoas = new ArrayList<>();

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
