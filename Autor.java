package model;

public class Autor {

    private int codigo;
    private String nome;
    private static int codigost=1;

    public Autor() {
        this.codigo = codigost++;
    }

    public static int getCodigost() {
        return codigost;
    }

    public static void setCodigost(int codigost) {
        Autor.codigost = codigost;
    }

    public Autor(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return codigo + " - " + nome;
    }
}
