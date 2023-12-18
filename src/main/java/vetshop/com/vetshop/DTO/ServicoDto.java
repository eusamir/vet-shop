package vetshop.com.vetshop.DTO;

import lombok.Getter;
import lombok.Setter;
import vetshop.com.vetshop.Entities.Animal;
import vetshop.com.vetshop.Entities.Funcionario;
import vetshop.com.vetshop.Entities.Servico;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class ServicoDto {
    private UUID id;

    private String nome;

    private BigDecimal valorTratamento;

    private String descricao;

    private Animal animal;

    private Funcionario atendente;

    private Boolean isConsulta;
    public ServicoDto(){}

    public ServicoDto(Servico servico){
        this.id = servico.getId();
        this.nome = servico.getNome();
        this.valorTratamento = servico.getValorTratamento();
        this.descricao = servico.getDescricao();
        this.animal = servico.getAnimal();
        this.atendente = servico.getAtendente();
        this.isConsulta = servico.getIsConsulta();
    }
}
