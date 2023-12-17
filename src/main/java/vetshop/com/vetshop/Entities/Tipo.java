package vetshop.com.vetshop.Entities;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vetshop.com.vetshop.DTO.TipoDto;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TIPO")
public class Tipo {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "ID")
    private UUID id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    public  Tipo(TipoDto tipoDto){
        this.id = tipoDto.getId();
        this.nome = tipoDto.getNome();
    }
}
