package vetshop.com.vetshop.Entities;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vetshop.com.vetshop.DTO.AnimalDto;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ANIMAL")
public class Animal{
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "ID")
    private UUID id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "DATA_NASCIMENTO", nullable = false)
    private String dataNascimento;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_FK", referencedColumnName = "ID", nullable = false)
    private Tipo tipo;

    @ManyToOne
    @JoinColumn(name = "ID_RACA_FK", referencedColumnName = "ID", nullable = false)
    private Raca raca;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE_FK", referencedColumnName ="ID", nullable = false)
    private Cliente dono;

    public Animal(AnimalDto animalDto){
        this.id= animalDto.getId();
        this.nome= animalDto.getNome();
        this.dono= animalDto.getDono();
        this.raca = animalDto.getRaca();
        this.tipo = animalDto.getTipo();
    }
}
