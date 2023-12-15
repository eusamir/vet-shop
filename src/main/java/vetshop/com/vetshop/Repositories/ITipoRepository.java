package vetshop.com.vetshop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vetshop.com.vetshop.Entities.Tipo;

import java.util.UUID;

public interface ITipoRepository extends JpaRepository <Tipo, UUID> {
}
