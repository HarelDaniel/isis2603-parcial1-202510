package co.edu.uniandes.dse.parcialprueba.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pacientes")
public class PacienteEntity {

    public static PacienteEntity save(PacienteEntity paciente) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String correo;

    @Column(nullable = false)
    private String telefono;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HistoriaClinicaEntity> historiasClinicas;

    @ManyToOne
    @JoinColumn(name = "acudiente_id")
    private PacienteEntity acudiente;

    // Getters y Setters

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setHistoriasClinicas(List<HistoriaClinicaEntity> historiasClinicas) {
        this.historiasClinicas = historiasClinicas;
    }

    public List<HistoriaClinicaEntity> getHistoriasClinicas() {
        return historiasClinicas;
    }

    public void setAcudiente(PacienteEntity acudiente) {
        this.acudiente = acudiente;
    }

    public PacienteEntity getAcudiente() {
        return acudiente;
    }


}
