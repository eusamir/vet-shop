package vetshop.com.vetshop.DTO;

import lombok.Getter;
import lombok.Setter;
import vetshop.com.vetshop.Entities.Consulta;
import vetshop.com.vetshop.Entities.Servico;
import vetshop.com.vetshop.Entities.TratamentoConsulta;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class TratamentoConsultaDto {
    private UUID id;

    private Date date;

    private Boolean feito;

    private Consulta consulta;

    private Servico servico;

    public TratamentoConsultaDto(){}

    public TratamentoConsultaDto(TratamentoConsulta tratamentoConsulta){
        this.id = tratamentoConsulta.getId();
        this.consulta = tratamentoConsulta.getConsulta();
        this.date = tratamentoConsulta.getDataInicio();
        this.servico = tratamentoConsulta.getServicoTratamento();
        this.feito = tratamentoConsulta.getFeito();
    }
}
