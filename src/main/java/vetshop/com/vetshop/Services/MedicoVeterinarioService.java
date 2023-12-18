package vetshop.com.vetshop.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vetshop.com.vetshop.DTO.MedicoVeterinarioDto;
import vetshop.com.vetshop.Entities.MedicoVeterinario;
import vetshop.com.vetshop.Repositories.IMedicoVeterinarioRepository;

import java.util.List;
import java.util.UUID;

@Service
public class MedicoVeterinarioService {
    @Autowired
    IMedicoVeterinarioRepository medicoVeterinarioRepository;

    public List<MedicoVeterinarioDto> findAll(){
        List<MedicoVeterinario> resultList = medicoVeterinarioRepository.findAll();
        return resultList.stream().map(MedicoVeterinarioDto::new).toList();
    }

    public  MedicoVeterinarioDto findById(UUID id){
        MedicoVeterinario medicoVeterinario = medicoVeterinarioRepository.findById(id).orElseThrow();
        return  new MedicoVeterinarioDto(medicoVeterinarioRepository.save(medicoVeterinario));
    }

    public  MedicoVeterinarioDto create(MedicoVeterinarioDto medicoVeterinarioDto){
        MedicoVeterinario medicoVeterinario = new MedicoVeterinario(medicoVeterinarioDto);
        return new MedicoVeterinarioDto(medicoVeterinarioRepository.save(medicoVeterinario));
    }

    public MedicoVeterinarioDto update(MedicoVeterinarioDto medicoVeterinarioDto){
        MedicoVeterinario medicoVeterinario = medicoVeterinarioRepository.findById(medicoVeterinarioDto.getId()).orElseThrow();
        medicoVeterinario.setCrmv(medicoVeterinarioDto.getCrmv());
        medicoVeterinario.setFuncionario(medicoVeterinarioDto.getFuncionario());
        medicoVeterinario.setEspecialidade(medicoVeterinarioDto.getEspecialidade());
        return new MedicoVeterinarioDto(medicoVeterinarioRepository.save(medicoVeterinario));
    }

    public void delete(UUID id){
        MedicoVeterinario medicoVeterinario = medicoVeterinarioRepository.findById(id).orElseThrow();
        medicoVeterinarioRepository.delete(medicoVeterinario);
    }
}
