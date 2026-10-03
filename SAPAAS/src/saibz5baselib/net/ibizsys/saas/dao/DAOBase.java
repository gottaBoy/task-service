package net.ibizsys.saas.dao;

import net.ibizsys.paas.entity.IEntity;

/**
 * Compatibility base class for the historical SaaS package.
 *
 * @param <ET> entity type
 */
public abstract class DAOBase<ET extends IEntity> extends net.ibizsys.paas.dao.DAOBase<ET>
		implements ISaaSDAO<ET> {
}
