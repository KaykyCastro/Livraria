package livraria.collection.livros;

import livraria.models.cliente.Cliente;
import livraria.models.livros.Livro;

import java.util.ArrayList;
import java.util.List;

public class ListaLivros implements LivroCollection{

    public List<Livro> livros = new ArrayList<Livro>();

    @Override
    public void cadastrarLivro(Livro livro) {

    }

    @Override
    public void removerLivro(String code) {

    }

    @Override
    public void editarLivro(String code) {

    }

    @Override
    public void alugarLivro(Cliente cliente, Livro livro) {

    }

    @Override
    public void devolucao(Cliente cliente, String code) {

    }

    @Override
    public List<Livro> listarLivrosDisponiveis() {
        return List.of();
    }

    @Override
    public List<Livro> listarLivrosDisponiveisPorGenero() {
        return List.of();
    }

    @Override
    public List<Livro> listarLivrosAlugados() {
        return List.of();
    }

    @Override
    public List<Livro> listarTodosOsLivros() {
        return List.of();
    }
}
