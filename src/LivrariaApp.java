import livraria.collection.alugueis.ListaAlugueis;
import livraria.collection.clientes.ListaClientes;
import livraria.collection.livros.ListaLivros;
import livraria.exceptions.ClienteJaExisteException;
import livraria.exceptions.ClienteNaoExisteException;
import livraria.exceptions.LivroNaoExisteException;
import livraria.models.cliente.Cliente;
import livraria.models.livros.Livro;
import livraria.models.livros.generos.Hq;
import livraria.models.livros.generos.NaoFiccao;
import livraria.models.livros.LivroFiccao;
import livraria.models.livros.LivroHq;

public class LivrariaApp {

    public static void main(String[] args) {
        // Gerenciadores
        ListaClientes managerClientes = new ListaClientes();
        ListaLivros managerLivros = new ListaLivros();
        ListaAlugueis managerAlugueis = new ListaAlugueis();

        // Criando livros
        LivroFiccao cosmos = new LivroFiccao("Cosmos", "123", "Livro sobre o universo", NaoFiccao.CIENCIA, "Carl Sagan");
        LivroHq homemAranha = new LivroHq("Homem Aranha", "124", "História do herói", Hq.SUPER_HEROIS, "Marvel");

        // Criando cliente
        Cliente c1 = new Cliente("Cliente 1", "123", "Rua Belo");

        try {
            // 1. Cadastrando o cliente
            managerClientes.cadastrarCliente(c1);
            System.out.println("Cliente cadastrado: " + c1);

            // 2. Cadastrando livros
            managerLivros.cadastrarLivro(cosmos);
            managerLivros.cadastrarLivro(homemAranha);
            System.out.println("Livros cadastrados com sucesso!");

            // 3. Alugando um livro via `managerAlugueis`
            managerAlugueis.alugarLivro(managerClientes, managerLivros, "123", "123");
            System.out.println("Livro 'Cosmos' alugado para o cliente.");

            // 4. Exibir multa antes da devolução
            System.out.println("Multa do cliente antes da devolução: " + managerAlugueis.gerarMulta());

            // 5. Listar livros alugados pelo cliente
            System.out.println("Livros alugados pelo cliente:");
            for (Livro livro : managerAlugueis.listarTodosOsLivros()) {
                System.out.println(livro);
            }

            // 6. Devolução do livro
            managerLivros.devolucao(managerAlugueis.devolucao("123", "123"));
            System.out.println("Livro 'Cosmos' devolvido com sucesso.");

            // 7. Listando livros disponíveis na biblioteca após a devolução
            System.out.println("\nLivros disponíveis na biblioteca:");
            for (Livro livro : managerLivros.listarLivrosDisponiveis()) {
                System.out.println(livro);
            }

        } catch (ClienteJaExisteException e) {
            System.out.println("Erro: Cliente já cadastrado - " + e.getMessage());
        } catch (LivroNaoExisteException e) {
            System.out.println("Erro: Livro não encontrado - " + e.getMessage());
        } catch (ClienteNaoExisteException e) {
            System.out.println("Erro: Cliente não encontrado - " + e.getMessage());
        }
    }
}
