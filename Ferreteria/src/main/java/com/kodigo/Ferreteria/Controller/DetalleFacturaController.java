package com.kodigo.Ferreteria.Controller;

import com.kodigo.Ferreteria.Service.DetalleFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/detalleFactura")
public class DetalleFacturaController {

    @Autowired
    private DetalleFacturaService detalleFacturaService;
}
