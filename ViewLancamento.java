package view;

import dao.LivroDAO;
import model.Autor;
import model.Livro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ViewLancamento extends JFrame {
    private LivroDAO livroDAO;
    private JComboBox<Autor> autorComboBox;
    private JTextField nomeLivroField;
    private JButton salvarLivroButton, excluirLivroButton;
    private DefaultListModel<String> listaModel;
    private JList<String> listaLivros;

    public ViewLancamento() {
        livroDAO = new LivroDAO();

        setTitle("Cadastro e Lançamento de Livros");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(4, 2));

        List<Autor> autores = new ArrayList<>();
        Autor autor1 = new Autor(1, "Fulano");
        Autor autor2 = new Autor(2, "Ciclano");
        Autor autor3 = new Autor(3, "Beltrano");
        Autor autor4 = new Autor(4, "Outrano");
        autores.add(autor1);
        autores.add(autor2);
        autores.add(autor3);
        autores.add(autor4);

        autorComboBox = new JComboBox<>(autores.toArray(new Autor[0]));

        JLabel nomeLivroLabel = new JLabel("Nome do Livro:");
        nomeLivroField = new JTextField();

        salvarLivroButton = new JButton("Salvar Livro");
        excluirLivroButton = new JButton("Excluir Livro");

        formPanel.add(new JLabel("Autor:"));
        formPanel.add(autorComboBox);
        formPanel.add(nomeLivroLabel);
        formPanel.add(nomeLivroField);
        formPanel.add(salvarLivroButton);
        formPanel.add(excluirLivroButton);

        listaModel = new DefaultListModel<>();
        listaLivros = new JList<>(listaModel);
        JScrollPane scrollPane = new JScrollPane(listaLivros);

        salvarLivroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Autor autorSelecionado = (Autor) autorComboBox.getSelectedItem();
                String nomeLivro = nomeLivroField.getText();

                Livro livro = new Livro(0, nomeLivro);
                livro.setAutor(autorSelecionado);
                livroDAO.inserirLivro(livro);

                atualizarListaLivros();
            }
        });

        excluirLivroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String livroSelecionado = listaLivros.getSelectedValue();
                if (livroSelecionado != null) {
                    String[] partes = livroSelecionado.split(" - ");
                    int codigoLivro = Integer.parseInt(partes[0]);
                    livroDAO.excluirLivroPorCodigo(codigoLivro);

                    atualizarListaLivros();
                }
            }
        });

        add(formPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
        atualizarListaLivros();
    }

    private void atualizarListaLivros() {
        listaModel.clear();
        List<Livro> livros = livroDAO.getListaLivros();
        for (Livro livro : livros) {
            String textoLivro = livro.getCodigost() + " - " + livro.getTitulo() + " (Autor: " + livro.getAutor().getNome() + ")";
            listaModel.addElement(textoLivro);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ViewLancamento();
            }
        });
    }
}
