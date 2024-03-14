package com.banquito.core.gestioncuentas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        return clienteNaturalService.listarClientes();
    }

    @GetMapping("/naturales/buscar")
    public ResponseEntity<String> obtenerNaturalPorTipoYNumeroIdentificacion(@RequestParam String tipo, @RequestParam String numero) {
        return clienteNaturalService.obtenerPorTipoIndentificacion(tipo, numero);
    }

    @GetMapping("/naturales/{idCliente}")
    public ResponseEntity<String> obtenerNaturalPorId(@PathVariable String idCliente) {
        return clienteNaturalService.obtenerPorIdCliente(idCliente);
    }

    @GetMapping("/empresas")
    public ResponseEntity<String> listarEmpresas() {
        return empresaService.listarEmpresas();
    }

    @GetMapping("/empresas/{numero}")
    public ResponseEntity<String> obtenerEmpresaPorIdentificacion(@PathVariable String numero) {
        return empresaService.obtenerPorTipoIndentificacion(numero);
    }
}
