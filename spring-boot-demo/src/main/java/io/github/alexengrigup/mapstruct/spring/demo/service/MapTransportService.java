package io.github.alexengrigup.mapstruct.spring.demo.service;

import io.github.alexengrigup.mapstruct.spring.demo.domain.CommonTransport;
import io.github.alexengrigup.mapstruct.spring.demo.domain.CreatingCommonTransport;
import io.github.alexengrigup.mapstruct.spring.demo.domain.CreatingPersonalTransport;
import io.github.alexengrigup.mapstruct.spring.demo.domain.CreatingTransport;
import io.github.alexengrigup.mapstruct.spring.demo.domain.PersonalTransport;
import io.github.alexengrigup.mapstruct.spring.demo.domain.Transport;
import io.github.alexengrigup.mapstruct.spring.demo.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MapTransportService implements TransportService {
    private final Map<UUID, Transport> transportById = new HashMap<>();

    private final UserService userService;

    @Override
    public Transport create(CreatingTransport creatingTransport) {
        UUID id = UUID.randomUUID();
        Transport transport = createByType(creatingTransport);
        transport.setId(id);
        transportById.put(id, transport);
        return transport;
    }

    private Transport createByType(CreatingTransport creatingTransport) {
        if (creatingTransport instanceof CreatingCommonTransport creatingCommonTransport) {
            return CommonTransport.builder()
                    .name(creatingCommonTransport.getName())
                    .code(creatingCommonTransport.getCode())
                    .build();
        } else if (creatingTransport instanceof CreatingPersonalTransport creatingPersonalTransport) {
            User owner = userService.findById(creatingPersonalTransport.getOwnerId())
                    .orElseThrow(() -> new IllegalArgumentException(
                            "No owner by id: " + creatingPersonalTransport.getOwnerId()));
            return PersonalTransport.builder()
                    .name(creatingPersonalTransport.getName())
                    .owner(owner)
                    .build();
        } else {
            throw new IllegalArgumentException(
                    "Unsupported transport type: " + creatingTransport.getClass().getSimpleName());
        }
    }

    @Override
    public Optional<Transport> findById(UUID transportId) {
        return Optional.ofNullable(transportById.get(transportId));
    }
}
