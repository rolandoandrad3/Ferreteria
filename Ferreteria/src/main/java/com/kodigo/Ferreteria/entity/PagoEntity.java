package com.kodigo.Ferreteria.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "pago")
@Getter
@Setter
@NoArgsConstructor

public class PagoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "monto")
    private Double monto;

    @Column(name = "fecha_pago")
    private String fechaPago;

    @ManyToOne
    @JoinColumn(name = "factura_id")
    private FacturaEntity factura;

    @ManyToOne
    @JoinColumn(name = "tipo_pago_id")
    private TiposPagoEntity tiposPago;
}
