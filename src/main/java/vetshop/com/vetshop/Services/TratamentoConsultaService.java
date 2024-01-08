package vetshop.com.vetshop.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vetshop.com.vetshop.DTO.TratamentoConsultaDto;
import vetshop.com.vetshop.Entities.TratamentoConsulta;
import vetshop.com.vetshop.Repositories.ITratamentoConsultaRepository;

import java.util.List;

@Service
public class TratamentoConsultaService {
    @Autowired
    ITratamentoConsultaRepository tratamentoConsultaRepository;

    public List<TratamentoConsultaDto> findAll(){
        List<TratamentoConsulta> resultList = tratamentoConsultaRepository.findAll();
        return resultList.stream().map(TratamentoConsultaDto::new).toList();
    }

}
