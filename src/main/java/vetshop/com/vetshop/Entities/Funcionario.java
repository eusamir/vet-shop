package vetshop.com.vetshop.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

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
}
