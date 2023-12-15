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
@Table(name = "RECEITA")
public class Receita {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "ID")
    private UUID id;

    @Column(name = "PRESCRICAO", nullable = false)
    private String prescricao;

    @ManyToOne
    @JoinColumn(name = "ID_CONSULTA_FK", referencedColumnName = "ID", nullable = false)
    private Consulta consulta;
}
