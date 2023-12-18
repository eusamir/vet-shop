package vetshop.com.vetshop.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vetshop.com.vetshop.DTO.ConsultaDto;
import vetshop.com.vetshop.Entities.Consulta;
import vetshop.com.vetshop.Repositories.IConsultaRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ConsultaService {

    @Autowired
    IConsultaRepository consultaRepository;

    public List<ConsultaDto> findAll() {
        List<Consulta> resultList = consultaRepository.findAll();
        return resultList.stream().map(ConsultaDto::new).toList();
    }

    public  ConsultaDto findById(UUID id){
        Consulta consulta = consultaRepository.findById(id).orElseThrow();
        return  new ConsultaDto(consulta);
    }

    public ConsultaDto create(ConsultaDto consultaDto){
        Consulta consulta = new Consulta(consultaDto);
        return new ConsultaDto(consultaRepository.save(consulta));
    }

    public ConsultaDto update(ConsultaDto consultaDto){
        Consulta consulta = consultaRepository.findById(consultaDto.getId()).orElseThrow();
        consulta.setDataHoraInicio(consultaDto.getDataHoraInicio());
        consulta.setId(consultaDto.getId());
        consulta.setMedico(consultaDto.getMedico());
        consulta.setDataRetorno(consultaDto.getDataRetorno());
        consulta.setServico(consultaDto.getServico());
        consulta.setHistoricoRelatado(consultaDto.getHistoricoRelatado());
        return  new ConsultaDto(consultaRepository.save(consulta));
    }

    public void delete(UUID id){
        Consulta consulta = consultaRepository.findById(id).orElseThrow();
        consultaRepository.delete(consulta);
    }
}
