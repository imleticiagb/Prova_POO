package dao;

import model.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class LivroDAO {

    private List<Livro> livros = new ArrayList<>();
    private ListIterator<Livro> regLivros;

    public LivroDAO() {
        regLivros = livros.listIterator();
    }

    public void inserirLivro(Livro livro) {
        livros.add(livro);
    }

    public List<Livro> getListaLivros() {
        return livros;
    }

    public void excluirLivroPorCodigo(int codigo) {
        Livro livroParaRemover = null;
        for (Livro livro : livros) {
            if (livro.getCodigo() == codigo) {
                livroParaRemover = livro;
                break;
            }
        }

        if (livroParaRemover != null) {
            livros.remove(livroParaRemover);
        }
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public ListIterator<Livro> getRegLivros() {
        return regLivros;
    }

    public void setRegLivros(ListIterator<Livro> regLivros) {
        this.regLivros = regLivros;
    }
}
