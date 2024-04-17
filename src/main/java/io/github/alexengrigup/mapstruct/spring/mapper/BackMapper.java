package io.github.alexengrigup.mapstruct.spring.mapper;

/**
 * Mapping from a source to a target and back.
 *
 * @see SimpleMapper
 */
public interface BackMapper<SOURCE, TARGET> extends SimpleMapper<SOURCE, TARGET> {

    SOURCE mapBack(TARGET source);

}
