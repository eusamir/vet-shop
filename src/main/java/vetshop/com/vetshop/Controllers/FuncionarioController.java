package vetshop.com.vetshop.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vetshop.com.vetshop.DTO.FuncionarioDto;
import vetshop.com.vetshop.Entities.Funcionario;
import vetshop.com.vetshop.Services.FuncionarioService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    @Autowired
    FuncionarioService funcionarioService;

    @GetMapping("/")
    public List<FuncionarioDto> findAll(){
        List<FuncionarioDto> resultList = funcionarioService.findAll();
        return resultList;
    }

    @GetMapping("/{id}")
    public FuncionarioDto findById(@PathVariable UUID id){
        return funcionarioService.findById(id);
    }

    @PostMapping("/create")
    public FuncionarioDto create(@RequestBody FuncionarioDto funcionarioDto){
        return funcionarioService.create(funcionarioDto);
    }

    @PutMapping("/update")
    public FuncionarioDto update(@RequestBody FuncionarioDto funcionarioDto){
        return funcionarioService.update(funcionarioDto);
    }

    @DeleteMapping("/delete")
    public void delete(@PathVariable UUID id){
        funcionarioService.delete(id);
    }
}
