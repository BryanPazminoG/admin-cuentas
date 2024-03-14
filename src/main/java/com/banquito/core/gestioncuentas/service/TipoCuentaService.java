package com.banquito.core.gestioncuentas.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.banquito.core.gestioncuentas.service.ExternalService.TipoCuentaRestService;

@Service
public class TipoCuentaService {

    private final TipoCuentaRestService tipoCuentaRestService;

    public TipoCuentaService(TipoCuentaRestService tipoCuentaRestService) {
        this.tipoCuentaRestService = tipoCuentaRestService;
    }

    public ResponseEntity<String> obtenerPorId(String codTipoCuenta) {
        return tipoCuentaRestService.obtenerPorId(codTipoCuenta);
    }

    public ResponseEntity<String> listarTodo() {
        return tipoCuentaRestService.listarTodo();
    }

    public ResponseEntity<String> crear(String informacionTipoCuenta) {
        return tipoCuentaRestService.crear(informacionTipoCuenta);
    }

    public ResponseEntity<String> actualizar(String informacionTipoCuenta) {
        return tipoCuentaRestService.actualizar(informacionTipoCuenta, informacionTipoCuenta);
    }

    public ResponseEntity<String> eliminar(String codTipoCuenta) {
        return tipoCuentaRestService.eliminar(codTipoCuenta);
    }
}
