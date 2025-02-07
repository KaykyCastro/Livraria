import java.util.Calendar;
import java.util.Collections;

import livraria.collection.clientes.ClienteCollection;
import livraria.collection.clientes.ListaClientes;
import livraria.collection.livros.LivroCollection;
import livraria.collection.livros.ListaLivros;
import livraria.exceptions.ClienteJaExisteException;
import livraria.exceptions.ClienteNaoExisteException;
import livraria.exceptions.LivroNaoExisteException;
import livraria.models.cliente.Cliente;
import livraria.models.livros.*;
import livraria.models.livros.generos.*;
import livraria.models.livros.Status;

public class LivrariaApp {

    public static void main(String[] args) {
        // Criando os gerenciadores de clientes e livros, responsáveis por controlar as funcionalidades
        ListaClientes managerClientes = new ListaClientes(); // Gerencia a lista de clientes e suas operações
        ListaLivros managerLivros = new ListaLivros(); // Gerencia a lista de livros e suas operações

        // Criando livros de diferentes tipos para demonstrar a funcionalidade
        LivroFiccao cosmos = new LivroFiccao("Cosmos", "123", "Livro sobre o universo", NaoFiccao.CIENCIA, "Carl Sagan");
        LivroHq homemAranha = new LivroHq("Homem Aranha", "124", "História do herói", Hq.SUPER_HEROIS, "Marvel");

        // Criando um cliente para testar as funcionalidades
        Cliente c1 = new Cliente("Cliente 1", "123", "Rua Belo");

        try {
            // 1. Cadastrando o cliente
            managerClientes.cadastrarCliente(c1);
            // Verificando se o cliente foi cadastrado corretamente (não será lançado erro de exceção)

            // 2. Cadastrando livros na biblioteca
            managerLivros.cadastrarLivro(cosmos);
            managerLivros.cadastrarLivro(homemAranha);
            // Verificando se os livros foram cadastrados corretamente na biblioteca

            // 3. Alugando um livro para o cliente
            managerLivros.alugarLivro(managerClientes, "123", "123"); // Cliente "123" aluga o livro com código "123" (Cosmos)
            // Neste ponto, o livro "Cosmos" deve ser removido da lista de disponíveis e adicionado aos livros alugados do cliente

            // 4. Verificando se o cliente possui multa
            System.out.println("Multa do cliente antes da devolução: " + c1.gerarMulta());
            // A multa será calculada, mas provavelmente será 0, pois o cliente ainda não devolveu o livro

            // 5. Listando os livros alugados pelo cliente
            System.out.println("Livros alugados pelo cliente:");
            for (Livro livro : managerClientes.getCliente("123").getLivrosAlugados()) {
                System.out.println(livro.toString()); // Deverá listar o livro "Cosmos"
            }

            // 6. Devolvendo um livro (no caso, o "Cosmos")
            managerLivros.devolucao(managerClientes, "123", "123"); // O livro "Cosmos" é devolvido
            // Após a devolução, o livro deve ser movido para a lista de disponíveis novamente

            // Exibindo a separação entre as etapas
            System.out.println("------------------------------");

            // 7. Listando todos os livros disponíveis após a devolução
            System.out.println("Livros disponíveis na biblioteca:");
            for (Livro livro : managerLivros.listarLivrosDisponiveis()) {
                System.out.println(livro.toString()); // Deverá listar "Cosmos" (devolvido) e outros livros disponíveis
            }

            // Tratando as exceções para garantir que os erros sejam tratados corretamente:
        } catch (ClienteJaExisteException e) {
            // Exibindo mensagem de erro caso o cliente já exista
            System.out.println("Erro: Cliente já cadastrado - " + e);
        } catch (LivroNaoExisteException e){
            // Exibindo mensagem de erro caso o livro não exista
            System.out.println("Erro: Livro não encontrado - " + e);
        } catch (ClienteNaoExisteException e){
            // Exibindo mensagem de erro caso o cliente não exista
            System.out.println("Erro: Cliente não encontrado - " + e);
        }
    }
}
