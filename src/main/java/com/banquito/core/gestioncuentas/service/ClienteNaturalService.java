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

    public ResponseEntity<String> listarClientes(){
        return this.clientesRestService.obtenerClientesNaturales();
    }

    public ResponseEntity<String> obtenerPorTipoIndentificacion(String tipo, String numero){
        return this.clientesRestService.buscarPorIdentificacion(tipo, numero);
    }

    public ResponseEntity<String> obtenerPorIdCliente(String idCliente){
        return this.clientesRestService.obtenerPorId(idCliente);
    }
    
}