package vetshop.com.vetshop.Entities;

import jakarta.persistence.*;

public class MedicosVeterinario extends Funcionario{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "CRMV", nullable = false)
    private long crmv;

    @Column(name = "ESPECIALIDADE", nullable = false)
    private String especialidade;

    @OneToOne
    @JoinColumn(name = "ID_FUNCIONARIO_FK", referencedColumnName = "ID")
    private Funcionario funcionario;
}
