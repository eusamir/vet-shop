package vetshop.com.vetshop.Controllers;


import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vetshop.com.vetshop.Entities.Cliente;
import vetshop.com.vetshop.Repositories.IClienteRepository;

import java.util.UUID;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    private IClienteRepository clienteRepository;

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody Cliente cliente){

        var teste =clienteRepository.save(cliente);

        return ResponseEntity.ok().body(teste);
    }

    @GetMapping("/")
    public  ResponseEntity list(HttpServletRequest request){
        return ResponseEntity.ok().body(this.clienteRepository.findAll());
    }
    @GetMapping("/{id}")
    public  ResponseEntity getById(@PathVariable UUID id){
        var userByid = this.clienteRepository.findById(id);
        return ResponseEntity.ok().body(userByid);
    }
}
