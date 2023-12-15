package vetshop.com.vetshop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vetshop.com.vetshop.Entities.Raca;

import java.util.UUID;

public interface IRacaRepository extends JpaRepository<Raca, UUID> {
}
