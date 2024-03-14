package com.banquito.core.gestioncuentas.service.ExternalService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class EmpresaRestService {
    
    private final RestTemplate restTemplate; 

    public EmpresaRestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    public ResponseEntity<String> listarEmpresas() {
        String url = "http://localhost:8082/api/v1/empresas";
        return restTemplate.getForEntity(url, String.class);
    }

    public ResponseEntity<String> obtenerPorId(String id) {
        String url = UriComponentsBuilder.fromHttpUrl("http://localhost:8082/api/v1/empresas")
                .path("/{id}")
                .buildAndExpand(id)
                .toUriString();
        return restTemplate.getForEntity(url, String.class);
    }

    public ResponseEntity<String> obtenerPorIdentificacion(String numeroIdentificacion) {
        String url = UriComponentsBuilder.fromHttpUrl("http://localhost:8082/api/v1/empresas")
                .path("/RUC/{numeroIdentificacion}")
                .buildAndExpand(numeroIdentificacion)
                .toUriString();
        return restTemplate.getForEntity(url, String.class);
    }

    public ResponseEntity<String> desactivar(String idCliente) {
        String url = UriComponentsBuilder.fromHttpUrl("http://localhost:8082/api/v1/empresas")
                .path("/desactivar/{idCliente}")
                .buildAndExpand(idCliente)
                .toUriString();
        restTemplate.put(url, null);
        return ResponseEntity.noContent().build();
    }
}