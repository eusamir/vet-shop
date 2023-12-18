package vetshop.com.vetshop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vetshop.com.vetshop.Entities.MedicoVeterinario;

import java.util.UUID;

public interface IMedicoVeterinarioRepository extends JpaRepository<MedicoVeterinario, UUID> {
}
