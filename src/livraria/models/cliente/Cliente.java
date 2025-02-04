package livraria.models.cliente;

import livraria.collection.clientes.ListaClientes;
import livraria.collection.livros.ListaLivros;

public class Cliente {
    private String nome;
    private String cpf;
    private String endereco;
    private double multa;
    private ListaLivros livrosAlugados;

    public static final double valorMulta = 1;

    public String getNome() {
        return nome;
    }

    public void setNome(String name) {
        this.nome = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public ListaLivros getLivrosAlugados() {
        return livrosAlugados;
    }

    public void setLivrosAlugados(ListaLivros livrosAlugados) {
        this.livrosAlugados = livrosAlugados;
    }
}
