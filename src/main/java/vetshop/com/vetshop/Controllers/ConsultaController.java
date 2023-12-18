package vetshop.com.vetshop.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vetshop.com.vetshop.DTO.ConsultaDto;
import vetshop.com.vetshop.Services.ConsultaService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    ConsultaService consultaService;

    @GetMapping("/")
    public List<ConsultaDto> findAll(){
        List<ConsultaDto> resultList = consultaService.findAll();
        return resultList;
    }

    @GetMapping("/{id}")
    public  ConsultaDto findById(@PathVariable UUID id){
        return consultaService.findById(id);
    }

    @PostMapping("/create")
    public  ConsultaDto create(@RequestBody ConsultaDto consultaDto){
        return  consultaService.create(consultaDto);
    }

    @PutMapping("/update")
    public  ConsultaDto update(@RequestBody ConsultaDto consultaDto){
        return consultaService.update(consultaDto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable UUID id){
        consultaService.delete(id);
    }
}
