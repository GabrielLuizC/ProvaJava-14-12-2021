package View;

import Control.BibliotecaController;
import Model.Biblioteca;

import javax.swing.*;
import java.util.Locale;

public class BibliotecaView {
    public void menuBiblioteca(){
        Menu menu = new Menu();
        Biblioteca biblioteca = new Biblioteca();
        String recebe = JOptionPane.showInputDialog(null, "1 - CADASTRAR BIBLIOTECA\n2 - LISTAR BIBLIOTECAS\n3 - SAIR");
        if (recebe == null) menu.menuPrincipal();
        switch (recebe){
            case "1":
                cadastrarBiblioteca(biblioteca);
                break;
            case "2":
                listarBiblioteca();
                menuBiblioteca();
                break;
            case "3":
                menu.menuPrincipal();
                break;
        }
    }

    public void cadastrarBiblioteca(Biblioteca biblioteca){
        BibliotecaController bibliotecaController = new BibliotecaController();
        String recebeNome = JOptionPane.showInputDialog(null, "DIGITE O NOME DA BIBLIOTECA: ");
        if (recebeNome == null) menuBiblioteca();
        biblioteca.setNomeBiblioteca(recebeNome.toUpperCase());

        String recebeCep = JOptionPane.showInputDialog(null, "DIGITE O CEP DA BIBLIOTECA: ");
        if (recebeCep == null) menuBiblioteca();
        biblioteca.setCepBiblioteca(recebeCep.toUpperCase());
        bibliotecaController.cadastrarBiblioteca(biblioteca);
        menuBiblioteca();
    }

    public void listarBiblioteca() {
        BibliotecaController bibliotecaController = new BibliotecaController();
        String recebe = "";
        for (Biblioteca biblioteca : bibliotecaController.listarBiblioteca()) {
            recebe = recebe + " " + "ID: " + biblioteca.getIdBiblioteca() +
                                    " | NOME : " + biblioteca.getNomeBiblioteca() +
                                    " | CEP : " + biblioteca.getCepBiblioteca() + "\n";
        }
        JOptionPane.showMessageDialog(null, recebe);
    }
}
