package io.github.alexengrigup.mapstruct.spring.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseTransportRequest {
    private Long id;
    private String name;
    private String type;
}
