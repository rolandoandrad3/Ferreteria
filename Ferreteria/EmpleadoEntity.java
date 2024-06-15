package com.kodigo.Ferreteria.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "empleado")
@Getter
@Setter
@NoArgsConstructor

public class EmpleadoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "correo")
    private String correo;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "genero")
    private String genero;

    @Column(name = "dui")
    private String dui;

    @Column(name = "nit")
    private String nit;

    @Column(name = "nrc")
    private String nrc;

    @Column(name = "tipo_persona")
    private String tipoPersona;

    @Column(name = "estado")
    private String estado;

    @Column(name = "salario")
    private Double salario;

    @Column(name = "fecha_contratacion")
    private LocalDate fechaContratacion;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "jefe")
    private String jefe;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private PersonaEntity persona;




}
