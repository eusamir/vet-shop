package vetshop.com.vetshop.DTO;

import lombok.Getter;
import lombok.Setter;
import vetshop.com.vetshop.Entities.Consulta;
import vetshop.com.vetshop.Entities.Receita;

import java.util.UUID;

@Getter
@Setter
public class ReceitaDto {
    private UUID id;

    private String prescricao;

    private Consulta consulta;

    public ReceitaDto(){}

    public ReceitaDto(Receita receita){
        this.id = receita.getId();
        this.consulta = receita.getConsulta();
        this.prescricao = receita.getPrescricao();
    }
}
