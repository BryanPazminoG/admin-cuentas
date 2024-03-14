package com.banquito.core.gestioncuentas.service.ExternalService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class TipoCuentaRestService {

    private final RestTemplate restTemplate;

    public TipoCuentaRestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> obtenerPorId(String codTipoCuenta) {
        String url = "http://localhost:8081/api/v1/tiposcuenta/" + codTipoCuenta;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        validarRespuesta(response);
        return response;
    }

    public ResponseEntity<String> listarTodo() {
        String url = "http://localhost:8081/api/v1/tiposcuenta";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        validarRespuesta(response);
        return response;
    }

    public ResponseEntity<String> crear(String tipoCuentaDtoJson) {
        String url = "http://localhost:8081/api/v1/tiposcuenta";
        ResponseEntity<String> response = restTemplate.postForEntity(url, tipoCuentaDtoJson, String.class);
        validarRespuesta(response);
        return response;
    }

    public ResponseEntity<String> actualizar(String codTipoCuenta, String tipoCuentaDtoJson) {
        String url = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/api/v1/tiposcuenta")
                .pathSegment(codTipoCuenta)
                .build()
                .toString();
        restTemplate.put(url, tipoCuentaDtoJson);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<String> eliminar(String codTipoCuenta) {
        String url = "http://localhost:8081/api/v1/tiposcuenta/" + codTipoCuenta;
        restTemplate.delete(url);
        return ResponseEntity.noContent().build();
    }

    private void validarRespuesta(ResponseEntity<String> response) {
        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Error al obtener la información desde el servicio externo");
        }
    }
}
