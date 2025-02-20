package livraria.collection.livros;

import livraria.collection.alugueis.ListaAlugueis;
import livraria.collection.clientes.ListaClientes;
import livraria.exceptions.ClienteJaExisteException;
import livraria.exceptions.ClienteNaoExisteException;
import livraria.exceptions.LivroNaoExisteException;
import livraria.models.cliente.Cliente;
import livraria.models.livros.Livro;
import livraria.models.livros.LivroTecnico;
import livraria.models.livros.Status;

import java.util.Calendar;
import java.util.List;

public interface LivroCollection {

    public Livro getLivro(String code) throws LivroNaoExisteException;
    public void cadastrarLivro(Livro livro);
    public void removerLivro(String code) throws LivroNaoExisteException;
    public void alugarLivro(String code)throws ClienteNaoExisteException, LivroNaoExisteException;
    public void devolucao(Livro livro);
    public Livro[] listarLivrosDisponiveis();
    public Livro[] listarLivrosDisponiveisPorGenero(String genero);
    public Livro[] listarLivrosAlugados(ListaAlugueis alugueis);
    public Livro[] listarTodosOsLivros(ListaAlugueis alugueis);

}
