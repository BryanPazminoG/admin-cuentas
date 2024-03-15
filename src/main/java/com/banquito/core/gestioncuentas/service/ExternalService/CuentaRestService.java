package com.banquito.core.gestioncuentas.service.ExternalService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class CuentaRestService {

    private final RestTemplate restTemplate;

    public CuentaRestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> listarTodo() {
        String url = "http://35.232.62.178:8080/api/v1/cuentas";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        validarRespuesta(response);
        return response;
    }

    public ResponseEntity<String> obtenerPorId(Integer codCuenta) {
        String url = "http://35.232.62.178:8080/api/v1/cuentas/" + codCuenta;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        validarRespuesta(response);
        return response;
    }

    public ResponseEntity<String> crear(String cuentaDtoJson) {
        String url = "http://35.232.62.178:8080/api/v1/cuentas/";
        ResponseEntity<String> response = restTemplate.postForEntity(url, cuentaDtoJson, String.class);
        validarRespuesta(response);
        return response;
    }

    public ResponseEntity<String> actualizar(Integer codCuenta, String cuentaDtoJson) {
        String url = "http://35.232.62.178:8080/api/v1/cuentas/" + codCuenta;
        restTemplate.put(url, cuentaDtoJson);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<String> eliminar(Integer codCuenta) {
        String url = "http://35.232.62.178:8080/api/v1/cuentas/" + codCuenta;
        restTemplate.delete(url);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<String> obtenerPorNumeroCuenta(String numeroCuenta) {
        String url = UriComponentsBuilder.fromHttpUrl("http://35.232.62.178:8080/api/v1/cuentas/")
                .queryParam("numeroCuenta", numeroCuenta)
                .build()
                .toString();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        validarRespuesta(response);
        return response;
    }

    public ResponseEntity<String> obtenerCuentasCliente(String codCliente) {
        String url = UriComponentsBuilder.fromHttpUrl("http://35.232.62.178:8080/api/v1/cuentas/cliente")
                .queryParam("codCliente", codCliente)
                .build()
                .toString();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        validarRespuesta(response);
        return response;
    }

    public ResponseEntity<String> actualizarBalance(String cuentaDtoJson, String codCuenta) {
        String url = UriComponentsBuilder.fromHttpUrl("http://35.232.62.178:8080/api/v1/cuentas/")
                .pathSegment(codCuenta, "actualizarBalance")
                .build()
                .toString();
        restTemplate.put(url, cuentaDtoJson);
        return ResponseEntity.noContent().build();
    }
    
    private void validarRespuesta(ResponseEntity<String> response) {
        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Error al obtener la información desde el servicio externo");
        }
    }
}
