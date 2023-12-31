package vetshop.com.vetshop.Entities;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vetshop.com.vetshop.DTO.ExameDto;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EXAME")
public class Exame{
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "ID")
    private UUID id;

    @Column(name = "NOME",nullable = false)
    private String nome;

    @Column(name = "RESULTADO",nullable = false)
    private String resultado;

    @ManyToOne
    @JoinColumn(name = "ID_CONSULTA_FK", referencedColumnName = "ID", nullable = false)
    private Consulta consulta;

    public Exame(ExameDto exameDto){
        this.id = exameDto.getId();
        this.nome = exameDto.getNome();
        this.consulta = exameDto.getConsulta();
        this.resultado = exameDto.getResultado();
    }
}
