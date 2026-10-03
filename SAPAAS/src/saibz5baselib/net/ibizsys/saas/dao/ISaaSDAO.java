package net.ibizsys.saas.dao;

import net.ibizsys.paas.entity.IEntity;

/**
 * Compatibility DAO contract.
 *
 * @param <ET> entity type
 */
public interface ISaaSDAO<ET extends IEntity> extends net.ibizsys.paas.dao.IDAO<ET> {
}
