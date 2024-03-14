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

    public ResponseEntity<String> listarTodo() {
        String url = "http://localhost:8081/api/v1/empresas";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        validarRespuesta(response);
        return response;
    }

    public ResponseEntity<String> obtenerPorId(String id) {
        String url = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/api/v1/empresas")
                .pathSegment(id)
                .build()
                .toString();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        validarRespuesta(response);
        return response;
    }

    public ResponseEntity<String> obtenerPorIdentificacion(String numeroIdentificacion) {
        String url = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/api/v1/empresas/identificacion")
                .queryParam("numero", numeroIdentificacion)
                .build()
                .toUriString();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        validarRespuesta(response);
        return response;
    }

    public ResponseEntity<String> crear(String empresaDtoJson) {
        String url = "http://localhost:8081/api/v1/empresas";
        ResponseEntity<String> response = restTemplate.postForEntity(url, empresaDtoJson, String.class);
        validarRespuesta(response);
        return response;
    }

    public ResponseEntity<String> actualizar(String idEmpresa, String empresaDtoJson) {
        String url = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/api/v1/empresas")
                .pathSegment(idEmpresa)
                .build()
                .toString();
        restTemplate.put(url, empresaDtoJson);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<String> quitarMiembroEmpresa(String idEmpresa, String idMiembro) {
        String url = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/api/v1/empresas")
                .pathSegment(idEmpresa, "miembros", idMiembro, "quitar")
                .build()
                .toString();
        restTemplate.put(url, null);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<String> desactivar(String idCliente) {
        String url = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/api/v1/empresas")
                .pathSegment(idCliente, "desactivar")
                .build()
                .toString();
        restTemplate.put(url, null);
        return ResponseEntity.noContent().build();
    }

    private void validarRespuesta(ResponseEntity<String> response) {
        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Error al obtener la información desde el servicio externo");
        }
    }
}
