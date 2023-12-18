package vetshop.com.vetshop.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vetshop.com.vetshop.DTO.ServicoDto;
import vetshop.com.vetshop.Entities.Servico;
import vetshop.com.vetshop.Services.ServicoService;

import java.util.List;
import java.util.UUID;

@RequestMapping("/servico")
@RestController
public class ServicoController {

    @Autowired
    ServicoService servicoService;

    @GetMapping("/")
    public List<ServicoDto> findAll(){
        List<ServicoDto> resultList = servicoService.findAll();
        return  resultList;
    }

    @GetMapping("/{id}")
    public ServicoDto findById(@PathVariable UUID id){
        return servicoService.findById(id);
    }

    @PostMapping("/create")
    public  ServicoDto create(@RequestBody ServicoDto servicoDto){
        return  servicoService.create(servicoDto);
    }

    @PutMapping("/update")
    public  ServicoDto update(@RequestBody ServicoDto servicoDto){
        return servicoService.update(servicoDto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable UUID id){
        servicoService.delete(id);
    }
}
