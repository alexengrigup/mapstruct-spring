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
public class CreatingPersonalTransportRequest extends CreatingTransportRequest {
    private UUID ownerId;

    @Builder
    public CreatingPersonalTransportRequest(String name, UUID ownerId) {
        super(name);
        this.ownerId = ownerId;
    }
}
