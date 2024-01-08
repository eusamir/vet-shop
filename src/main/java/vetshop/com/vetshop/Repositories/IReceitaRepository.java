package vetshop.com.vetshop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vetshop.com.vetshop.Entities.Receita;

import java.util.UUID;

public interface IReceitaRepository extends JpaRepository<Receita, UUID> {
}
