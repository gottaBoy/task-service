package net.ibizsys.model.wf;

import net.ibizsys.pswf.core.IWFLinkGroupCondModel;

/**
 * 工作流连接组合条件对象接口
 * @author Administrator
 *
 */
public interface IPSWFLinkGroupCond extends IPSWFLinkCond,IWFLinkGroupCondModel
{
	/**
	 * 获取组逻辑
	 * @return
	 */
	String getGroupOP();
	
	
	/**
	 * 是否取反
	 * @return
	 */
	boolean isNotMode();
	
	
	
	/**
	 * 获取子条件集合
	 * @return
	 */
	java.util.Iterator<IPSWFLinkCond> getPSWFLinkConds();
}
