package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class AlterarNomePessoa {

    public static void main(String[] args) throws SQLException {

        // Declaracao do scanner
        Scanner scn = new Scanner(System.in);

        // Para atualizar algo incialmente é preciso ter uma conexão
        // Abertura da conexão com o banco de dados
        Connection conexao = FarmDeConexao.getConnection();

        // Mensagem que apresentara para que o usuario possa digitar o valor da pesquisa
        System.out.println("Informe o codigo da pessoa");
        int codigo = scn.nextInt();

        // comando sql a ser executado
        String sql1 = "Select codigo, nome from pessoas where codigo = ?";

        // cria a preparação da declaracao para receber um resultado do sql
        PreparedStatement stmt = conexao.prepareStatement(sql1);
        stmt.setInt(1, codigo);
        ResultSet resultado = stmt.executeQuery(); // Nao passar nessa parte o comando sql

        // Feito um IF para verificar se teve algum resultado atraves do
        // "resultado.next()"
        if (resultado.next()) {

            // Cria uma nova pessoa setando a coluna 1 e coluna 2 conforme select acima
            Pessoa p = new Pessoa(resultado.getInt(1), resultado.getString(2));

            // Exibe o nome atual
            System.out.println("Nome atual eh " + p.getNome());
            scn.nextLine();

            // Exibe uma mensagem pedindo para o usuario digitar o novo nome
            System.out.println("Informe o novo nome");
            String novoNome = scn.nextLine();

            String sql2 = "Update pessoas " + "set nome = ? " + "Where codigo = ?";

            stmt.close();
            // Abre uma nova conexao para pegar o novo sql (update)
            stmt = conexao.prepareStatement(sql2);
            // Pega como parametro 1 o novoNome indicado e capturado pelo scanner
            stmt.setString(1, novoNome);
            // recupera o codigo que foi digitado pela pessoa no primeiro scanner
            stmt.setInt(2, codigo);
            // executa a operacao utiliza somente o execute pois não vai pegar resultado de
            // uma query
            // vai rodar diretamente o update
            stmt.execute();

            System.out.println("Pessoa alterada com sucesso");

        }

        // Fecha o statement
        stmt.close();
        // Fecha a conexão
        conexao.close();
        // Fechar o scanner
        scn.close();
    }

}