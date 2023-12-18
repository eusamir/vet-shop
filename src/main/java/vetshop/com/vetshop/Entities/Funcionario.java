package vetshop.com.vetshop.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vetshop.com.vetshop.DTO.FuncionarioDto;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario {
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

    public Funcionario (FuncionarioDto funcionarioDto){
        this.id = funcionarioDto.getId();
        this.cep = funcionarioDto.getCep();
        this.cpf = funcionarioDto.getCpf();
        this.rua = funcionarioDto.getRua();
        this.nome = funcionarioDto.getNome();
        this.tel1 = funcionarioDto.getTel1();
        this.tel2 = funcionarioDto.getTel2();
        this.bairro = funcionarioDto.getBairro();
        this.numeroCasa = funcionarioDto.getNumeroCasa();
        this.logradouro = funcionarioDto.getLogradouro();
    }
}
