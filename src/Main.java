import Dao.BibliotecaDAO;
import Dao.GeneroDAO;
import Dao.LivroDAO;
import View.Menu;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JDialog.setDefaultLookAndFeelDecorated(true);
        Menu menu = new Menu();
        menu.menuPrincipal();
    }
}
