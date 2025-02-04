package livraria.models.livros;

import java.util.Calendar;

public class LivroTecnico extends Livro{
    public LivroTecnico(String name, int code, String descricao, String genero, String autor, Status status, Calendar dataDevolucao) {
        super(name, code, descricao, genero, autor, status, dataDevolucao);
    }
}
