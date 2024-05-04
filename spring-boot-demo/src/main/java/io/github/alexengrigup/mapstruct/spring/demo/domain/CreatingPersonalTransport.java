package io.github.alexengrigup.mapstruct.spring.demo.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class CreatingPersonalTransport extends CreatingTransport {
    private UUID ownerId;

    @Builder
    public CreatingPersonalTransport(String name, UUID ownerId) {
        super(name);
        this.ownerId = ownerId;
    }
}
