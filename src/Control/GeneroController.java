package Control;

import Dao.GeneroDAO;
import Model.Biblioteca;
import Model.Genero;

import java.util.List;

public class GeneroController {
    GeneroDAO generoDAO = new GeneroDAO();
    public void cadastrarGenero(Genero genero){
        generoDAO.criarTabelaGenero();
        generoDAO.cadastrarGenero(genero);
    }

    public List<Genero> listarGenero(){
        return generoDAO.listarGenero();
    }

    public void editarGenero(Genero genero){
        generoDAO.editarGenero(genero);
    }
}
