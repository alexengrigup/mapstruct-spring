package io.github.alexengrigup.mapstruct.spring.demo.service;

import io.github.alexengrigup.mapstruct.spring.demo.domain.CreatingTransport;
import io.github.alexengrigup.mapstruct.spring.demo.domain.Transport;

import java.util.Optional;
import java.util.UUID;

public interface TransportService {
    Transport create(CreatingTransport creatingTransport);

    Optional<Transport> findById(UUID transportId);
}
