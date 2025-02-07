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
    /**
     * Adiciona um livro na lista livros.
     *
     * @param (livro) , livros ser cadastrado.
     * **/
    public void cadastrarLivro(Livro livro) {
                livros.add(livro);
    }

    @Override
    /**
     * Retorna um livro de acordo com o codigo do livro.
     *
     * @return livro , livro encontrado.
     * **/
    public Livro getLivro(String code) throws LivroNaoExisteException {
        for(Livro livro : livros){
            if(livro.getCode().equals(code)){
                return livro;
            }
        }
        throw new LivroNaoExisteException(code);
    }

    @Override
    /**
     * Remove um livro da lista de livro com base no codigo do livro.
     *
     * @param (code) , codigo do livro a ser removido.
     * **/
    public void removerLivro(String code) throws LivroNaoExisteException {
        Livro livroRemover = getLivro(code);
        livros.remove(livroRemover);
    }

    @Override
    /**
     * Edita os dados de uma livro cadastrado.
     *
     * @param (code,data) , codigo do livro a ser editado e os dados novo, respectivamente.
     * **/
    public void editarLivro(String code, String nome, String desc, Enum genero, String autor, Status status) throws LivroNaoExisteException{
        Livro livroEditar = getLivro(code);

        livroEditar.setName(nome);
        livroEditar.setDescricao(desc);
        livroEditar.setGenero(genero);
        livroEditar.setAutor(autor);
        livroEditar.setStatus(status);
    }

    @Override
    /**
     * Adiciona um livro na lista de livros do Cliente e remove o livro da lista da livraria,
     * assim efetuando o aluguel do livro pro cliente.
     *
     * @param (clientes, cpf, code) , clientes é a lista de clientes da livraria, cpf é o cpf
     *do cliente que alugara, e code o codigo do livro a ser alugado, respectivamente.
     * **/
    public void alugarLivro(ListaClientes clientes, String cpf, String code) throws ClienteNaoExisteException, LivroNaoExisteException {
            Cliente clienteAlugar = clientes.getCliente(cpf);
            Livro livroAlugar = getLivro(code);

            clienteAlugar.setLivrosAlugados(livroAlugar);
            livros.remove(livroAlugar);

    }

    @Override
    /**
     * Retorna um livro a livraria, adicionando novamente o livro a lista de livros da livraria
     * e removendo da lista de livros do cliente, e zera o valor da multa que o livro gerava.
     *
     * @param (clientes, cpf, code) , lientes é a lista de clientes da livraria, cpf é o cpf
     * do cliente que alugara, e code o codigo do livro a ser alugado, respectivamente.
     * **/
    public void devolucao(ListaClientes clientes, String cpf, String code) throws ClienteNaoExisteException, LivroNaoExisteException {
        try {
            Cliente clienteDevolucao = clientes.getCliente(cpf);
            Livro livroDevolucao = clienteDevolucao.getLivroAlugadoPorCodigo(code);
            livroDevolucao.setStatus(Status.DISPONIVEL);

            clienteDevolucao.devolucao(livroDevolucao);
            livros.add(livroDevolucao);

        } catch (ClienteNaoExisteException e){
            System.out.println(e);
        } catch (LivroNaoExisteException e){
            System.out.println(e);
        }
    }

    @Override
    /**
     * Retorna uma Array com todos os filmes com status: DISPONIVEL.
     *
     * @return Array , Array no qual cotem todos os livros disponiveis.
     * **/
    public Livro[] listarLivrosDisponiveis() {
        List<Livro> livrosDisponiveis = new ArrayList<Livro>();
        for (Livro livro : livros){
            if(livro.getStatus().equals(Status.DISPONIVEL)){
                livrosDisponiveis.add(livro);
            }
        }

        return livrosDisponiveis.toArray(new Livro[0]);
    }

    @Override
    /**
     * Retorna uma Array com todos os filmes com status: DISPONIVEL e por genero.
     *
     * @param (genero) genero no qual o livro pertence
     * @return Array , Array no qual cotem todos os livros diponiveis e do genero especificado.
     * **/
    public Livro[] listarLivrosDisponiveisPorGenero(String genero) {
       List<Livro> livrosGenero = new ArrayList<Livro>();
       for(Livro livro: livros){
           if(livro.getGenero().equals(genero) && livro.getStatus().equals(Status.DISPONIVEL)){
               livrosGenero.add(livro);
           }
       }

       return livrosGenero.toArray(new Livro[0]);
    }

    @Override
    /**
     * Retorna uma Array com todos os filmes com status: ALUGADO.
     *
     * @return Array , Array no qual cotem todos os livros alugados.
     * **/
    public Livro[] listarLivrosAlugados() {
        List<Livro> livrosAlugados = new ArrayList<Livro>();
        for (Livro livro : livros){
            if(livro.getStatus().equals(Status.ALUGADO)){
                livrosAlugados.add(livro);
            }
        }

        return livrosAlugados.toArray(new Livro[0]);
    }

    @Override
    /**
     * Retorna uma Array com todos os filmes com status: DISPONIVEL E ALUGADO.
     *
     * @return Array , Array no qual cotem todos os livros diponiveis e alugados.
     * **/
    public Livro[] listarTodosOsLivros() {
        Livro[] retorno = new Livro[livros.size()];
        return livros.toArray(retorno);
    }
}
