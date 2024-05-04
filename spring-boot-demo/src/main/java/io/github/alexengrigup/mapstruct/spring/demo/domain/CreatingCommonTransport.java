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
public class CreatingCommonTransport extends CreatingTransport {
    private String code;

    @Builder
    public CreatingCommonTransport(String name, String code) {
        super(name);
        this.code = code;
    }
}
