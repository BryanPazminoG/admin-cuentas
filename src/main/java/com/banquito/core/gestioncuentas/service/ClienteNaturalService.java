package com.banquito.core.gestioncuentas.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.banquito.core.gestioncuentas.service.ExternalService.ClienteNaturalRestService;


@Service
public class ClienteNaturalService {
    
        private ClienteNaturalRestService clientesRestService;

    public ClienteNaturalService(ClienteNaturalRestService clientesRestService) {
        this.clientesRestService = clientesRestService;
    }

    public ResponseEntity<String> listarTodo() {
        return clientesRestService.listarTodo();
    }

    public ResponseEntity<String> obtenerPorId(String id) {
        return clientesRestService.obtenerPorId(id);
    }

    public ResponseEntity<String> obtenerPorIdentificacion(String tipoIdentificacion, String numeroIdentificacion) {
        return clientesRestService.obtenerPorIdentificacion(tipoIdentificacion, numeroIdentificacion);
    }

    public ResponseEntity<String> crear(String informacionCliente) {
        return clientesRestService.crear(informacionCliente);
    }

    public ResponseEntity<String> actualizar(String idCliente, String informacionCliente) {
        return clientesRestService.actualizar(idCliente, informacionCliente);
    }

    public ResponseEntity<String> desactivar(String idCliente) {
        return clientesRestService.desactivar(idCliente);
    }
}
