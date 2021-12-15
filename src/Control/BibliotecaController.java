package Control;

import Dao.BibliotecaDAO;
import Model.Biblioteca;

import java.util.List;

public class BibliotecaController {
    BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
    public void cadastrarBiblioteca(Biblioteca biblioteca){
        bibliotecaDAO.criarTabelaBiblioteca();
        bibliotecaDAO.cadastrarBiblioteca(biblioteca);
    }

    public List<Biblioteca> listarBiblioteca(){
        return bibliotecaDAO.listarBiblioteca();
    }
}
