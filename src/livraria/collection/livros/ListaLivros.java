package livraria.collection.livros;

import livraria.collection.clientes.ListaClientes;
import livraria.exceptions.LivroNaoExisteException;
import livraria.exceptions.ClienteNaoExisteException;
import livraria.models.cliente.Cliente;
import livraria.models.livros.Livro;
import livraria.models.livros.Status;

import java.util.ArrayList;
import java.util.List;

public class ListaLivros implements LivroCollection{

    public List<Livro> livros = new ArrayList<Livro>();

    @Override
    public void cadastrarLivro(Livro livro) {
            if(livro != null){
                livros.add(livro);
            }
    }

    @Override
    public Livro getLivro(String code) throws LivroNaoExisteException {
        for(Livro livro : livros){
            if(livro.getCode().equals(code)){
                return livro;
            }
        }
        throw new LivroNaoExisteException(code);
    }

    @Override
    public void removerLivro(String code) throws LivroNaoExisteException {
        Livro livroRemover = getLivro(code);
        livros.remove(livroRemover);
    }

    @Override
    public void editarLivro(String code, String nome, String desc, String genero, String autor, Status status) throws LivroNaoExisteException{
        Livro livroEditar = getLivro(code);

        livroEditar.setName(nome);
        livroEditar.setDescricao(desc);
        livroEditar.setGenero(genero);
        livroEditar.setAutor(autor);
        livroEditar.setStatus(status);
    }

    @Override
    public void alugarLivro(ListaClientes clientes, String cpf, String code) throws ClienteNaoExisteException, LivroNaoExisteException {
        try {
            Cliente clienteAlugar = clientes.getCliente(cpf);
            Livro livroAlugar = getLivro(code);

            clienteAlugar.setLivrosAlugados(livroAlugar);
            livros.remove(livroAlugar);

        }catch (ClienteNaoExisteException e){
            //Mostra uma tela de erro ou um alerta na interface em texto
        } catch (LivroNaoExisteException e){
            //Mostra uma tela de erro ou um alerta na interface em texto
        }
    }

    @Override
    public void devolucao(ListaClientes clientes, String cpf, String code) throws ClienteNaoExisteException, LivroNaoExisteException {
        try {
            Cliente clienteDevolucao = clientes.getCliente(cpf);
            Livro livroDevolucao = getLivro(code);

            clienteDevolucao.devolucao(livroDevolucao);
            livros.add(livroDevolucao);

        } catch (ClienteNaoExisteException e){
            //Mostra uma tela de erro ou um alerta na interface em texto
        } catch (LivroNaoExisteException e){
            //Mostra uma tela de erro ou um alerta na interface em texto
        }
    }

    @Override
    public List<Livro> listarLivrosDisponiveis() {
        return livros;
    }

    @Override
    public List<Livro> listarLivrosDisponiveisPorGenero(String genero) {
       List<Livro> livrosGenero = new ArrayList<Livro>();
       for(Livro livro: livros){
           if(livro.getGenero().equals(genero)){
               livrosGenero.add(livro);
           }
       }
       return  livrosGenero;
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
