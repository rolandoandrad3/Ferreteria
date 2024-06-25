package com.kodigo.Ferreteria.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name ="transaccion")

public class TransaccionEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "monto")
    private Double monto;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

    @ManyToOne
    @JoinColumn(name = "factura_id")
    private FacturaEntity factura;

    @ManyToOne
    @JoinColumn(name = "pago_id")
    private PagoEntity pago;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private ProductosEntity producto;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaEntity categoria;

    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    private ProveedorEntity proveedor;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private EmpleadoEntity empleado;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private PersonaEntity persona;

    @ManyToOne
    @JoinColumn(name = "tipos_pago_id")
    private TiposPagoEntity tiposPagoEntity;

    //Tipos de transacciones son compra, venta, devolucion, etc
    @ManyToOne
    @JoinColumn(name = "tipos_transaccion_id")
    private TiposTransaccionEntity tiposTransaccionEntity;
}
