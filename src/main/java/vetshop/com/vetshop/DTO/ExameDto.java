package vetshop.com.vetshop.DTO;

import lombok.Getter;
import lombok.Setter;
import vetshop.com.vetshop.Entities.Consulta;
import vetshop.com.vetshop.Entities.Exame;

import java.util.UUID;


@Getter
@Setter
public class ExameDto {
    private UUID id;

    private String nome;

    private String resultado;

    private Consulta consulta;

    public ExameDto(){}

    public ExameDto(Exame exame){
        this.id = exame.getId();
        this.nome = exame.getNome();
        this.consulta = exame.getConsulta();
        this.resultado = exame.getResultado();
    }
}
