package vetshop.com.vetshop.DTO;

import lombok.Getter;
import lombok.Setter;
import vetshop.com.vetshop.Entities.Funcionario;
import vetshop.com.vetshop.Entities.MedicoVeterinario;

import java.util.UUID;

@Getter
@Setter
public class MedicoVeterinarioDto {
    private UUID id;
    private long crmv;
    private String especialidade;
    private Funcionario funcionario;

    public MedicoVeterinarioDto(){}

    public MedicoVeterinarioDto(MedicoVeterinario medicoVeterinario){
        this.id = medicoVeterinario.getId();
        this.crmv = medicoVeterinario.getCrmv();
        this.especialidade = medicoVeterinario.getEspecialidade();
        this.funcionario = medicoVeterinario.getFuncionario();
    }
}
