package vetshop.com.vetshop.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vetshop.com.vetshop.DTO.TratamentoConsultaDto;
import vetshop.com.vetshop.Entities.TratamentoConsulta;
import vetshop.com.vetshop.Repositories.ITratamentoConsultaRepository;

import java.util.List;
import java.util.UUID;

@Service
public class TratamentoConsultaService {
    @Autowired
    ITratamentoConsultaRepository tratamentoConsultaRepository;

    public Page<TratamentoConsultaDto> findAll(Pageable page){
        Page<TratamentoConsulta> resultList = tratamentoConsultaRepository.findAll(page);
        return resultList.map(TratamentoConsultaDto::new);
    }

    public TratamentoConsultaDto findById(UUID id){
        TratamentoConsulta tratamentoConsulta = tratamentoConsultaRepository.findById(id).orElseThrow();
        return new TratamentoConsultaDto(tratamentoConsulta);
    }

    public TratamentoConsultaDto create(TratamentoConsultaDto tratamentoConsultaDto){
        TratamentoConsulta tratamentoConsulta = new TratamentoConsulta(tratamentoConsultaDto);
        return new TratamentoConsultaDto(tratamentoConsultaRepository.save(tratamentoConsulta));
    }

    public TratamentoConsultaDto update(TratamentoConsultaDto tratamentoConsultaDto){
        TratamentoConsulta tratamentoConsulta = tratamentoConsultaRepository.findById(tratamentoConsultaDto.getId()).orElseThrow();
        tratamentoConsulta.setConsulta(tratamentoConsultaDto.getConsulta());
        tratamentoConsulta.setServicoTratamento(tratamentoConsultaDto.getServico());
        tratamentoConsulta.setFeito(tratamentoConsultaDto.getFeito());
        return new TratamentoConsultaDto(tratamentoConsultaRepository.save(tratamentoConsulta));
    }

    public void delete(UUID id){
        TratamentoConsulta tratamentoConsulta = tratamentoConsultaRepository.findById(id).orElseThrow();
        tratamentoConsultaRepository.delete(tratamentoConsulta);
    }

}
