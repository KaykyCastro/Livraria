package livraria.collection.livros;

import livraria.collection.clientes.ListaClientes;
import livraria.exceptions.ClienteJaExisteException;
import livraria.exceptions.ClienteNaoExisteException;
import livraria.exceptions.LivroNaoExisteException;
import livraria.models.cliente.Cliente;
import livraria.models.livros.Livro;
import livraria.models.livros.LivroTecnico;
import livraria.models.livros.Status;

import java.util.List;

public interface LivroCollection {

    public Livro getLivro(String code) throws LivroNaoExisteException;
    public void cadastrarLivro(Livro livro);
    public void removerLivro(String code) throws LivroNaoExisteException;
    public void editarLivro(String code, String nome, String desc, String genero, String autor, Status status)throws LivroNaoExisteException;
    public void alugarLivro(ListaClientes clientes, String cpf, String code)throws ClienteNaoExisteException, LivroNaoExisteException;
    public void devolucao(ListaClientes clientes, String cpf, String code)throws ClienteNaoExisteException, LivroNaoExisteException;
    public List<Livro> listarLivrosDisponiveis();
    public List<Livro> listarLivrosDisponiveisPorGenero(String genero);
    public List<Livro> listarLivrosAlugados();
    public List<Livro> listarTodosOsLivros();

}
