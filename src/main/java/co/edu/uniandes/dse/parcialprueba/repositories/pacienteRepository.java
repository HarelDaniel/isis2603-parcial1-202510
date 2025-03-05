package co.edu.uniandes.dse.parcialprueba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uniandes.dse.parcialprueba.entities.PacienteEntity;

@Repository
public class pacienteRepository {
    public interface pacienteRepository extends JpaRepository<PacienteEntity, Long> {

    }
}
