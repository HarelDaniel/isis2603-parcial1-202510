package co.edu.uniandes.dse.parcialprueba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

import co.edu.uniandes.dse.parcialprueba.repositories.HistorialClinicaRepository;
import co.edu.uniandes.dse.parcialprueba.repositories.pacienteRepository;
import co.edu.uniandes.dse.parcialprueba.entities.*;

@Service
public class HistoriaClinicaService {

    @Autowired
    private HistorialClinicaRepository historiaClinicaRepository;

    @Autowired
    private pacienteRepository pacienteRepository;

    public HistoriaClinicaEntity crearHistoriaClinica(Long pacienteId, String diagnostico, String tratamiento) {
        Optional<PacienteEntity> pacienteOpt = pacienteRepository.findById(pacienteId);

        if (!pacienteOpt.isPresent()) {
            throw new IllegalArgumentException("El paciente no existe");
        }

        PacienteEntity paciente = pacienteOpt.get();

        // Modificar el diagnóstico si el paciente tiene acudiente
        if (paciente.getAcudiente() != null) {
            diagnostico = "HistoriaCompartida-" + diagnostico;
        }

        HistoriaClinicaEntity historia = new HistoriaClinicaEntity();
        historia.setDiagnostico(diagnostico);
        historia.setTratamiento(tratamiento);
        historia.setFechaDeCreacion(LocalDate.now());
        historia.setPaciente(paciente);

        return historiaClinicaRepository.save(historia);
    }
}
