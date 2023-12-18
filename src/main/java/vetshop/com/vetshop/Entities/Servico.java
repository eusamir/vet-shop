package vetshop.com.vetshop.Entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vetshop.com.vetshop.DTO.ServicoDto;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SERVICO")
public class Servico {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "ID")
    private UUID id;

    @Column(name = "NOME",nullable = false)
    private String nome;

    @Column(name = "VALOR_TRATAMENTO",nullable = false)
    private BigDecimal valorTratamento;

    @Column(name = "DESCRICAO",nullable = false)
    private String descricao;

    @Column(name = "CONSULTA", nullable = false)
    private Boolean isConsulta;

    @ManyToOne
    @JoinColumn(name = "ID_ANIMAL_FK", referencedColumnName = "ID", nullable = false)
    private  Animal animal;

    @ManyToOne
    @JoinColumn(name = "ID_ATENDENTE_FK", referencedColumnName = "ID", nullable = false)
    private Funcionario atendente;

    public Servico(ServicoDto servicoDto){
        this.id= servicoDto.getId();
        this.nome = servicoDto.getNome();
        this.valorTratamento = servicoDto.getValorTratamento();
        this.descricao = servicoDto.getDescricao();
        this.animal = servicoDto.getAnimal();
        this.atendente = servicoDto.getAtendente();
        this.isConsulta = servicoDto.getIsConsulta();
    }
}
