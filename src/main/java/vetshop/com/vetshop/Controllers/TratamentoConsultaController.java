package vetshop.com.vetshop.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vetshop.com.vetshop.DTO.TratamentoConsultaDto;
import vetshop.com.vetshop.Entities.TratamentoConsulta;
import vetshop.com.vetshop.Services.TratamentoConsultaService;

import java.util.UUID;

@RestController
@RequestMapping("/tratamento-consulta")
public class TratamentoConsultaController {

    @Autowired
    TratamentoConsultaService tratamentoConsultaService;

    @GetMapping("/")
    public ResponseEntity<Page<TratamentoConsultaDto>> findAll(Pageable page){
        Page<TratamentoConsultaDto> resultList = tratamentoConsultaService.findAll(page);
        return ResponseEntity.ok().body(resultList);
    }

    @GetMapping("/{id}")
    public TratamentoConsultaDto findById(@PathVariable UUID id){
        return tratamentoConsultaService.findById(id);
    }

    @PostMapping("/create")
    public TratamentoConsultaDto create(@RequestBody TratamentoConsultaDto tratamentoConsultaDto){
        return tratamentoConsultaService.create(tratamentoConsultaDto);
    }

    @PutMapping("/update")
    public TratamentoConsultaDto update(@RequestBody TratamentoConsultaDto tratamentoConsultaDto){
        return tratamentoConsultaService.update(tratamentoConsultaDto);
    }

    @DeleteMapping("/delete")
    public void delete(@PathVariable UUID id){
        tratamentoConsultaService.delete(id);
    }
}
