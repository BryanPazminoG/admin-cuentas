package com.banquito.core.gestioncuentas.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.banquito.core.gestioncuentas.service.ExternalService.CuentaRestService;

@Service
public class CuentaService {

    private CuentaRestService cuentaRestService;

    public CuentaService(CuentaRestService cuentaRestService) {
        this.cuentaRestService = cuentaRestService;
    }

    public ResponseEntity<String> listarTodo() {
        return cuentaRestService.listarTodo();
    }

    public ResponseEntity<String> obtenerPorId(Integer codCuenta) {
        return cuentaRestService.obtenerPorId(codCuenta);
    }

    public ResponseEntity<String> crear(String informacionCuenta) {
        return cuentaRestService.crear(informacionCuenta);
    }

    public ResponseEntity<String> actualizar(Integer codCuenta,String informacionCuenta) {
        return cuentaRestService.actualizar(codCuenta, informacionCuenta);
    }

    public ResponseEntity<String> eliminar(Integer idCuenta) {
        return cuentaRestService.eliminar(idCuenta);
    }

    public ResponseEntity<String> obtenerPorNumeroCuenta(String numeroCuenta) {
        return cuentaRestService.obtenerPorNumeroCuenta(numeroCuenta);
    }

    public ResponseEntity<String> actualizarBalance(String informacionCuenta, String codCuenta) {
        return cuentaRestService.actualizarBalance(informacionCuenta, codCuenta);
    }

    public ResponseEntity<String> obtenerCuentasCliente(String codCliente) {
        return cuentaRestService.obtenerCuentasCliente(codCliente);
    }
}
