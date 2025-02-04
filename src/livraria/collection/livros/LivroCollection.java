package livraria.collection.livros;

import livraria.models.cliente.Cliente;
import livraria.models.livros.Livro;

import java.util.List;

public interface LivroCollection {

    public void cadastrarLivro(Livro livro);
    public void removerLivro(String code);
    public void editarLivro(String code);
    public void alugarLivro(Cliente cliente, Livro livro);
    public void devolucao(Cliente cliente, String code);
    public List<Livro> listarLivrosDisponiveis();
    public List<Livro> listarLivrosDisponiveisPorGenero();
    public List<Livro> listarLivrosAlugados();
    public List<Livro> listarTodosOsLivros();

}
