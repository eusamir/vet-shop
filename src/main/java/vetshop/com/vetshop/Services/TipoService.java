package vetshop.com.vetshop.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import vetshop.com.vetshop.DTO.TipoDto;
import vetshop.com.vetshop.Entities.Tipo;
import vetshop.com.vetshop.Repositories.ITipoRepository;

import java.util.List;
import java.util.UUID;

@Service
public class TipoService {

    @Autowired
    ITipoRepository tipoRepository;

    public List<TipoDto> findAll(){
        List<Tipo> resultList =  tipoRepository.findAll();
        return resultList.stream().map(TipoDto::new).toList();
    }

    public TipoDto findById(UUID id){
        Tipo tipo = tipoRepository.findById(id).orElseThrow();
        return new TipoDto(tipo);
    }

    public TipoDto create (TipoDto tipoDto){
        Tipo tipo = new Tipo(tipoDto);
        return new TipoDto(tipoRepository.save(tipo));
    }

    public  TipoDto update(TipoDto tipoDto){
        Tipo tipo = tipoRepository.findById(tipoDto.getId()).orElseThrow();
        tipo.setNome(tipoDto.getNome());
        return new TipoDto(tipoRepository.save(tipo));
    }

    public void delete(UUID id){
        Tipo tipo = tipoRepository.findById(id).orElseThrow();
        tipoRepository.delete(tipo);
    }
}
