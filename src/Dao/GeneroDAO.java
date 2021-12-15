package Dao;

import Connection.ConnectionFactory;
import Model.Biblioteca;
import Model.Genero;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GeneroDAO {

    private Connection connection;
    public GeneroDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }

    public void criarTabelaGenero(){
        try{
            String sql = "CREATE TABLE IF NOT EXISTS genero(" +
                    "idGenero INT PRIMARY KEY AUTO_INCREMENT, " +
                    "nomeGenero VARCHAR(255)); ";

            Statement statement = connection.createStatement();
            statement.execute(sql);
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void cadastrarGenero(Genero genero){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO genero (nomeGenero) VALUES(?)");

            preparedStatement.setString(1, genero.getNomeGenero());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) JOptionPane.showMessageDialog( null, "GÊNERO CADASTRADO COM SUCESSO!!");
            else javax.swing.JOptionPane.showMessageDialog( null, "ERRO AO CADASTRAR GÊNERO!!");

        }catch (SQLException e){
            e.printStackTrace();
        }
        return;
    }

    public List<Genero> listarGenero(){
        List<Genero> generoList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from genero");

            while (resultSet.next()){
                Genero genero = new Genero();
                genero.setIdGenero(resultSet.getInt("idGenero"));
                genero.setNomeGenero(resultSet.getString("nomeGenero"));
                generoList.add(genero);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return generoList;
    }

    public void editarGenero(Genero genero){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE genero SET nomeGenero = ? WHERE idGenero = ?");

            preparedStatement.setString(1, genero.getNomeGenero());
            preparedStatement.setInt(2, genero.getIdGenero());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) JOptionPane.showMessageDialog( null, "GÊNERO EDITADO COM SUCESSO!!");
            else javax.swing.JOptionPane.showMessageDialog( null, "ERRO AO EDITAR GÊNERO!!");

        }catch (SQLException e){
            e.printStackTrace();
        }
        return;
    }
}
