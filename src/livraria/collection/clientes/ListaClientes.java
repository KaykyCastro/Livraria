package livraria.collection.clientes;

import livraria.exceptions.ClienteJaExisteException;
import livraria.exceptions.ClienteNaoExisteException;
import livraria.models.cliente.Cliente;

import java.util.List;
import java.util.ArrayList;

public class ListaClientes implements ClienteCollection{

    public List<Cliente> clientes = new ArrayList<Cliente>();

    @Override
    public void cadastrarCliente(Cliente cliente)throws ClienteJaExisteException {
        try {
            getCliente(cliente.getCpf());
            throw new ClienteJaExisteException(cliente.getCpf());
        } catch (ClienteNaoExisteException e){
            clientes.add(cliente);
        }
    }

    @Override
    public Cliente getCliente(String cpf) throws ClienteNaoExisteException {
        for(Cliente cliente: clientes){
            if(cliente.getCpf().equals(cpf)){
                return cliente;
            }
        }
        throw new ClienteNaoExisteException(cpf);
    }

    @Override
    public void editarCliente(String cpf, String nome, String endereco) throws ClienteNaoExisteException {
        Cliente clienteParaEditar = getCliente(cpf);
        clienteParaEditar.setNome(nome);
        clienteParaEditar.setEndereco(endereco);
    }

    @Override
    public void removerCliente(String cpf) throws ClienteNaoExisteException {
        Cliente clienteDeletar = getCliente(cpf);
        clientes.remove(clienteDeletar);
    }

    @Override
    public List<Cliente> listarClientes() {
        return clientes;
    }
}
