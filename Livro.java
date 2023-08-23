package model;

public class Livro {

private int codigo;
private String titulo;
Autor autor;
private static int codigost=1;

    public static int getCodigost() {
        return codigost;
    }

    public static void setCodigost(int codigost) {
        Livro.codigost = codigost;
    }

    public Autor getAutor() {
        this.codigo = codigost++;
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Livro() {}

    public Livro(int codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return codigo + " - " + titulo;
    }
}
