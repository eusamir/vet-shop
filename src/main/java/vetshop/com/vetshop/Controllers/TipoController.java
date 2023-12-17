package vetshop.com.vetshop.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vetshop.com.vetshop.DTO.AnimalDto;
import vetshop.com.vetshop.DTO.TipoDto;
import vetshop.com.vetshop.Repositories.ITipoRepository;
import vetshop.com.vetshop.Services.TipoService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tipo")
public class TipoController {
    @Autowired
    private TipoService tipoService;

    @GetMapping("/")
    public List<TipoDto> findAll(){
        List<TipoDto> result = tipoService.findAll();
        return result;
    }

    @GetMapping("/{id}")
    public TipoDto findById(@PathVariable UUID id){
        return tipoService.findById(id);
    }

    @PostMapping("/create")
    public TipoDto create(@RequestBody TipoDto tipoDto){
        return tipoService.create(tipoDto);
    }

    @PutMapping("/update")
    public TipoDto update(@RequestBody TipoDto tipoDto){
        return tipoService.update(tipoDto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable UUID id){
        tipoService.delete(id);
    }
}
