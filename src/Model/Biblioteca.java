package Model;

public class Biblioteca {
    private int idBiblioteca;
    private String nomeBiblioteca;
    private String cepBiblioteca;

    public Biblioteca(int idBiblioteca, String nomeBiblioteca, String cepBiblioteca) {
        this.idBiblioteca = idBiblioteca;
        this.nomeBiblioteca = nomeBiblioteca;
        this.cepBiblioteca = cepBiblioteca;
    }

    public Biblioteca() {
    }

    public int getIdBiblioteca() {
        return idBiblioteca;
    }

    public void setIdBiblioteca(int idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }

    public String getNomeBiblioteca() {
        return nomeBiblioteca;
    }

    public void setNomeBiblioteca(String nomeBiblioteca) {
        this.nomeBiblioteca = nomeBiblioteca;
    }

    public String getCepBiblioteca() {
        return cepBiblioteca;
    }

    public void setCepBiblioteca(String cepBiblioteca) {
        this.cepBiblioteca = cepBiblioteca;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "idBiblioteca=" + idBiblioteca +
                ", nomeBiblioteca='" + nomeBiblioteca + '\'' +
                ", cepBiblioteca='" + cepBiblioteca + '\'' +
                '}';
    }
}
