package net.ibizsys.saas.demodel;

import net.ibizsys.paas.entity.IEntity;

/**
 * Compatibility data entity model contract.
 *
 * @param <ET> entity type
 */
public interface ISaaSDEModel<ET extends IEntity>
		extends net.ibizsys.paas.demodel.IDataEntityModel<ET> {
}
