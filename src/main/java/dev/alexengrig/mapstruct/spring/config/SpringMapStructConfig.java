package dev.alexengrig.mapstruct.spring.config;

import org.mapstruct.Builder;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.SubclassExhaustiveStrategy;

/**
 * {@code MapStruct} configuration for {@code Spring}.
 *
 * <p>Add annotation {@link org.mapstruct.Mapper @Mapper}
 * with config {@link SpringMapStructConfig},
 * for example:
 *
 * <pre><code>
 * &#64;Mapper(config = SpringMapStructConfig.class)
 * public interface Source2TargetMapper {
 *     Target map(Source source);
 * }
 * </code></pre>
 */
@MapperConfig(
        // Spring Dependency Injection
        componentModel = MappingConstants.ComponentModel.SPRING,
        // Dependency Injection with constructors
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        // Prefix MapStruct in implementations
        implementationName = "MapStruct<CLASS_NAME>",
        // Require all mappings or will fail builds
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        // Runtime exceptions when no mappers for all subclasses; you must test it
        subclassExhaustiveStrategy = SubclassExhaustiveStrategy.RUNTIME_EXCEPTION,
        // For parent's class setters
        builder = @Builder(disableBuilder = true)
)
public final class SpringMapStructConfig {
    private SpringMapStructConfig() {
    }
}
