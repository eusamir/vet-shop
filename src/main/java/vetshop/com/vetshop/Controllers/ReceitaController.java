package vetshop.com.vetshop.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vetshop.com.vetshop.DTO.ReceitaDto;
import vetshop.com.vetshop.Services.ReceitaService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/receita")
public class ReceitaController {

    @Autowired
    ReceitaService receitaService;

    @GetMapping("/")
    public List<ReceitaDto> findAll(){
        List<ReceitaDto> result = receitaService.findAll();
        return  result;
    }

    @GetMapping("/{id}")
    public ReceitaDto findById(@PathVariable UUID id){
        return receitaService.findById(id);
    }

    @PostMapping("/create")
    public ReceitaDto create(@RequestBody ReceitaDto receitaDto){
        return receitaService.create(receitaDto);
    }

    @DeleteMapping("/delete")
    public void delete(@PathVariable UUID id){
        receitaService.delete(id);
    }

    @PutMapping("/update")
    public ReceitaDto update(@RequestBody ReceitaDto receitaDto){
        return receitaService.update(receitaDto);
    }
}
