package vetshop.com.vetshop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vetshop.com.vetshop.Entities.Consulta;

import java.util.UUID;

public interface IConsultaRepository extends JpaRepository<Consulta, UUID> {
}
