package dev.alexengrig.mapstruct.spring.demo.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class CommonTransportRequest extends BaseTransportRequest {
    private String code;

    @Builder
    public CommonTransportRequest(Long id, String name, String type, String code) {
        super(id, name, type);
        this.code = code;
    }
}
