package io.github.alexengrigup.mapstruct.spring.mapper;

/**
 * Simple mapping from a source to a target
 * (like {@link java.util.function.Function Function}).
 *
 * @param <SOURCE> the source type
 * @param <TARGET> the target type
 */
@FunctionalInterface
public interface SimpleMapper<SOURCE, TARGET> {

    TARGET map(SOURCE source);

}
