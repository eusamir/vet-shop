package vetshop.com.vetshop.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vetshop.com.vetshop.Entities.Tipo;
import vetshop.com.vetshop.Repositories.ITipoRepository;

@RestController
@RequestMapping("/tipo")
public class TipoController {

    @Autowired
    private ITipoRepository tipoRepository;

    @GetMapping("/")
    public ResponseEntity list(HttpServletRequest request){
        return ResponseEntity.ok().body(this.tipoRepository.findAll());
    }

    @PostMapping("/create")
    public  ResponseEntity create(@RequestBody Tipo tipo){
        return ResponseEntity.ok().body(this.tipoRepository.save(tipo));
    }
}
