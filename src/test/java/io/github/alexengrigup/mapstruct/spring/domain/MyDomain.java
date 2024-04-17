package io.github.alexengrigup.mapstruct.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MyDomain {

    private Long id;
    private String value;
    private long size;
    private boolean archived;

}
