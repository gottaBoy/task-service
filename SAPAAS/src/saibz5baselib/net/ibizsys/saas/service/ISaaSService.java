package net.ibizsys.saas.service;

import net.ibizsys.paas.entity.IEntity;

/**
 * Compatibility service contract.
 *
 * @param <ET> entity type
 */
public interface ISaaSService<ET extends IEntity> extends net.ibizsys.paas.service.IService<ET> {
}
