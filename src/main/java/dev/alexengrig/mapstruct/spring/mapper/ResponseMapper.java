package dev.alexengrig.mapstruct.spring.mapper;

/**
 * Mapping from a domain to a response (DTO).
 *
 * @param <DOMAIN>   the domain type
 * @param <RESPONSE> the response type
 */
@FunctionalInterface
public interface ResponseMapper<DOMAIN, RESPONSE> {

    RESPONSE mapDomainToResponse(DOMAIN domain);

}
