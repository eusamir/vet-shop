import jakarta.persistence.*;

@Entity
@Table(name = "RACA")
public class Raca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    
}