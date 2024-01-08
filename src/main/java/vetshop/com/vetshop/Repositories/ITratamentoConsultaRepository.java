package vetshop.com.vetshop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vetshop.com.vetshop.Entities.TratamentoConsulta;

import java.util.UUID;

public interface ITratamentoConsultaRepository extends JpaRepository<TratamentoConsulta, UUID> {
}
