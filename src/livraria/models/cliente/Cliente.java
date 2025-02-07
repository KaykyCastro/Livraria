package livraria.models.cliente;

import livraria.collection.livros.ListaLivros;
import livraria.exceptions.LivroNaoExisteException;
import livraria.models.livros.Livro;
import livraria.models.livros.Status;
import java.util.Calendar;


public class Cliente {
    private String nome;
    private String cpf;
    private String endereco;
    private double multa;
    private ListaLivros livrosAlugados;

    public static final double valorMulta = 1;

    public Cliente(String nome, String cpf, String endereco){
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.livrosAlugados = new ListaLivros();
        this.multa = 0;
    }

    /**
     * Retorna o nome do Cliente.
     *
     * @return nome , nome no qual pertence ao cliente instanciado.
     * **/
    public String getNome() {
        return nome;
    }

    /**
     * Adiciona o nome do Cliente.
     *
     * @param (name) , nome nome no qual sera adicionado ao cliente instanciado.
     * **/
    public void setNome(String name) {
        this.nome = name;
    }

    /**
     * Retorna o cpf do Cliente.
     *
     * @return cpf , cpf no qual pertence ao cliente instanciado.
     * **/
    public String getCpf() {
        return cpf;
    }

    /**
     * Adiciona o cpf do Cliente.
     *
     * @param (cpf) , cpf no qual sera adicionado ao cliente instanciado.
     * **/
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Retorna o endereco do Cliente.
     *
     * @return endereco , endereco no qual pertence ao cliente instanciado.
     * **/
    public String getEndereco() {
        return endereco;
    }

    /**
     * Adiciona o endereco do Cliente.
     *
     * @param (endereco) , endereco no qual sera adicionado ao cliente instanciado.
     * **/
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Gera a multa total o cliente com base em todos os livros.
     *
     * @return multa , multa total no qual pertence ao cliente instanciado.
     * **/
    public double gerarMulta(){
        int diasAtraso = 0;
        Calendar dataAtual = Cliente.oBterDataAtual();
        for(Livro livro : livrosAlugados.listarTodosOsLivros()){
            if(livro.getDataDevolucao().before(dataAtual)){
               long diffMillis = dataAtual.getTimeInMillis() - livro.getDataDevolucao().getTimeInMillis();
               diasAtraso = (int) (diffMillis/ (1000 * 60 * 60 * 24));
            }
        }

        double valorMulta = diasAtraso * 1;

        return valorMulta;
    }

    /**
     * Adiciona uma multa ao Cliente.
     *
     * @param (multa) , multa no qual sera adicionado ao cliente instanciado.
     * **/
    public void setMulta(double multa) {
        this.multa = multa;
    }

    /**
     * Retorna um Livro alugado pelo codigo do livro.
     *
     * @return livro , livro no qual pertence a lista de livros alugados do cliente.
     * **/
    public Livro getLivroAlugadoPorCodigo(String code) throws LivroNaoExisteException {
        Livro livroAlugado = livrosAlugados.getLivro(code);
        return livroAlugado;
    }

    /**
     * Retorna todos os Livro alugado do cliente.
     *
     * @return Array , Array no qual contem a lista de livros alugados do cliente.
     * **/
    public Livro[] getLivrosAlugados() {
        return livrosAlugados.listarLivrosAlugados();
    }

    /**
     * Adiciona um livro na lista livros alugados.
     *
     * @param (livroAlugar) , livroAlugar é o livro a ser cadastrado.
     * **/
    public void setLivrosAlugados(Livro livroAlugar) {
        livroAlugar.setStatus(Status.ALUGADO);

        Calendar dataDevolucao = Calendar.getInstance();
        dataDevolucao.add(Calendar.DAY_OF_MONTH, 7);
        livroAlugar.setDataDevolucao(dataDevolucao);
        this.livrosAlugados.cadastrarLivro(livroAlugar);
    }

    /**
     * Remove um livro da lista de livros alugados do cliente e remove a multa que o livro
     * contem.
     *
     * @param (livroDevolucao) , livroDevolucao e o livro a ser removido da lista de livros alugados.
     * **/
    public void devolucao(Livro livroDevolucao)throws LivroNaoExisteException {
        livroDevolucao.setStatus(Status.DISPONIVEL);
        Calendar dataAtual = Cliente.oBterDataAtual();
        Livro livrogeraMulta = livrosAlugados.getLivro(livroDevolucao.getCode());

        if(livrogeraMulta.getDataDevolucao().before(dataAtual)){
            long diffMillis = dataAtual.getTimeInMillis() - livrogeraMulta.getDataDevolucao().getTimeInMillis();
            int diasAtraso = (int) (diffMillis/ (1000 * 60 * 60 * 24));
            this.multa -= diasAtraso * valorMulta;
        }

        livroDevolucao.setDataDevolucao(null);
        this.livrosAlugados.removerLivro(livroDevolucao.getCode());
    }

    @Override
    /**
     * Retorna um modelo para ser exibido.
     *
     * @return String , String na qual contem os dados do cliente a ser exibido.
     * **/
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", endereco='" + endereco + '\'' +
                ", multa=" + multa +
                ", livrosAlugados=" + livrosAlugados +
                '}';
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
