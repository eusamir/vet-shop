package vetshop.com.vetshop.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vetshop.com.vetshop.DTO.ServicoDto;
import vetshop.com.vetshop.Entities.Servico;
import vetshop.com.vetshop.Repositories.IServicoRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ServicoService {

    @Autowired
    IServicoRepository servicoRepository;

    public List<ServicoDto> findAll(){
        List<Servico> resultList = servicoRepository.findAll();
        return resultList.stream().map(ServicoDto::new).toList();
    }

    public ServicoDto findById(UUID id){
         Servico servico = servicoRepository.findById(id).orElseThrow();
         return  new ServicoDto(servico);
    }

    public  ServicoDto create(ServicoDto servicoDto){
        Servico servico = new Servico(servicoDto);
        return new ServicoDto(servicoRepository.save(servico));
    }

    public  ServicoDto update(ServicoDto servicoDto){
        Servico servico = servicoRepository.findById(servicoDto.getId()).orElseThrow();
        servico.setDescricao(servicoDto.getDescricao());
        servico.setNome(servicoDto.getNome());
        servico.setValorTratamento(servicoDto.getValorTratamento());
        servico.setAtendente(servicoDto.getFuncionarioAtendente());
        servico.setAnimal(servicoDto.getAnimal());
        return new ServicoDto(servicoRepository.save(servico));
    }

    public void delete(UUID id){
        Servico servico = servicoRepository.findById(id).orElseThrow();
        servicoRepository.delete(servico);
    }
}
