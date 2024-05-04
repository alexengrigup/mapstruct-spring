package io.github.alexengrigup.mapstruct.spring.demo.payload;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class CreatingCommonTransportRequest extends CreatingTransportRequest {
    private String code;

    @Builder
    public CreatingCommonTransportRequest(String name, String code) {
        super(name);
        this.code = code;
    }
}
