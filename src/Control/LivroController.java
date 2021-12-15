package Control;

import Dao.LivroDAO;
import Model.Livro;

import java.util.List;

public class LivroController {
    LivroDAO livroDAO = new LivroDAO();

    public void cadastrarLivro(Livro livro){
        livroDAO.criarTabelaLivro();
        livroDAO.cadastrarLivro(livro);
    }

    public List<Livro> listarLivro(){
        return livroDAO.listarLivro();
    }

    public void editarLivro(Livro livro){
        livroDAO.editarLivro(livro);
    }
}
