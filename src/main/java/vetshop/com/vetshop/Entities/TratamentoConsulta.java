package vetshop.com.vetshop.Entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vetshop.com.vetshop.DTO.TratamentoConsultaDto;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TRATAMENTOCONSULTA")
public class TratamentoConsulta{
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "ID")
    private UUID id;

    @Column(name = "DATA_INICIO",nullable = true)
    private Date dataInicio;

    @Column(name = "FEITO",nullable = true)
    private Boolean feito;

    @ManyToOne
    @JoinColumn(name = "ID_CONSULTA_FK",referencedColumnName = "ID",nullable = false)
    private Consulta consulta;

    @ManyToOne
    @JoinColumn(name = "ID_SERVICO_FK",referencedColumnName = "ID",nullable = false)
    private Servico servicoTratamento;

    public TratamentoConsulta(TratamentoConsultaDto tratamentoConsultaDto){
        this.id = tratamentoConsultaDto.getId();
        this.consulta = tratamentoConsultaDto.getConsulta();
        this.servicoTratamento = tratamentoConsultaDto.getServico();
        this.feito = tratamentoConsultaDto.getFeito();
        this.dataInicio = tratamentoConsultaDto.getDate();
    }
}
