package io.github.alexengrigup.mapstruct.spring.demo.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class PersonalTransportRequest extends BaseTransportRequest {
    private Long ownerId;

    @Builder
    public PersonalTransportRequest(Long id, String name, String type, Long ownerId) {
        super(id, name, type);
        this.ownerId = ownerId;
    }
}
