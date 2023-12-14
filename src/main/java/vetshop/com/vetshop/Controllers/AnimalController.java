package vetshop.com.vetshop.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vetshop.com.vetshop.Repositories.IAnimalRepository;

@RestController
@RequestMapping(value = "/animal")
public class AnimalController {

    @Autowired
    private IAnimalRepository animalRepository;


    @GetMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity list(HttpServletRequest request){
        return ResponseEntity.ok().body(this.animalRepository.findAll());
    }
}
