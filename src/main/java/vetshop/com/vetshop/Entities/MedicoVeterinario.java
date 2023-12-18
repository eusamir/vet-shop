package vetshop.com.vetshop.Entities;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vetshop.com.vetshop.DTO.MedicoVeterinarioDto;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MEDICOVETERINARIO")
public class MedicoVeterinario {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "ID")
    private UUID id;

    @Column(name = "CRMV", nullable = false)
    private long crmv;

    @Column(name = "ESPECIALIDADE", nullable = false)
    private String especialidade;

    @OneToOne
    @JoinColumn(name = "ID_FUNCIONARIO_FK", referencedColumnName = "ID", nullable = false)
    private Funcionario funcionario;

    public MedicoVeterinario(MedicoVeterinarioDto medicoVeterinarioDto){
        this.id = medicoVeterinarioDto.getId();
        this.crmv = medicoVeterinarioDto.getCrmv();
        this.especialidade = medicoVeterinarioDto.getEspecialidade();
        this.funcionario = medicoVeterinarioDto.getFuncionario();
    }
}
