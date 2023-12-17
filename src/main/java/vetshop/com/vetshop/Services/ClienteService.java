package vetshop.com.vetshop.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vetshop.com.vetshop.DTO.ClienteDto;
import vetshop.com.vetshop.Entities.Cliente;
import vetshop.com.vetshop.Repositories.IClienteRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteService {

    @Autowired
    IClienteRepository clienteRepository;

    public List<ClienteDto> findAll(){
        List<Cliente> resultList = clienteRepository.findAll();
        return resultList.stream().map(ClienteDto::new).toList();
    }

    public ClienteDto findById(UUID id){
        Cliente cliente = clienteRepository.findById(id).orElseThrow();
        return new ClienteDto(cliente);
    }

    public ClienteDto create(ClienteDto clienteDto){
        Cliente cliente = new Cliente(clienteDto);
        return new ClienteDto(clienteRepository.save(cliente));
    }

    public  ClienteDto update(ClienteDto clienteDto){
        Cliente cliente = clienteRepository.findById(clienteDto.getId()).orElseThrow();
        cliente.setCep(clienteDto.getCpf());
        cliente.setNome(clienteDto.getNome());
        cliente.setNumeroCasa(clienteDto.getNumeroCasa());
        cliente.setRua(clienteDto.getRua());
        cliente.setTel1(clienteDto.getTel1());
        cliente.setTel2(clienteDto.getTel2());
        cliente.setBairro(clienteDto.getBairro());
        cliente.setLogradouro(clienteDto.getLogradouro());
        cliente.setBairro(clienteDto.getBairro());

        return new ClienteDto(clienteRepository.save(cliente));
    }

    public void delete(UUID id){
        Cliente cliente = clienteRepository.findById(id).orElseThrow();
        clienteRepository.delete(cliente);
    }
}
