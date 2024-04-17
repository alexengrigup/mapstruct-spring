package io.github.alexengrigup.mapstruct.spring.demo.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class PersonalTransport extends BaseTransport {
    private User owner;

    @Builder
    public PersonalTransport(Long id, String name, User owner) {
        super(id, name);
        this.owner = owner;
    }

    @Override
    public TransportType getTransportType() {
        return TransportType.PERSONAL;
    }
}
