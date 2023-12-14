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
@Table(name = "CLIENTE")

public class Cliente {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "ID")
    private UUID id;

    @Column(name = "NOME",nullable = true)
    private String nome;

    @Column(name = "CPF",nullable = true)
    private String cpf;

    @Column(name = "TEL1")
    private String tel1;

    @Column(name = "TEL2")
    private String tel2;

    @Column(name = "RUA")
    private String rua;

    @Column(name = "LOGRADOURO")
    private String logradouro;

    @Column(name = "BAIRRO")
    private String bairro;

    @Column(name = "NUMERO_CASA",nullable = true)
    private int numeroCasa;


    @Column(name = "CEP",nullable = true)
    private String cep;
}
