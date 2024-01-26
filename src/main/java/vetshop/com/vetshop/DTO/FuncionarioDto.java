package vetshop.com.vetshop.DTO;

import lombok.Getter;
import lombok.Setter;
import vetshop.com.vetshop.Entities.Funcionario;
import vetshop.com.vetshop.Entities.User;

import java.util.UUID;

@Getter
@Setter
public class FuncionarioDto {
    private UUID id;
    private String nome;
    private String cpf;
    private String tel1;
    private String tel2;
    private String logradouro;
    private String rua;
    private String bairro;
    private String cep;
    private int numeroCasa;

    private User user;

    public FuncionarioDto(){}

    public FuncionarioDto(Funcionario funcionario){
        this.id = funcionario.getId();
        this.cep = funcionario.getCep();
        this.cpf = funcionario.getCep();
        this.rua = funcionario.getRua();
        this.nome = funcionario.getNome();
        this.tel1 = funcionario.getTel1();
        this.tel2 = funcionario.getTel2();
        this.bairro = funcionario.getBairro();
        this.numeroCasa = funcionario.getNumeroCasa();
        this.logradouro = funcionario.getLogradouro();
        this.user = funcionario.getUser();
    }
}
