package co.edu.uniandes.dse.parcialprueba.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcialprueba.entities.PacienteEntity;
import co.edu.uniandes.dse.parcialprueba.repositories.pacienteRepository;

import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private pacienteRepository pacienteRepository;

    public PacienteEntity crearPaciente(PacienteEntity paciente) {
        if (!paciente.getTelefono().matches("^(311|601)\\d{8}$")) {
            throw new IllegalArgumentException("El teléfono debe ser de 11 dígitos y empezar por 311 o 601");
        }
        return pacienteRepository.save(paciente);
    }

    public PacienteEntity asociarAcudiente(Long pacienteId, Long acudienteId) {
        Optional<PacienteEntity> pacienteOpt = pacienteRepository.findById(pacienteId);
        Optional<PacienteEntity> acudienteOpt = co.edu.uniandes.dse.parcialprueba.repositories.pacienteRepository.findById(acudienteId);

        if (!pacienteOpt.isPresent() || !acudienteOpt.isPresent()) {
            throw new IllegalArgumentException("Uno de los pacientes no existe");
        }

        PacienteEntity paciente = pacienteOpt.get();
        PacienteEntity acudiente = acudienteOpt.get();

        if (paciente.getAcudiente() != null) {
            throw new IllegalArgumentException("El paciente ya tiene un acudiente asignado");
        }
        if (acudiente.getAcudiente() != null) {
            throw new IllegalArgumentException("El acudiente ya tiene su propio acudiente asignado");
        }
        if (acudiente.getHistoriasClinicas().isEmpty()) {
            throw new IllegalArgumentException("El acudiente debe tener al menos una historia clínica registrada");
        }

        paciente.setAcudiente(acudiente);
        return PacienteEntity.save(paciente);
    }
}

