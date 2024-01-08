package vetshop.com.vetshop.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vetshop.com.vetshop.DTO.ReceitaDto;
import vetshop.com.vetshop.Entities.Receita;
import vetshop.com.vetshop.Repositories.IReceitaRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ReceitaService {

    @Autowired
    IReceitaRepository receitaRepository;

    public List<ReceitaDto> findAll(){
        List<Receita> resultList = receitaRepository.findAll();
        return resultList.stream().map(ReceitaDto::new).toList();
    }
    public ReceitaDto findById(UUID id){
        Receita receita = receitaRepository.findById(id).orElseThrow();
        return new ReceitaDto(receita);
    }

    public ReceitaDto create(ReceitaDto receitaDto){
        Receita receita = new Receita(receitaDto);
        return new ReceitaDto(receitaRepository.save(receita));
    }

    public ReceitaDto update(ReceitaDto receitaDto){
        Receita receita = receitaRepository.findById(receitaDto.getId()).orElseThrow();
        receita.setConsulta(receitaDto.getConsulta());
        receita.setPrescricao(receitaDto.getPrescricao());

        return  new ReceitaDto(receitaRepository.save(receita));
    }

    public void delete(UUID id){
        Receita receita = receitaRepository.findById(id).orElseThrow();
        receitaRepository.delete(receita);
    }
}
