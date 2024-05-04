package io.github.alexengrigup.mapstruct.spring.demo.payload;

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
public class PersonalTransportResponse extends TransportResponse {
    private UUID ownerId;

    @Builder
    public PersonalTransportResponse(UUID id, String name, UUID ownerId) {
        super(id, name);
        this.ownerId = ownerId;
    }
}
