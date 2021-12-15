package Dao;

import Connection.ConnectionFactory;
import Model.Biblioteca;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaDAO {

    private Connection connection;
    public BibliotecaDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }

    public void criarTabelaBiblioteca(){
        try{
            String sql = "CREATE TABLE IF NOT EXISTS biblioteca(" +
                    "idBiblioteca INT PRIMARY KEY AUTO_INCREMENT, " +
                    "nomeBiblioteca VARCHAR(255), " +
                    "cepBiblioteca VARCHAR(255)); ";

            Statement statement = connection.createStatement();
            statement.execute(sql);
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void cadastrarBiblioteca(Biblioteca biblioteca){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO biblioteca (nomeBiblioteca, cepBiblioteca) VALUES(?, ?)");

            preparedStatement.setString(1, biblioteca.getNomeBiblioteca());
            preparedStatement.setString(2, biblioteca.getCepBiblioteca());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) JOptionPane.showMessageDialog( null, "BIBLIOTECA CADASTRADA COM SUCESSO!!");
            else javax.swing.JOptionPane.showMessageDialog( null, "ERRO AO CADASTRAR BIBLIOTECA!!");

        }catch (SQLException e){
            e.printStackTrace();
        }
        return;
    }

    public List<Biblioteca> listarBiblioteca(){
        List<Biblioteca> bibliotecaList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from biblioteca");

            while (resultSet.next()){
                Biblioteca biblioteca = new Biblioteca();
                biblioteca.setIdBiblioteca(resultSet.getInt("idBiblioteca"));
                biblioteca.setNomeBiblioteca(resultSet.getString("nomeBiblioteca"));
                biblioteca.setCepBiblioteca(resultSet.getString("cepBiblioteca"));
                bibliotecaList.add(biblioteca);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bibliotecaList;
    }
}
