package vetshop.com.vetshop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vetshop.com.vetshop.Entities.Funcionario;

import java.util.UUID;

public interface IFuncionarioRepository extends JpaRepository<Funcionario,UUID> {
}
