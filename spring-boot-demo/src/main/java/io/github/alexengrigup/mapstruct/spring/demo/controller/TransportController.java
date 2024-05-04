package io.github.alexengrigup.mapstruct.spring.demo.controller;


import io.github.alexengrigup.mapstruct.spring.demo.domain.CreatingTransport;
import io.github.alexengrigup.mapstruct.spring.demo.domain.Transport;
import io.github.alexengrigup.mapstruct.spring.demo.mapper.CreatingTransportRequestMapper;
import io.github.alexengrigup.mapstruct.spring.demo.mapper.TransportResponseMapper;
import io.github.alexengrigup.mapstruct.spring.demo.payload.CreatingTransportRequest;
import io.github.alexengrigup.mapstruct.spring.demo.payload.TransportResponse;
import io.github.alexengrigup.mapstruct.spring.demo.service.TransportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/transports")
public class TransportController {
    private final TransportService transportService;
    private final CreatingTransportRequestMapper creatingTransportRequestMapper;
    private final TransportResponseMapper transportResponseMapper;

    @PostMapping
    public ResponseEntity<TransportResponse> createTransport(@RequestBody CreatingTransportRequest request) {
        CreatingTransport creatingTransport = creatingTransportRequestMapper.mapRequestToDomain(request);
        Transport transport = transportService.create(creatingTransport);
        TransportResponse response = transportResponseMapper.mapDomainToResponse(transport);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{transportId}")
    public ResponseEntity<TransportResponse> getTransport(@PathVariable UUID transportId) {
        return transportService.findById(transportId)
                .map(transportResponseMapper::mapDomainToResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
