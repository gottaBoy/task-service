package net.ibizsys.saas.service;

import net.ibizsys.paas.entity.IEntity;

/**
 * Compatibility base class for the historical SaaS package.
 *
 * @param <ET> entity type
 */
public abstract class ServiceBase<ET extends IEntity> extends net.ibizsys.paas.service.ServiceBase<ET>
		implements ISaaSService<ET> {
}
