package vetshop.com.vetshop.Controllers;


import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vetshop.com.vetshop.DTO.ClienteDto;
import vetshop.com.vetshop.Entities.Cliente;
import vetshop.com.vetshop.Repositories.IClienteRepository;
import vetshop.com.vetshop.Services.ClienteService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/")
    public List<ClienteDto> findAll(){
        List<ClienteDto> result = clienteService.findAll();
        return result;
    }

    @GetMapping("/{id}")
    public  ClienteDto findById(@PathVariable UUID id){
        return clienteService.findById(id);
    }
    @PostMapping("/create")
    public ClienteDto create(@RequestBody ClienteDto clienteDto){
        return clienteService.create(clienteDto);
    }

    @PutMapping("/update")
    public  ClienteDto update(@RequestBody ClienteDto clienteDto){
        return clienteService.update(clienteDto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable UUID id){
        clienteService.delete(id);
    }

}
