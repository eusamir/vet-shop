package vetshop.com.vetshop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vetshop.com.vetshop.Entities.Servico;

import java.util.UUID;

public interface IServicoRepository extends JpaRepository<Servico, UUID> {
}
