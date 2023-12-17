package vetshop.com.vetshop.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vetshop.com.vetshop.DTO.ClienteDto;
import vetshop.com.vetshop.DTO.RacaDto;
import vetshop.com.vetshop.Entities.Raca;
import vetshop.com.vetshop.Entities.Tipo;
import vetshop.com.vetshop.Repositories.IRacaRepository;
import vetshop.com.vetshop.Repositories.ITipoRepository;
import vetshop.com.vetshop.Services.ClienteService;
import vetshop.com.vetshop.Services.RacaService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/raca")
public class RacaController {
    @Autowired
    private RacaService racaService;

    @GetMapping("/")
    public List<RacaDto> findAll(){
        List<RacaDto> result = racaService.findAll();
        return result;
    }

    @GetMapping("/{id}")
    public RacaDto findById(@PathVariable UUID id){
        return racaService.findById(id);
    }

    @PostMapping("/create")
    public RacaDto create(@RequestBody RacaDto racaDto){
        return  racaService.create(racaDto);
    }

    @PutMapping("/update")
    public RacaDto update(@RequestBody RacaDto racaDto){
        return racaService.update(racaDto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable UUID id){
        racaService.delete(id);
    }
}