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
public class PersonalTransport extends Transport {
    private User owner;

    @Builder
    public PersonalTransport(UUID id, String name, User owner) {
        super(id, name);
        this.owner = owner;
    }

    @Override
    public TransportType getType() {
        return TransportType.PERSONAL;
    }
}
