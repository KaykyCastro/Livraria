package livraria.models.livros;

import java.util.Calendar;

public abstract class Livro {
    protected String name;
    protected String code;
    protected String descricao;
    protected String genero;
    protected String autor;
    protected Status status;
    protected Calendar dataDevolucao;

    public Livro(String name, String code, String descricao, String genero, String autor, Status status, Calendar dataDevolucao) {
        this.name = name;
        this.code = code;
        this.descricao = descricao;
        this.genero = genero;
        this.autor = autor;
        this.status = status;
        this.dataDevolucao = dataDevolucao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Calendar getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Calendar dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void editarLivro(String name, String code, String descricao, String genero, String autor, Status status, Calendar dataDevolucao){
        this.name = name;
        this.code = code;
        this.descricao = descricao;
        this.genero = genero;
        this.autor = autor;
        this.status = status;
        this.dataDevolucao = dataDevolucao;
    }

}
