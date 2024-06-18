package com.kodigo.Ferreteria.Controller;

import com.kodigo.Ferreteria.Service.TiposTransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tiposTransaccion")
public class TiposTransaccionController {

    @Autowired
    private TiposTransaccionService tiposTransaccionService;
}
