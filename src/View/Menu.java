package View;

import javax.swing.*;

public class Menu {
    public void menuPrincipal(){
        String selecionado = JOptionPane.showInputDialog(null, "1 - BIBLIOTECA\n2 - GENERO\n3 - LIVRO\n4 - SAIR", JOptionPane.INFORMATION_MESSAGE);
        if (selecionado == null) JOptionPane.showMessageDialog(null, "Saindo do sistema, Agradecemos o seu uso!!");
        switch (selecionado){
            case "1":
                BibliotecaView bibliotecaView = new BibliotecaView();
                bibliotecaView.menuBiblioteca();
                break;
            case "2":
                GeneroView generoView = new GeneroView();
                generoView.menuGenero();
                break;
            case "3":
                LivroView livroView = new LivroView();
                livroView.menuLivro();
                break;
            case "4":
                JOptionPane.showMessageDialog(null, "Saindo do sistema, Agradecemos o seu uso!!");
                break;
            default:
                JOptionPane.showMessageDialog(null, "ERROR NO SISTEMA, REINICIE E TENTE NOVAMENTE");
                return;
        }
    }
}
