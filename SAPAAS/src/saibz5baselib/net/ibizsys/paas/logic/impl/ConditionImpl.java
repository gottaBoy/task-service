package net.ibizsys.paas.logic.impl;

import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.logic.ICondition;

/**
 * 条件对象
 * 
 * @author Administrator
 *
 */
public class ConditionImpl extends ModelBaseImpl implements ICondition {
	private String strCondOp = null;
	private String strCondType = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.logic.ICondition#getCondOp()
	 */
	@Override
	public String getCondOp() {
		return strCondOp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.logic.ICondition#getCondType()
	 */
	@Override
	public String getCondType() {
		return strCondType;
	}

	/**
	 * 设置条件操作
	 * 
	 * @param strCondOp the strCondOp to set
	 */
	protected void setCondOp(String strCondOp) {
		this.strCondOp = strCondOp;
	}

	/**
	 * 设置条件类型
	 * 
	 * @param strCondType the strCondType to set
	 */
	protected void setCondType(String strCondType) {
		this.strCondType = strCondType;
	}

}
