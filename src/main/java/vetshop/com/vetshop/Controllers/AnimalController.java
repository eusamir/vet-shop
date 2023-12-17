package vetshop.com.vetshop.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vetshop.com.vetshop.DTO.AnimalDto;
import vetshop.com.vetshop.Services.AnimalService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/animal")
public class AnimalController {

    @Autowired
    private AnimalService animalService;


    @GetMapping("/")
    public List<AnimalDto> findAll(){
        List<AnimalDto> result = animalService.findAll();
        return  result;
    }

    @GetMapping("/{id}")
    public  AnimalDto findById(@PathVariable UUID id){
        return animalService.findById(id);
    }

    @PostMapping("/create")
    public AnimalDto create(@RequestBody AnimalDto animalDto){
        return animalService.create(animalDto);
    }

    @PutMapping("/update")
    public AnimalDto update(@RequestBody AnimalDto animalDto){
        return animalService.update(animalDto);
    }

    @DeleteMapping("/delete/{id}")
    public  void delete(@PathVariable UUID id){
        animalService.delete(id);
    }
}
