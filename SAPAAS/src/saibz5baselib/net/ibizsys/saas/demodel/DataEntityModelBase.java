package net.ibizsys.saas.demodel;

import net.ibizsys.paas.entity.IEntity;

/**
 * Compatibility base class for the historical SaaS package.
 *
 * @param <ET> entity type
 */
public abstract class DataEntityModelBase<ET extends IEntity>
		extends net.ibizsys.paas.demodel.DataEntityModelBase<ET>
		implements ISaaSDEModel<ET> {
	public DataEntityModelBase() throws Exception {
		super();
	}
}
