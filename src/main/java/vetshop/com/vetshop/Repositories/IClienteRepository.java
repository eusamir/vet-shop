package vetshop.com.vetshop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vetshop.com.vetshop.Entities.Cliente;

import java.util.UUID;

public interface IClienteRepository extends JpaRepository<Cliente, UUID> {
}
