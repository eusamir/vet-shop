package vetshop.com.vetshop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vetshop.com.vetshop.Entities.Exame;

import java.util.UUID;

public interface IExameRepository extends JpaRepository<Exame, UUID> {
}
