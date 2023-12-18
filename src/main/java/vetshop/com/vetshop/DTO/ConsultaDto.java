package vetshop.com.vetshop.DTO;

import lombok.Getter;
import lombok.Setter;
import vetshop.com.vetshop.Entities.Consulta;
import vetshop.com.vetshop.Entities.MedicoVeterinario;
import vetshop.com.vetshop.Entities.Servico;

import java.util.Date;
import java.util.UUID;


@Setter
@Getter
public class ConsultaDto {
    private UUID id;

    private Date dataHoraInicio;

    private Date dataRetorno;

    private String historicoRelatado;

    private MedicoVeterinario medico;

    private Servico servico;

    public ConsultaDto(){}

    public ConsultaDto(Consulta consulta){
        this.id = consulta.getId();
        this.dataRetorno = consulta.getDataRetorno();
        this.servico = consulta.getServico();
        this.medico = consulta.getMedico();
        this.historicoRelatado = consulta.getHistoricoRelatado();
        this.dataHoraInicio = consulta.getDataHoraInicio();
    }
}
