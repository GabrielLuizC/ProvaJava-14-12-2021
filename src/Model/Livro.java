package Model;

public class Livro {
    private int idLivro;
    private String nomeLivro;
    private String pagLivro;
    private Biblioteca biblioteca;
    private Genero genero;

    public Livro(int idLivro, String nomeLivro, String pagLivro, Biblioteca biblioteca, Genero genero) {
        this.idLivro = idLivro;
        this.nomeLivro = nomeLivro;
        this.pagLivro = pagLivro;
        this.biblioteca = biblioteca;
        this.genero = genero;
    }

    public Livro() {
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public String getPagLivro() {
        return pagLivro;
    }

    public void setPagLivro(String pagLivro) {
        this.pagLivro = pagLivro;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "idLivro=" + idLivro +
                ", nomeLivro='" + nomeLivro + '\'' +
                ", pagLivro='" + pagLivro + '\'' +
                ", biblioteca=" + biblioteca +
                ", genero=" + genero +
                '}';
    }
}
