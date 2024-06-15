package com.kodigo.Ferreteria.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor

public class ClienteEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @Column(name = "fecha_ingreso")
    private LocalDate fechaIngreso;



    @Column(name = "estado")
    private String estado;
}
