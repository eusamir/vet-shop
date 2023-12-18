package vetshop.com.vetshop.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vetshop.com.vetshop.DTO.FuncionarioDto;
import vetshop.com.vetshop.DTO.MedicoVeterinarioDto;
import vetshop.com.vetshop.Entities.MedicoVeterinario;
import vetshop.com.vetshop.Services.MedicoVeterinarioService;

import java.util.List;
import java.util.UUID;

@RequestMapping("/medicoVeterinario")
@RestController
public class MedicoVeterinarioController {
    @Autowired
    MedicoVeterinarioService medicoVeterinarioService;

    @GetMapping("/")
    public List<MedicoVeterinarioDto> findAll(){
        List<MedicoVeterinarioDto> resultList = medicoVeterinarioService.findAll();
        return resultList;
    }

    @GetMapping("/{id}")
    public  MedicoVeterinarioDto findById(@PathVariable UUID  id){
        return medicoVeterinarioService.findById(id);
    }

    @PostMapping("/create")
    public  MedicoVeterinarioDto create(@RequestBody MedicoVeterinarioDto medicoVeterinarioDto){
        return medicoVeterinarioService.create(medicoVeterinarioDto);
    }
}
