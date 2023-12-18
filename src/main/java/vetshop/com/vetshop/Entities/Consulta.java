package vetshop.com.vetshop.Entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vetshop.com.vetshop.DTO.ConsultaDto;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CONSULTA")
public class Consulta{
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "ID")
    private UUID id;

    @Column(name = "DATA_HORA_INICIO", nullable = false)
    private Date dataHoraInicio;

    @Column(name = "DATA_RETORNO", nullable = true)
    private Date dataRetorno;

    @Column(name = "HISTORICO_RELATADO", nullable = false)
    private String historicoRelatado;

    @ManyToOne
    @JoinColumn(name = "ID_MEDICO_FK", referencedColumnName = "ID", nullable = false)
    private MedicoVeterinario medico;

    @ManyToOne
    @JoinColumn(name = "ID_SERVICO_FK", referencedColumnName = "ID", nullable = false)
    private Servico servico;

    public Consulta(ConsultaDto consultaDto){
        this.id = consultaDto.getId();
        this.dataHoraInicio = consultaDto.getDataHoraInicio();
        this.dataRetorno = consultaDto.getDataRetorno();
        this.medico = consultaDto.getMedico();
        this.servico = consultaDto.getServico();
        this.historicoRelatado = consultaDto.getHistoricoRelatado();
    }
}