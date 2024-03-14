package com.banquito.core.gestioncuentas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.core.gestioncuentas.service.ClienteNaturalService;
import com.banquito.core.gestioncuentas.service.EmpresaService;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {
    
    private final ClienteNaturalService clienteNaturalService;
    private final EmpresaService empresaService;

    public ClienteController(ClienteNaturalService clienteNaturalService, EmpresaService empresaService) {
        this.clienteNaturalService = clienteNaturalService;
        this.empresaService = empresaService;
    }

    @GetMapping("/naturales")
    public ResponseEntity<String> listarClientesNaturales() {
        return clienteNaturalService.listarTodo();
    }

    @GetMapping("/naturales/{id}")
    public ResponseEntity<String> obtenerClienteNaturalPorId(@PathVariable String id) {
        return clienteNaturalService.obtenerPorId(id);
    }

    @GetMapping("/naturales/buscar")
    public ResponseEntity<String> obtenerClienteNaturalPorIdentificacion(@RequestParam String tipoIdentificacion, @RequestParam String numeroIdentificacion) {
        return clienteNaturalService.obtenerPorIdentificacion(tipoIdentificacion, numeroIdentificacion);
    }

    @PostMapping("/naturales")
    public ResponseEntity<String> crearClienteNatural(@RequestBody String informacionCliente) {
        return clienteNaturalService.crear(informacionCliente);
    }

    @PutMapping("/naturales/{idCliente}")
    public ResponseEntity<String> actualizarClienteNatural(@PathVariable String idCliente, @RequestBody String informacionCliente) {
        return clienteNaturalService.actualizar(idCliente, informacionCliente);
    }

    @PatchMapping("/naturales/desactivar/{idCliente}")
    public ResponseEntity<String> desactivarClienteNatural(@PathVariable String idCliente) {
        return clienteNaturalService.desactivar(idCliente);
    }

    @GetMapping("/empresas")
    public ResponseEntity<String> listarEmpresas() {
        return empresaService.listarTodo();
    }

    @GetMapping("/empresas/{id}")
    public ResponseEntity<String> obtenerEmpresaPorId(@PathVariable String id) {
        return empresaService.obtenerPorId(id);
    }

    @GetMapping("/empresas/buscar/{numeroIdentificacion}")
    public ResponseEntity<String> obtenerEmpresaPorIdentificacion(@PathVariable String numeroIdentificacion) {
        return empresaService.obtenerPorIdentificacion(numeroIdentificacion);
    }

    @PostMapping("/empresas")
    public ResponseEntity<String> crearEmpresa(@RequestBody String informacionEmpresa) {
        return empresaService.crear(informacionEmpresa);
    }

    @PutMapping("/empresas/{idEmpresa}")
    public ResponseEntity<String> actualizarEmpresa(@PathVariable String idEmpresa, @RequestBody String informacionEmpresa) {
        return empresaService.actualizar(idEmpresa, informacionEmpresa);
    }

    @PatchMapping("/empresas/quitarMiembro/{idEmpresa}/{idMiembro}")
    public ResponseEntity<String> quitarMiembroEmpresa(@PathVariable String idEmpresa, @PathVariable String idMiembro) {
        return empresaService.quitarMiembroEmpresa(idEmpresa, idMiembro);
    }

    @PatchMapping("/empresas/desactivar/{idCliente}")
    public ResponseEntity<String> desactivarEmpresa(@PathVariable String idCliente) {
        return empresaService.desactivar(idCliente);
    }
}
