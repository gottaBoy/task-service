package net.ibizsys.pswf.core;

import java.util.ArrayList;
import java.util.Iterator;

import net.ibizsys.paas.logic.ICondition;

/**
 * 流程连接组条件模型对象
 * @author Administrator
 *
 */
public class WFLinkGroupCondModel extends WFLinkCondModelBase implements IWFLinkGroupCondModel
{
	private ArrayList<IWFLinkCondModel> wfLinkCondModelList = new ArrayList<IWFLinkCondModel>();
	
	private String strGroupOP = ICondition.CONDOP_AND;
	
	private boolean bNotMode = false;
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFLinkCondModel#getCondType()
	 */
	@Override
	public String getCondType()
	{
		return CONDTYPE_GROUP;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFLinkGroupCondModel#getGroupOP()
	 */
	@Override
	public String getGroupOP()
	{
		return strGroupOP;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFLinkGroupCondModel#isNotMode()
	 */
	@Override
	public boolean isNotMode()
	{
		return this.bNotMode;
	}
	
	

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFLinkGroupCondModel#getWFLinkCondModels()
	 */
	@Override
	public Iterator<IWFLinkCondModel> getWFLinkCondModels()
	{
		return wfLinkCondModelList.iterator();
	}
	
	/**
	 * 获取子条件集合
	 * @return
	 */
	public ArrayList<IWFLinkCondModel> getWFLinkCondModelList()
	{
		return wfLinkCondModelList;
	}


	/**
	 * 设置组逻辑操作
	 * @param strGroupOP the strGroupOP to set
	 */
	public void setGroupOP(String strGroupOP)
	{
		this.strGroupOP = strGroupOP;
	}


	/**
	 * 设置逻辑是否取反
	 * @param bNotMode the bNotMode to set
	 */
	public void setNotMode(boolean bNotMode)
	{
		this.bNotMode = bNotMode;
	}
	

}
