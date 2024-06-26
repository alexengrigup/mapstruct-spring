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
public class CommonTransport extends Transport {
    private String code;

    @Builder
    public CommonTransport(UUID id, String name, String code) {
        super(id, name);
        this.code = code;
    }

    @Override
    public TransportType getType() {
        return TransportType.COMMON;
    }
}
