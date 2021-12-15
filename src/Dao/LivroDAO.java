package Dao;

import Connection.ConnectionFactory;
import Model.Biblioteca;
import Model.Genero;
import Model.Livro;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

    private Connection connection;
    public LivroDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }

    public void criarTabelaLivro(){
        try{
            String sql = "CREATE TABLE IF NOT EXISTS livro(" +
                    "idLivro INT PRIMARY KEY AUTO_INCREMENT, " +
                    "nomeLivro VARCHAR(255), " +
                    "pagLivro VARCHAR(255), " +
                    "idGenero INT," +
                    "FOREIGN KEY (idGenero) REFERENCES genero(idGenero)," +
                    "idBiblioteca INT," +
                    "FOREIGN KEY (idBiblioteca) REFERENCES biblioteca(idBiblioteca));";

            Statement statement = connection.createStatement();
            statement.execute(sql);
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void cadastrarLivro(Livro livro){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO livro (nomeLivro, pagLivro, idGenero, idBiblioteca) VALUES(?, ?, ?, ?)");

            preparedStatement.setString(1, livro.getNomeLivro());
            preparedStatement.setString(2, livro.getPagLivro());
            preparedStatement.setInt(3, livro.getGenero().getIdGenero());
            preparedStatement.setInt(4, livro.getBiblioteca().getIdBiblioteca());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) JOptionPane.showMessageDialog( null, "LIVRO CADASTRADO COM SUCESSO!!");
            else javax.swing.JOptionPane.showMessageDialog( null, "ERRO AO CADASTRAR LIVRO!!");

        }catch (SQLException e){
            e.printStackTrace();
        }
        return;
    }

    public List<Livro> listarLivro(){
        List<Livro> livroList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from livro");

            while (resultSet.next()){
                Livro livro = new Livro();
                livro.setIdLivro(resultSet.getInt("idLivro"));
                livro.setNomeLivro(resultSet.getString("nomeLivro"));
                livro.setPagLivro(resultSet.getString("pagLivro"));

                Genero genero = new Genero();
                genero.setIdGenero(resultSet.getInt("idGenero"));
                livro.setGenero(genero);

                Biblioteca biblioteca = new Biblioteca();
                biblioteca.setIdBiblioteca(resultSet.getInt("idBiblioteca"));
                livro.setBiblioteca(biblioteca);

                livroList.add(livro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return livroList;
    }

    public void editarLivro(Livro livro){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE livro SET nomeLivro = ?, pagLivro = ? WHERE idLivro = ?");

            preparedStatement.setString(1, livro.getNomeLivro());
            preparedStatement.setString(2, livro.getPagLivro());
            preparedStatement.setInt(3, livro.getIdLivro());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) JOptionPane.showMessageDialog( null, "LIVRO EDITADO COM SUCESSO!!");
            else javax.swing.JOptionPane.showMessageDialog( null, "ERRO AO EDITAR LIVRO!!");

        }catch (SQLException e){
            e.printStackTrace();
        }
        return;
    }
}
