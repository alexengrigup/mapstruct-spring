package io.github.alexengrigup.mapstruct.spring.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Transport {
    private UUID id;
    private String name;

    public abstract TransportType getType();
}
