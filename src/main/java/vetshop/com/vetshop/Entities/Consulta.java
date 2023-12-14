package vetshop.com.vetshop.Entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CONSULTA")
public class Consulta {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "ID")
    private UUID id;

    @Column(name = "DATA_HORA_INICIO", nullable = true)
    private Date dataHoraInicio;

    @Column(name = "DATA_RETORNO", nullable = true)
    private Date dataRetorno;

    @Column(name = "HISTORICO_RELATADO", nullable = true)
    private String historicoRelatado;

    @ManyToOne
    @JoinColumn(name = "ID_ANIMAL_FK", referencedColumnName = "ID", nullable = true)
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "ID_FUNCIONARIO_ATENDENTE_FK", referencedColumnName = "ID", nullable = true)
    private Funcionario atendente;

    @ManyToOne
    @JoinColumn(name = "ID_MEDICO_FK", referencedColumnName = "ID", nullable = true)
    private MedicosVeterinario medico;
}
