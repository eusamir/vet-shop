package vetshop.com.vetshop.DTO;

import lombok.Getter;
import lombok.Setter;
import vetshop.com.vetshop.Entities.Cliente;

import java.util.UUID;

@Getter
@Setter
public class ClienteDto {
    private UUID id;
    private String nome;
    private String cpf;
    private String tel1;
    private String tel2;
    private String rua;
    private String logradouro;
    private String bairro;
    private int numeroCasa;
    private String cep;

    public ClienteDto(){}
    public ClienteDto(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.tel1 = cliente.getTel1();
        this.tel2 = cliente.getTel2();
        this.rua = cliente.getRua();
        this.logradouro = cliente.getLogradouro();
        this.bairro = cliente.getBairro();
        this.numeroCasa = cliente.getNumeroCasa();
        this.cep = cliente.getCep();
    }
}