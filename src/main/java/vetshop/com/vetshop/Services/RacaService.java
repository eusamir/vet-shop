package vetshop.com.vetshop.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vetshop.com.vetshop.DTO.RacaDto;
import vetshop.com.vetshop.Entities.Raca;
import vetshop.com.vetshop.Repositories.IRacaRepository;

import java.util.List;
import java.util.UUID;

@Service
public class RacaService {


    @Autowired
    IRacaRepository racaRepository;

    public List<RacaDto> findAll(){
        List<Raca> resultList = racaRepository.findAll();
        return resultList.stream().map(RacaDto::new).toList();
    }

    public  RacaDto findById(UUID id){
        Raca raca = racaRepository.findById(id).orElseThrow();
        return new RacaDto(raca);
    }

    public  RacaDto create (RacaDto racaDto){
        Raca raca = new Raca(racaDto);
        return  new RacaDto(racaRepository.save(raca));
    }

    public RacaDto update(RacaDto racaDto){
        Raca raca = racaRepository.findById(racaDto.getId()).orElseThrow();
        raca.setNome(raca.getNome());
        return new RacaDto(racaRepository.save(raca));
    }

    public  void delete(UUID id){
        Raca raca = racaRepository.findById(id).orElseThrow();
        racaRepository.delete(raca);
    }
}
