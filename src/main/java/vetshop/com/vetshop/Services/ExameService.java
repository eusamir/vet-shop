package vetshop.com.vetshop.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vetshop.com.vetshop.DTO.ExameDto;
import vetshop.com.vetshop.Entities.Exame;
import vetshop.com.vetshop.Repositories.IExameRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ExameService {

    @Autowired
    IExameRepository exameRepository;


    public List<ExameDto> findAll(){
        List<Exame> resultList = exameRepository.findAll();
        return resultList.stream().map(ExameDto::new).toList();
    }

    public  ExameDto findById(UUID id){
        Exame exame = exameRepository.findById(id).orElseThrow();
        return new ExameDto(exame);
    }

    public  ExameDto create(ExameDto exameDto){
        Exame exame = new Exame(exameDto);
        return new ExameDto(exameRepository.save(exame));
    }

    public ExameDto update(ExameDto exameDto){
        Exame exame = exameRepository.findById(exameDto.getId()).orElseThrow();

        exame.setConsulta(exameDto.getConsulta());
        exame.setNome(exameDto.getNome());
        exame.setConsulta(exameDto.getConsulta());

        return new ExameDto(exameRepository.save(exame));
    }

    public void delete(UUID id){
        Exame exame = exameRepository.findById(id).orElseThrow();
        exameRepository.delete(exame);
    }

}
