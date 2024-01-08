package vetshop.com.vetshop.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vetshop.com.vetshop.DTO.ExameDto;
import vetshop.com.vetshop.Services.ExameService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/exame")
public class ExameController {

    @Autowired
    ExameService exameService;

    @GetMapping("/")
    public List<ExameDto> findAll(){
        List<ExameDto> resultList = exameService.findAll();
        return  resultList;
    }

    @GetMapping("/{id}")
    public  ExameDto findById(@PathVariable UUID id){
        return  exameService.findById(id);
    }

    @PostMapping("/create")
    public  ExameDto create(@RequestBody ExameDto exameDto){
        return  exameService.create(exameDto);
    }

    @PutMapping("/update")
    public  ExameDto update(@RequestBody ExameDto exameDto){
        return  exameService.update(exameDto);
    }

    @GetMapping("/delete/{id}")
    public  void delete(@PathVariable UUID id){
        exameService.delete(id);
    }

}
