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
public class CommonTransportResponse extends TransportResponse {
    private String code;

    @Builder
    public CommonTransportResponse(UUID id, String name, String code) {
        super(id, name);
        this.code = code;
    }
}
