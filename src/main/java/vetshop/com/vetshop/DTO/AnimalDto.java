package vetshop.com.vetshop.DTO;

import lombok.Getter;
import lombok.Setter;
import vetshop.com.vetshop.Entities.Animal;
import vetshop.com.vetshop.Entities.Cliente;
import vetshop.com.vetshop.Entities.Raca;
import vetshop.com.vetshop.Entities.Tipo;

import java.util.UUID;

@Getter
@Setter
public class AnimalDto {
    private UUID id;
    private String nome;
    private String dataNascimento;
    private Cliente dono;
    private Raca raca;

    private Tipo tipo;

    public AnimalDto(){}
    public AnimalDto(Animal animal){
        this.id = animal.getId();
        this.nome= animal.getNome();
        this.dataNascimento = animal.getDataNascimento();
        this.dono = animal.getDono();
        this.raca = animal.getRaca();
        this.tipo = animal.getTipo();
    }
}
