package net.ibizsys.model.wf;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.pswf.core.IWFLinkCondModel;


/**
 * 工作流连接条件基对象接口
 * @author lionlau
 *
 */
public interface IPSWFLinkCond  extends IPSModelObject ,IWFLinkCondModel
{

	/**
	*连接条件：组逻辑
	*/
	public final static String LOGICTYPE_GROUP = "GROUP" ;

	/**
	*连接条件：单项逻辑
	*/
	public final static String LOGICTYPE_SINGLE = "SINGLE" ;

	/**
	*连接条件：用户自定义
	*/
	public final static String LOGICTYPE_CUSTOM = "CUSTOM" ;
	
	

	
	/**
	 * 获取父条件对象
	 * @return
	 */
	IPSWFLinkCond getParentPSWFLinkCond();
	
	
	/**
	 * 获取工作流连接对象
	 * @return
	 */
	IPSWFLink getPSWFLink();
	
	
	
	
	/**
	 * 获取条件分类，值参考 SA.SRFDA.PS.Core.WF.IPSWFLinkCond.LOGICTYPE_XXX 定义
	 * @return
	 */
	String getCondType();
}
