package net.ibizsys.model.wf;

import net.ibizsys.pswf.core.IWFLinkSingleCondModel;

/**
 * 工作流连接单项条件对象接口
 * 
 * @author Administrator
 *
 */
public interface IPSWFLinkSingleCond extends IPSWFLinkCond, IWFLinkSingleCondModel {

	// 定义参数类型代码表

	/**
	 * 参数类型代码表:数据对象属性
	 */
	public final static String PARAMTYPE_ENTITYFIELD = "ENTITYFIELD";

	/**
	 * 参数类型代码表:当前时间
	 */
	public final static String PARAMTYPE_CURTIME = "CURTIME";

	/**
	 * 参数类型代码表:时间规则
	 */
	public final static String PARAMTYPE_TIMERULE = "TIMERULE";

	/**
	 * 获取目标属性名称
	 * 
	 * @return
	 * @throws Exception
	 */
	String getFieldName() throws Exception;

	/**
	 * 获取值操作符号标识
	 * 
	 * @return
	 */
	String getPSDBValueOPId();

	/**
	 * 获取参数类型，值参考 net.ibizsys.pswf.core.IWFLinkSingleCondModel.PARAMTYPE_XXX 定义
	 * 
	 * @return
	 */
	String getParamType();

	/**
	 * 获取参数值
	 * 
	 * @return
	 */
	String getParamValue();

}
