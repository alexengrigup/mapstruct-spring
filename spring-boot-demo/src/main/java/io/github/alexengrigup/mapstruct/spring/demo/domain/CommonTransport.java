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
public class CommonTransport extends BaseTransport {
    private String code;

    @Builder
    public CommonTransport(Long id, String name, String code) {
        super(id, name);
        this.code = code;
    }

    @Override
    public TransportType getTransportType() {
        return TransportType.COMMON;
    }
}
