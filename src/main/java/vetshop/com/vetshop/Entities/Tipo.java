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
@Table(name = "TIPO")
public class Tipo {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "ID")
    private UUID id;

    @Column(name = "NOME", nullable = true)
    private String nome;
}
