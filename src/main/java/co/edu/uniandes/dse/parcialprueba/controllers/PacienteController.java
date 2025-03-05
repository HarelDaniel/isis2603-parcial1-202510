package co.edu.uniandes.dse.parcialprueba.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uniandes.dse.parcialprueba.entities.PacienteEntity;
import co.edu.uniandes.dse.parcialprueba.services.PacienteService;


@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<PacienteEntity> crearPaciente(@RequestBody PacienteEntity paciente) {
        return ResponseEntity.ok(pacienteService.crearPaciente(paciente));
    }

    @PutMapping("/{pacienteId}/acudiente/{acudienteId}")
    public ResponseEntity<PacienteEntity> asociarAcudiente(@PathVariable Long pacienteId, @PathVariable Long acudienteId) {
        return ResponseEntity.ok(pacienteService.asociarAcudiente(pacienteId, acudienteId));
    }
}
