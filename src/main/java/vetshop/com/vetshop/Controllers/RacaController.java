package vetshop.com.vetshop.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vetshop.com.vetshop.DTO.ClienteDto;
import vetshop.com.vetshop.Entities.Raca;
import vetshop.com.vetshop.Entities.Tipo;
import vetshop.com.vetshop.Repositories.IRacaRepository;
import vetshop.com.vetshop.Repositories.ITipoRepository;
import vetshop.com.vetshop.Services.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/raca")
public class RacaController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/")
    public List<ClienteDto> findAll(){
        List<ClienteDto> result = clienteService.findAll();
        return result;
    }

    @PostMapping("/create")
    public  String create(@RequestBody Raca raca){
        return "";
    }
}
