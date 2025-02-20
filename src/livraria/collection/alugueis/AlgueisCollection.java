package livraria.collection.alugueis;

import livraria.collection.clientes.ListaClientes;
import livraria.collection.livros.ListaLivros;
import livraria.exceptions.ClienteNaoExisteException;
import livraria.exceptions.LivroNaoExisteException;
import livraria.models.livros.Livro;
import livraria.models.livros.Status;

public interface AlgueisCollection {

    public Livro getLivro(String code) throws LivroNaoExisteException;
    public void alugarLivro(ListaClientes clientes, ListaLivros livros, String cpf, String code)throws ClienteNaoExisteException, LivroNaoExisteException;
    public Livro devolucao(String cpf, String code)throws ClienteNaoExisteException, LivroNaoExisteException;
    public Livro[] listarTodosOsLivros();

}
