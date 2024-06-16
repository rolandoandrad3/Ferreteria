package com.kodigo.Ferreteria.entity;

import jakarta.persistence.*;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "factura")
@Getter
@Setter
@NoArgsConstructor

public class FacturaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_factura")
    private String fechaFactura;

    @Column(name = "total")
    private Double total;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private EmpleadoEntity empleado;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private ProductosEntity producto;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaEntity categoria;

    @ManyToOne
    @JoinColumn(name = "pago_id")
    private PagoEntity pago;

    @ManyToOne
    @JoinColumn(name = "tipo_pago_id")
    private TiposPago tiposPago;
}
