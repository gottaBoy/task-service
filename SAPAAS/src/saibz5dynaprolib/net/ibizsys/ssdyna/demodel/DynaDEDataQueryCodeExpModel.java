package net.ibizsys.ssdyna.demodel;

import net.ibizsys.model.dataentity.ds.IPSDEDataQueryCodeExp;
import net.ibizsys.paas.core.IDEDataQueryCodeExp;

/**
 * 实体查询代码表达式模型
 * 
 * @author lionlau
 *
 */
public class DynaDEDataQueryCodeExpModel implements IDEDataQueryCodeExp {
	private IPSDEDataQueryCodeExp deDataQueryCodeExp = null;

	public DynaDEDataQueryCodeExpModel(IPSDEDataQueryCodeExp deDataQueryCodeExp) {
		this.deDataQueryCodeExp = deDataQueryCodeExp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IModelBase#getId()
	 */
	@Override
	public String getId() {
		return this.deDataQueryCodeExp.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IModelBase#getName()
	 */
	@Override
	public String getName() {
		return this.deDataQueryCodeExp.getName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataQueryCodeExp#getExpression()
	 */
	@Override
	public String getExpression() {
		return this.deDataQueryCodeExp.getExpression();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataQueryCodeExp#getShowOrder()
	 */
	@Override
	public int getShowOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
