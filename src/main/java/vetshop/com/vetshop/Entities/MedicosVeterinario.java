package vetshop.com.vetshop.Entities;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MEDICOVETERINARIO")
public class MedicosVeterinario extends Funcionario{
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "ID")
    private UUID id;

    @Column(name = "CRMV", nullable = true)
    private long crmv;

    @Column(name = "ESPECIALIDADE", nullable = true)
    private String especialidade;

    @OneToOne
    @JoinColumn(name = "ID_FUNCIONARIO_FK", referencedColumnName = "ID", nullable = true)
    private Funcionario funcionario;
}
