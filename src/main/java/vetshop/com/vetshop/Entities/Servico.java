package vetshop.com.vetshop.Entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
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
@Table(name = "SERVICO")
public class Servico {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "ID")
    private UUID id;

    @Column(name = "NOME",nullable = false)
    private String nome;

    @Column(name = "VALOR_TRATAMENTO",nullable = false)
    private BigDecimal valorTratamento;

    @Column(name = "DESCRICAO",nullable = false)
    private String descricao;
}
