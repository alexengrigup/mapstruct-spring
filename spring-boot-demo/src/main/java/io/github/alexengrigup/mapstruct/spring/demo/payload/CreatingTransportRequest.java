package io.github.alexengrigup.mapstruct.spring.demo.payload;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(
                name = "common",
                value = CreatingCommonTransportRequest.class
        ),
        @JsonSubTypes.Type(
                name = "personal",
                value = CreatingPersonalTransportRequest.class
        )
})
public abstract class CreatingTransportRequest {
    private String name;
}
