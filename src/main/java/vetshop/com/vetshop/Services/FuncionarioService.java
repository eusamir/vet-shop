package vetshop.com.vetshop.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vetshop.com.vetshop.DTO.FuncionarioDto;
import vetshop.com.vetshop.Entities.Funcionario;
import vetshop.com.vetshop.Repositories.IFuncionarioRepository;

import java.util.List;
import java.util.UUID;

@Service
public class FuncionarioService {

    @Autowired
    IFuncionarioRepository funcionarioRepository;

    public List<FuncionarioDto> findAll(){
        List<Funcionario> resultList = funcionarioRepository.findAll();
        return resultList.stream().map(FuncionarioDto::new).toList();
    }

    public FuncionarioDto findById(UUID id){
        Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow();
        return new FuncionarioDto(funcionario);
    }

    public FuncionarioDto create(FuncionarioDto funcionarioDto){
        Funcionario funcionario = new Funcionario(funcionarioDto);
        return new FuncionarioDto(funcionarioRepository.save(funcionario));
    }

    public  FuncionarioDto update(FuncionarioDto funcionarioDto ){
        Funcionario funcionario = funcionarioRepository.findById(funcionarioDto.getId()).orElseThrow();
        funcionario.setBairro(funcionarioDto.getBairro());
        funcionario.setTel1(funcionarioDto.getTel1());
        funcionario.setNome(funcionarioDto.getNome());
        funcionario.setCpf(funcionarioDto.getCpf());
        funcionario.setRua(funcionarioDto.getRua());
        funcionario.setNumeroCasa(funcionarioDto.getNumeroCasa());
        funcionario.setTel2(funcionarioDto.getTel2());
        funcionario.setLogradouro(funcionarioDto.getLogradouro());
        funcionario.setCep(funcionarioDto.getCep());
        return new FuncionarioDto(funcionarioRepository.save(funcionario));
    }

    public void delete(UUID id){
        Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow();
        funcionarioRepository.delete(funcionario);
    }
}
