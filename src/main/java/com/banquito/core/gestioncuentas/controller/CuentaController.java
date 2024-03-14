package com.banquito.core.gestioncuentas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/cuentas")
    public ResponseEntity<String> listarCuentas() {
        return cuentaService.listarTodo();
    }

    @GetMapping("/cuentas/{codCuenta}")
    public ResponseEntity<String> obtenerCuentaPorId(@PathVariable Integer codCuenta) {
        return cuentaService.obtenerPorId(codCuenta);
    }

    @PostMapping("/cuentas")
    public ResponseEntity<String> crearCuenta(@RequestBody String informacionCuenta) {
        return cuentaService.crear(informacionCuenta);
    }

    @PutMapping("/cuentas/{codCuenta}")
    public ResponseEntity<String> actualizarCuenta(@PathVariable Integer codCuenta, @RequestBody String informacionCuenta) {
        return cuentaService.actualizar(codCuenta, informacionCuenta);
    }

    @DeleteMapping("/cuentas/{idCuenta}")
    public ResponseEntity<String> eliminarCuenta(@PathVariable Integer idCuenta) {
        return cuentaService.eliminar(idCuenta);
    }

    @GetMapping("/cuentas/numero/{numeroCuenta}")
    public ResponseEntity<String> obtenerPorNumeroCuenta(@PathVariable String numeroCuenta) {
        return cuentaService.obtenerPorNumeroCuenta(numeroCuenta);
    }

    @PutMapping("/cuentas/actualizarBalance")
    public ResponseEntity<String> actualizarBalance(@RequestParam String informacionCuenta, @RequestParam String codCuenta) {
        return cuentaService.actualizarBalance(informacionCuenta, codCuenta);
    }

    @GetMapping("/cuentas/cliente/{codCliente}")
    public ResponseEntity<String> obtenerCuentasCliente(@PathVariable String codCliente) {
        return cuentaService.obtenerCuentasCliente(codCliente);
    }

    // TipoCuenta endpoints
    @GetMapping("/tipos-cuenta")
    public ResponseEntity<String> listarTiposCuenta() {
        return tipoCuentaService.listarTodo();
    }

    @GetMapping("/tipos-cuenta/{codTipoCuenta}")
    public ResponseEntity<String> obtenerTipoCuentaPorId(@PathVariable String codTipoCuenta) {
        return tipoCuentaService.obtenerPorId(codTipoCuenta);
    }

    @PostMapping("/tipos-cuenta")
    public ResponseEntity<String> crearTipoCuenta(@RequestBody String informacionTipoCuenta) {
        return tipoCuentaService.crear(informacionTipoCuenta);
    }

    @PutMapping("/tipos-cuenta/{codTipoCuenta}")
    public ResponseEntity<String> actualizarTipoCuenta(@PathVariable String codTipoCuenta, @RequestBody String informacionTipoCuenta) {
        return tipoCuentaService.actualizar(informacionTipoCuenta);
    }

    @DeleteMapping("/tipos-cuenta/{codTipoCuenta}")
    public ResponseEntity<String> eliminarTipoCuenta(@PathVariable String codTipoCuenta) {
        return tipoCuentaService.eliminar(codTipoCuenta);
    }
}
