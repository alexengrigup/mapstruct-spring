package dev.alexengrig.mapstruct.spring.mapper;

/**
 * Mapping from a request to a domain and a result domain to a response,
 * for example:
 *
 * <pre><code>
 * class ControllerService {
 *     MvcMapper&lt;Request, Domain, ResultDomain, Response&gt; mvcMapper;
 *     BusinessService service;
 *
 *     Response doControllerHandling(Request request) {
 *         Domain domain = mvcMapper.mapRequestToDomain(request);
 *         ResultDomain result = service.doBusiness(domain);
 *         return mvcMapper.mapDomainToResponse(result);
 *     }
 * }
 * </code></pre>
 *
 * @param <RESULT_DOMAIN> the result domain type
 * @see RequestMapper
 * @see ResponseMapper
 */
public interface MvcMapper<REQUEST, DOMAIN, RESULT_DOMAIN, RESPONSE>
        extends RequestMapper<REQUEST, DOMAIN>, ResponseMapper<RESULT_DOMAIN, RESPONSE> {

    @Override
    DOMAIN mapRequestToDomain(REQUEST request);

    @Override
    RESPONSE mapDomainToResponse(RESULT_DOMAIN domainResult);

}
