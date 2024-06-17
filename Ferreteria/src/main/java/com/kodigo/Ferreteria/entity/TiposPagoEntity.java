package com.kodigo.Ferreteria.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

public class TiposPagoEntity {
    @Entity
    @Table(name = "tipos_pago")
    @Getter
    @Setter
    @NoArgsConstructor

    public class TipoPagoEntity implements Serializable {

        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "tipo_pago")
        private String tipoPago;
    }
}
