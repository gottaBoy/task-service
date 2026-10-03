package net.ibizsys.model.control.form;

import net.ibizsys.model.core.IPSModelObject;


/**
 * 表单成员逻辑对象接口
 * 
 * @author lionlau
 *
 */
public interface IPSDEFDLogic extends IPSModelObject {

	/**
	 * 逻辑类型：部件显示逻辑
	 */
	public final static String LOGICCAT_PANELVISIBLE = "PANELVISIBLE";

	/**
	 * 逻辑类型：部件启用逻辑
	 */
	public final static String LOGICCAT_ITEMENABLE = "ITEMENABLE";

	/**
	 * 逻辑类型：表单项空输入
	 */
	public final static String LOGICCAT_ITEMBLANK = "ITEMBLANK";

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
	 * 获取表单成员对象
	 * 
	 * @return
	 */
	IPSDEFormDetail getPSDEFormDetail();

	/**
	 * 获取逻辑分类，值参考 SA.SRFDA.PS.Core.Control.Form.IPSDEFDLogic.LOGICCAT_XXX 定义
	 * 
	 * @return
	 */
	String getLogicCat();

	/**
	 * 获取逻辑类型，值参考 SA.SRFDA.PS.Core.Control.Form.IPSDEFDLogic.LOGICTYPE_XXX 定义
	 * 
	 * @return
	 */
	String getLogicType();
}
