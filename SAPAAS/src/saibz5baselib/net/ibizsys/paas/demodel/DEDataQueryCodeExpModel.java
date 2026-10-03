package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.IDEDataQueryCodeExp;

/**
 * 实体查询代码表达式模型
 * 
 * @author lionlau
 *
 */
public class DEDataQueryCodeExpModel implements IDEDataQueryCodeExp {
	private DEDataQueryCodeExp deDataQueryCodeExp = null;

	public DEDataQueryCodeExpModel(DEDataQueryCodeExp deDataQueryCodeExp) {
		this.deDataQueryCodeExp = deDataQueryCodeExp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IModelBase#getId()
	 */
	@Override
	public String getId() {
		return this.deDataQueryCodeExp.id();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IModelBase#getName()
	 */
	@Override
	public String getName() {
		return this.deDataQueryCodeExp.name();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataQueryCodeExp#getExpression()
	 */
	@Override
	public String getExpression() {
		return this.deDataQueryCodeExp.expression();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataQueryCodeExp#getShowOrder()
	 */
	@Override
	public int getShowOrder() {
		return this.deDataQueryCodeExp.showorder();
	}

}
