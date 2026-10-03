package net.ibizsys.model.dataentity.logic;

import net.ibizsys.model.core.IPSModelObject;


/**
 * 实体逻辑连接条件对象接口
 * 
 * @author lionlau
 *
 */
public interface IPSDELogicLinkCond extends IPSModelObject {
	/**
	 * 逻辑类型：组逻辑
	 */
	public final static String LOGICTYPE_GROUP = "GROUP";

	/**
	 * 逻辑类型：单项逻辑
	 */
	public final static String LOGICTYPE_SINGLE = "SINGLE";

	/**
	 * 逻辑类型：用户自定义
	 */
	public final static String LOGICTYPE_CUSTOM = "CUSTOM";

	
	/**
	 * 获取逻辑连接对象
	 * 
	 * @return
	 */
	IPSDELogicLink getPSDELogicLink();

	/**
	 * 获取逻辑分类，值参考 SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkCond.LOGICTYPE_XXX 定义
	 * 
	 * @return
	 */
	String getLogicType();
}
