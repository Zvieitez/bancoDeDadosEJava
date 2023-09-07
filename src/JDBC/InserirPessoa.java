package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InserirPessoa {

    public static void main(String[] args) throws SQLException {

        Scanner scn = new Scanner(System.in);

        //jeito certo (inpicio) - desse jeito que foi criado ele bloqueará tentaiva de
        System.out.println("Informe o nome");
        String nome = scn.nextLine();

        //chamada da conexão
        Connection conexao = FarmDeConexao.getConnection();

        //comando sql de inserção
        String sql = "Insert Into pessoas (nome) Values (?)";
        //String sql = "Insert Into pessoas (nome, codigo) Values (?,?)";

        //preparo de declaração
        PreparedStatement stmt = conexao.prepareStatement(sql);
        //parametrizando

        stmt.setString(1, nome);
        //stms.setInt(2, 100);

        //execução da query
        stmt.execute();

        System.out.println("Pessoa inserida com sucesso!");

        //fechando scanner
        scn.close();
        //jeito certo (FIM)

    }

    }

