package com.banquito.core.gestioncuentas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.core.gestioncuentas.service.CuentaService;
import com.banquito.core.gestioncuentas.service.TipoCuentaService;

@RestController
@RequestMapping("/api/v1/cuentas")
public class CuentaController {
    
    private final CuentaService cuentaService;
    private final TipoCuentaService tipoCuentaService;

    public CuentaController(CuentaService cuentaService, TipoCuentaService tipoCuentaService) {
        this.cuentaService = cuentaService;
        this.tipoCuentaService = tipoCuentaService;
    }
}