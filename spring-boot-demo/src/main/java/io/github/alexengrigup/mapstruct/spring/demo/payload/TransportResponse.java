package io.github.alexengrigup.mapstruct.spring.demo.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class TransportResponse {
    private UUID id;
    private String name;
}
