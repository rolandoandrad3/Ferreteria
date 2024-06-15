package com.kodigo.Ferreteria.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "persona")
@Getter
@Setter
@NoArgsConstructor

public class PersonaEntity implements Serializable {

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

    @Column(name = "documento")
    private String documento;

    @Column(name = "tipo_persona")
    private String tipoPersona;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    @Column(name = "fecha_modificacion")
    private LocalDate fechaModificacion;

    @Column(name = "usuario_creacion")
    private String usuarioCreacion;

    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;

    @Column(name = "rol")
    private String rol;

    @Column(name = "estado_cuenta")
    private String estadoCuenta;

}
