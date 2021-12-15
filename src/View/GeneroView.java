package View;

import Control.BibliotecaController;
import Control.GeneroController;
import Model.Biblioteca;
import Model.Genero;

import javax.swing.*;
import java.util.Locale;

public class GeneroView {
    public void menuGenero(){
        Menu menu = new Menu();
        Genero genero = new Genero();
        String recebe = JOptionPane.showInputDialog(null, "1 - CADASTRAR GÊNERO\n2 - LISTAR GÊNERO\n3 - EDITAR GÊNERO\n4 - SAIR");
        if (recebe == null) menu.menuPrincipal();
        switch (recebe){
            case "1":
                cadastrarGenero(genero);
                break;
            case "2":
                listarGenero();
                menuGenero();
                break;
            case "3":
                editarGenero(genero);
                break;
            case "4":
                menu.menuPrincipal();
                break;
        }
    }

    public void cadastrarGenero(Genero genero){
        GeneroController generoController = new GeneroController();
        String recebeTipo = JOptionPane.showInputDialog(null, "DIGITE O TIPO DE GENERO A SER CADASTRADO: ");
        if (recebeTipo == null) menuGenero();
        genero.setNomeGenero(recebeTipo.toUpperCase());

        generoController.cadastrarGenero(genero);
        menuGenero();
    }

    public void listarGenero() {
        GeneroController generoController = new GeneroController();
        String recebe = "";
        for (Genero genero : generoController.listarGenero()) {
            recebe = recebe + " " + "ID: " + genero.getIdGenero() +
                    " | NOME : " + genero.getNomeGenero() + "\n";
        }
        JOptionPane.showMessageDialog(null, recebe);
    }

    public void editarGenero(Genero genero){
        GeneroController generoController = new GeneroController();
        listarGenero();
        String id = JOptionPane.showInputDialog(null, "DIGITE O ID DE QUAL GENERO VOCÊ DESEJA EDITAR: ");
        if (id == null) menuGenero();
        genero.setIdGenero(Integer.parseInt(id));

        String recebeTipo = JOptionPane.showInputDialog(null, "DIGITE O NOVO TIPO DE GENERO A SER EDITADO: ");
        if (recebeTipo == null) menuGenero();
        genero.setNomeGenero(recebeTipo.toUpperCase());

        generoController.editarGenero(genero);
        menuGenero();
    }
}
