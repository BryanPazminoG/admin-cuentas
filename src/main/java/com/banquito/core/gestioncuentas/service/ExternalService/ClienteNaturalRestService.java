package com.banquito.core.gestioncuentas.service.ExternalService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ClienteNaturalRestService {
    private final RestTemplate restTemplate; 

    public ClienteNaturalRestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> listarTodo() {
        String url = "http://localhost:8081/api/v1/clientes";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        validarRespuesta(response);
        return response;
    }

    public ResponseEntity<String> obtenerPorId(String id) {
        String url = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/api/v1/clientes")
                .pathSegment(id)
                .build()
                .toString();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        validarRespuesta(response);
        return response;
    }

    public ResponseEntity<String> obtenerPorIdentificacion(String tipoIdentificacion, String numeroIdentificacion) {
        String url = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/api/v1/clientes/identificacion")
                .queryParam("tipo", tipoIdentificacion)
                .queryParam("numero", numeroIdentificacion)
                .build()
                .toUriString();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        validarRespuesta(response);
        return response;
    }

    public ResponseEntity<String> crear(String clienteDtoJson) {
        String url = "http://localhost:8081/api/v1/clientes";
        ResponseEntity<String> response = restTemplate.postForEntity(url, clienteDtoJson, String.class);
        validarRespuesta(response);
        return response;
    }

    public ResponseEntity<String> actualizar(String idCliente, String clienteDtoJson) {
        String url = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/api/v1/clientes")
                .pathSegment(idCliente)
                .build()
                .toString();
        restTemplate.put(url, clienteDtoJson);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<String> desactivar(String idCliente) {
        String url = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/api/v1/clientes")
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