package net.ibizsys.paas.logic.impl;

import java.util.ArrayList;
import java.util.Iterator;

import net.ibizsys.paas.logic.ICondition;
import net.ibizsys.paas.logic.IGroupCondition;

/**
 * 组条件对象
 * 
 * @author Administrator
 *
 * @param <CT>
 */
public abstract class GroupConditionImpl<CT extends ICondition> extends ConditionImpl implements IGroupCondition<CT> {
	private boolean bNotMode = false;
	private ArrayList<CT> condList = new ArrayList<CT>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.logic.IGroupCondition#isNotMode()
	 */
	@Override
	public boolean isNotMode() {
		return this.bNotMode;
	}

	/**
	 * 设置逻辑取反模式
	 * 
	 * @param bNotMode the bNotMode to set
	 */
	protected void setNotMode(boolean bNotMode) {
		this.bNotMode = bNotMode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.logic.IGroupCondition#getChildConditions()
	 */
	@Override
	public Iterator<CT> getChildConditions() {
		if (condList == null || condList.size() == 0) return null;
		return condList.iterator();
	}

	/**
	 * 增加子条件
	 * 
	 * @param ct
	 */
	protected void addCondition(CT ct) {
		condList.add(ct);
	}

}
