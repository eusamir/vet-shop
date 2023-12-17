package vetshop.com.vetshop.DTO;

import lombok.Getter;
import lombok.Setter;
import vetshop.com.vetshop.Entities.Raca;

import java.util.UUID;

@Getter
@Setter
public class RacaDto {
    private UUID id;

    private String nome;

    public  RacaDto(){}
    public RacaDto(Raca raca){
        this.id = raca.getId();
        this.nome = raca.getNome();
    }
}
