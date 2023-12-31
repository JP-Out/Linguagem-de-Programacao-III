package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TryConnection {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        // Obtém a conexão
        try (Connection connection = connectionFactory.getConnection()) {
            // Realiza uma busca simples na tabela Produto
            String sql = "SELECT * FROM Produto LIMIT 1";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    int idProduto = resultSet.getInt("id_produto");
                    String nomeProduto = resultSet.getString("nome_produto");
                    double valorProduto = resultSet.getDouble("valor_produto");
                    String codBarras = resultSet.getString("cod_barras");

                    System.out.println("ID: " + idProduto + ", Nome: " + nomeProduto + ", Valor: " + valorProduto + ", Codigo: " + codBarras + ";");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
