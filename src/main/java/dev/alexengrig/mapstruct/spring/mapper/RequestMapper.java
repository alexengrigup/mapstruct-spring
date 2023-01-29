package dev.alexengrig.mapstruct.spring.mapper;

/**
 * Mapping from a request (DTO) to a domain.
 *
 * @param <REQUEST> the request type
 * @param <DOMAIN>  the domain type
 */
@FunctionalInterface
public interface RequestMapper<REQUEST, DOMAIN> {

    DOMAIN mapRequestToDomain(REQUEST request);

}
