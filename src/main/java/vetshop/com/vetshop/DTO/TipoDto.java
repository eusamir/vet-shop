package vetshop.com.vetshop.DTO;

import lombok.Getter;
import lombok.Setter;
import vetshop.com.vetshop.Entities.Tipo;

import java.util.UUID;
@Getter
@Setter
public class TipoDto {
    private UUID id;

    private String nome;

    public TipoDto(){}

    public TipoDto(Tipo tipo){
        this.id = tipo.getId();
        this.nome = tipo.getNome();
    }
}
