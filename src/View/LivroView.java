package View;

import Control.GeneroController;
import Control.LivroController;
import Model.Biblioteca;
import Model.Genero;
import Model.Livro;

import javax.swing.*;

public class LivroView {
    public void menuLivro(){
        Menu menu = new Menu();
        Livro livro = new Livro();
        String recebe = JOptionPane.showInputDialog(null, "1 - CADASTRAR LIVRO\n2 - LISTAR LIVRO\n3 - EDITAR LIVRO\n4 - VOLTAR");
        if (recebe == null) menu.menuPrincipal();
        switch (recebe){
            case "1":
                cadastrarLivro(livro);
                break;
            case "2":
                listar();
                break;
            case "3":
                editarLivro(livro);
                break;
            case "4":
                menu.menuPrincipal();
                break;
        }
    }

    public void cadastrarLivro(Livro livro){
        LivroController livroController = new LivroController();
        String recebeNome = JOptionPane.showInputDialog(null, "DIGITE O NOME DO LIVRO A SER CADASTRADO: ");
        if (recebeNome == null) menuLivro();
        livro.setNomeLivro(recebeNome.toUpperCase());

        String recebePg = JOptionPane.showInputDialog(null, "DIGITE O NÚMERO DE PAGINAS DESTE LIVRO PARA CADASTRO: ");
        if (recebePg == null) menuLivro();
        livro.setPagLivro(recebePg.toUpperCase());

        GeneroView generoView = new GeneroView();
        generoView.listarGenero();

        String idGenero = JOptionPane.showInputDialog(null, "ESCOLHA O ID DO GÊNERO DESSE LIVRO: ");
        if(idGenero == null) menuLivro();
        Genero genero = new Genero();
        genero.setIdGenero(Integer.parseInt(idGenero));
        livro.setGenero(genero);

        BibliotecaView bibliotecaView = new BibliotecaView();
        bibliotecaView.listarBiblioteca();

        String idBiblioteca = JOptionPane.showInputDialog(null, "ESCOLHA O ID DA BIBLIOTECA QUE TERÁ ESSE LIVRO CADASTRADO: ");
        if(idBiblioteca == null) menuLivro();
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.setIdBiblioteca(Integer.parseInt(idBiblioteca));
        livro.setBiblioteca(biblioteca);

        livroController.cadastrarLivro(livro);
        menuLivro();
    }

    public void listar(){
        String recebe = JOptionPane.showInputDialog(null, "1 - ENCONTRAR LIVRO POR ID\n2 - LISTAR LIVROS POR BIBLIOTECA\n3 - LISTAR LIVROS POR GÊNERO\n4 - LISTAR TODOS LIVROS\n5 - VOLTAR");
        switch (recebe){
            case "1":
                listarLivroId();
                menuLivro();
                break;
            case "2":
                listarLivroBiblioteca();
                menuLivro();
                break;
            case "3":
                listarLivroGenero();
                menuLivro();
                break;
            case "4":
                listarLivro();
                menuLivro();
                break;
            case "5":
                menuLivro();
                break;
        }
    }

    public void listarLivroId() {
        LivroController livroController = new LivroController();
        String recebe = "";
        String idu = JOptionPane.showInputDialog(null, "DIGITE O ID DO LIVRO A SER PROCURADO: ");
        if(idu == null) menuLivro();
        int id = Integer.parseInt(idu);

        for (Livro livro : livroController.listarLivro()){
            if (livro.getIdLivro() == id){
                recebe = recebe + " " + "ID: " + livro.getIdLivro() +
                        " | LIVRO: " + livro.getNomeLivro() +
                        " | PAGINAS: " + livro.getPagLivro() +
                        " | GÊNERO: " + livro.getGenero().getIdGenero() +
                        " | BIBLIOTECA ID: " + livro.getBiblioteca().getIdBiblioteca() + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, recebe);
    }

    public void listarLivro() {
        LivroController livroController = new LivroController();
        String recebe = "";
        for (Livro livro : livroController.listarLivro()){
                recebe = recebe + " " + "ID: " + livro.getIdLivro() +
                        " | LIVRO: " + livro.getNomeLivro() +
                        " | PAGINAS: " + livro.getPagLivro() +
                        " | GÊNERO: " + livro.getGenero().getIdGenero() +
                        " | BIBLIOTECA ID: " + livro.getBiblioteca().getIdBiblioteca() + "\n";
        }
        JOptionPane.showMessageDialog(null, recebe);
    }

    public void listarLivroBiblioteca() {
        LivroController livroController = new LivroController();
        BibliotecaView bibliotecaView = new BibliotecaView();
        bibliotecaView.listarBiblioteca();
        String recebe = "";
        String idu = JOptionPane.showInputDialog(null, "DIGITE O ID DA BIBLIOTECA DOS LIVROS A SEREM PROCURADOS: ");
        if(idu == null) menuLivro();
        int id = Integer.parseInt(idu);

        for (Livro livro : livroController.listarLivro()){
            if (livro.getBiblioteca().getIdBiblioteca() == id){
                recebe = recebe + " " + "ID: " + livro.getIdLivro() +
                        " | LIVRO: " + livro.getNomeLivro() +
                        " | PAGINAS: " + livro.getPagLivro() +
                        " | GÊNERO: " + livro.getGenero().getIdGenero() +
                        " | BIBLIOTECA ID: " + livro.getBiblioteca().getIdBiblioteca() + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, recebe);
    }

    public void listarLivroGenero() {
        LivroController livroController = new LivroController();
        GeneroView generoView = new GeneroView();
        generoView.listarGenero();
        String recebe = "";
        String idu = JOptionPane.showInputDialog(null, "DIGITE O ID DO GENERO DOS LIVROS A SEREM PROCURADOS: ");
        if(idu == null) menuLivro();
        int id = Integer.parseInt(idu);

        for (Livro livro : livroController.listarLivro()){
            if (livro.getGenero().getIdGenero() == id){
                recebe = recebe + " " + "ID: " + livro.getIdLivro() +
                        " | LIVRO: " + livro.getNomeLivro() +
                        " | PAGINAS: " + livro.getPagLivro() +
                        " | GÊNERO: " + livro.getGenero().getIdGenero() +
                        " | BIBLIOTECA ID: " + livro.getBiblioteca().getIdBiblioteca() + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, recebe);
    }

    public void editarLivro(Livro livro){
        LivroController livroController = new LivroController();
        listarLivro();
        String id = JOptionPane.showInputDialog(null, "DIGITE O ID DE QUAL LIVRO VOCÊ DESEJA EDITAR: ");
        if (id == null) menuLivro();
        livro.setIdLivro(Integer.parseInt(id));

        String recebeNome = JOptionPane.showInputDialog(null, "DIGITE O NOME DO NOVO LIVRO: ");
        if (recebeNome == null) menuLivro();
        livro.setNomeLivro(recebeNome.toUpperCase());

        String recebePg = JOptionPane.showInputDialog(null, "DIGITE O NOVO NÚMERO DE PÁGINAS: ");
        if (recebePg == null) menuLivro();
        livro.setPagLivro(recebePg.toUpperCase());

        livroController.editarLivro(livro);
        menuLivro();
    }
}
