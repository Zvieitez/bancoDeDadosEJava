package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluirPessoa {
    public static void main(String[] args) throws SQLException {

        Scanner scn = new Scanner(System.in);

        System.out.println("Informe o código a ser excluído: ");
        int codigo = scn.nextInt();

        Connection conexao = FarmDeConexao.getConnection();
        String sql = "Delete from pessoas where codigo = ?";

        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, codigo);

        //utilizar o if p/ confirmar se realmente alguma linha sofreu algum impacto
        //o "stmt.executeUpdate()" verifica a qtde de linhas que foram excluídas
        if (stmt.executeUpdate() > 0) {

            //mensagem de sucesso na operação de exclusão
            System.out.println("Pessoa excluída com sucesso");

        }else{
            //caso não seja excluída mostra a msg
            System.out.println("Pessoa não excluída: Código não existe na base de dados.");
        }

        conexao.close();
        scn.close();
    }
}
