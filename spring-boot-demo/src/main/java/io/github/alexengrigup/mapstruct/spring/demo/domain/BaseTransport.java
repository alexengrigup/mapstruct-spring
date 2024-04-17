package io.github.alexengrigup.mapstruct.spring.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseTransport {
    private Long id;
    private String name;

    public abstract TransportType getTransportType();
}
