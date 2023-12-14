package vetshop.com.vetshop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vetshop.com.vetshop.Entities.Animal;

import java.util.UUID;

public interface IAnimalRepository extends JpaRepository<Animal,UUID> {
}
