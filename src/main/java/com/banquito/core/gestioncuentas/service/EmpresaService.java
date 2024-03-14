package com.banquito.core.gestioncuentas.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.banquito.core.gestioncuentas.service.ExternalService.EmpresaRestService;

@Service
public class EmpresaService {

        private final EmpresaRestService empresasRestService;


    public EmpresaService(EmpresaRestService empresasRestService) {
        this.empresasRestService = empresasRestService;
    }

    public ResponseEntity<String> listarTodo() {
        return empresasRestService.listarTodo();
    }

    public ResponseEntity<String> obtenerPorId(String id) {
        return empresasRestService.obtenerPorId(id);
    }

    public ResponseEntity<String> obtenerPorIdentificacion(String numeroIdentificacion) {
        return empresasRestService.obtenerPorIdentificacion(numeroIdentificacion);
    }

    public ResponseEntity<String> crear(String informacionEmpresa) {
        return empresasRestService.crear(informacionEmpresa);
    }

    public ResponseEntity<String> actualizar(String idEmpresa, String informacionEmpresa) {
        return empresasRestService.actualizar(idEmpresa,informacionEmpresa);
    }

    public ResponseEntity<String> quitarMiembroEmpresa(String idEmpresa, String idMiembro) {
        return empresasRestService.quitarMiembroEmpresa(idEmpresa, idMiembro);
    }

    public ResponseEntity<String> desactivar(String idCliente) {
        return empresasRestService.desactivar(idCliente);
    }
}

