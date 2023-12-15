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
}
