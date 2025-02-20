package livraria.collection.alugueis;

import livraria.collection.clientes.ListaClientes;
import livraria.collection.livros.ListaLivros;
import livraria.exceptions.ClienteNaoExisteException;
import livraria.exceptions.LivroNaoExisteException;
import livraria.models.cliente.Cliente;
import livraria.models.livros.Livro;
import livraria.models.livros.Status;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ListaAlugueis implements AlgueisCollection{

    private Cliente cliente;
    public List<Livro> livrosAlugados = new ArrayList<Livro>();

    public static final double valorMulta = 1;

    @Override
    public Livro getLivro(String code) throws LivroNaoExisteException {
        return null;
    }

    @Override
    public void alugarLivro(ListaClientes clientes, ListaLivros livros, String cpf, String code) throws ClienteNaoExisteException, LivroNaoExisteException {
        Cliente clienteAlugar = clientes.getCliente(cpf);
        Livro livroAlugar = livros.getLivro(code);
        livroAlugar.setStatus(Status.ALUGADO);

        Calendar dataDevolucao = Calendar.getInstance();
        dataDevolucao.add(Calendar.DAY_OF_MONTH, 7);
        livroAlugar.setDataDevolucao(dataDevolucao);

        this.cliente = clienteAlugar;
        livrosAlugados.add(livroAlugar);
    }

    @Override
    public Livro devolucao(String cpf, String code) throws ClienteNaoExisteException, LivroNaoExisteException {
        if(cpf.equals(cliente.getCpf())){
            for(Livro livro: livrosAlugados){
                if(livro.getCode() == code){
                    Livro livroRetorno = livro;
                    livrosAlugados.remove(livro);
                    Calendar dataAtual = Cliente.oBterDataAtual();
                    if(livro.getDataDevolucao().before(dataAtual)){
                        long diffMillis = dataAtual.getTimeInMillis() - livro.getDataDevolucao().getTimeInMillis();
                        int diasAtraso = (int) (diffMillis/ (1000 * 60 * 60 * 24));
                        this.cliente.removerValorMulta(diasAtraso * valorMulta);
                    }

                    livroRetorno.setStatus(Status.DISPONIVEL);
                    return livroRetorno;
                }
            }
        }
        return null;
    }

    @Override
    public Livro[] listarTodosOsLivros() {
        Livro[] retorno = new Livro[livrosAlugados.size()];
        return livrosAlugados.toArray(retorno);
    }

    public double gerarMulta(){
        int diasAtraso = 0;
        Calendar dataAtual = Cliente.oBterDataAtual();
        for(Livro livro : livrosAlugados){
            if(livro.getDataDevolucao().before(dataAtual)){
                long diffMillis = dataAtual.getTimeInMillis() - livro.getDataDevolucao().getTimeInMillis();
                diasAtraso = (int) (diffMillis/ (1000 * 60 * 60 * 24));
            }
        }
        double valorMulta = diasAtraso * 1;

        if(cliente.getMulta() < valorMulta){
            cliente.setMulta(valorMulta);
            return valorMulta;
        }
        return valorMulta;
    }

    /**
     * Retorna a data atual.
     *
     * @return Calendar , retorna a data atual a ser usada.
     * **/
    public static Calendar oBterDataAtual(){
        return Calendar.getInstance();
    }

}
