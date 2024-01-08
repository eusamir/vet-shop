package vetshop.com.vetshop.Entities;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vetshop.com.vetshop.DTO.ClienteDto;

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

    @Column(name = "NOME",nullable = false)
    private String nome;

    @Column(name = "CPF",nullable = false)
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

    @Column(name = "NUMERO_CASA",nullable = false)
    private int numeroCasa;

    @Column(name = "CEP",nullable = false)
    private String cep;

    @OneToOne
    @JoinColumn(name = "ID_USER_FK", referencedColumnName = "ID", nullable = false)
    private User user;

    public Cliente(ClienteDto clienteDto) {
        this.id = clienteDto.getId();
        this.nome = clienteDto.getNome();
        this.cpf = clienteDto.getCpf();
        this.numeroCasa = clienteDto.getNumeroCasa();
        this.cep = clienteDto.getCep();
    }
}
