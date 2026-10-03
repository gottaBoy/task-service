package net.ibizsys.model.dataentity.action;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.field.IPSDEField;


/**
 * 实体行为参数对象接口
 * 
 * @author lionlau
 *
 */
public interface IPSDEActionParam extends IPSModelObject {

	// 定义值类型代码表

	/**
	 * 输入值
	 */
	public final static String VALUETYPE_INPUTVALUE = "INPUTVALUE";
	
	
	/**
	 * 直接值
	 */
	public final static String VALUETYPE_VALUE = "VALUE";

	/**
	 * 空值
	 */
	public final static String VALUETYPE_NULLVALUE = "NULLVALUE";

	/**
	 * 用户全局对象
	 */
	public final static String VALUETYPE_SESSION = "SESSION";

	/**
	 * 系统全局对象
	 */
	public final static String VALUETYPE_APPLICATION = "APPLICATION";

	/**
	 * 唯一编码
	 */
	public final static String VALUETYPE_UNIQUEID = "UNIQUEID";

	/**
	 * 网页请求
	 */
	public final static String VALUETYPE_CONTEXT = "CONTEXT";

	/**
	 * 数据对象属性
	 */
	public final static String VALUETYPE_PARAM = "PARAM";

	/**
	 * 当前操作用户(编号)
	 */
	public final static String VALUETYPE_OPERATOR = "OPERATOR";

	/**
	 * 当前操作用户(名称)
	 */
	public final static String VALUETYPE_OPERATORNAME = "OPERATORNAME";

	/**
	 * 当前时间
	 */
	public final static String VALUETYPE_CURTIME = "CURTIME";

	/**
	 * 当前应用数据
	 */
	public final static String VALUETYPE_APPDATA = "APPDATA";

	/**
	 * 无值
	 */
	public final static String VALUETYPE_NONEVALUE = "NONEVALUE";

	
	
	
	/**
	 * 获取参数的实体属性
	 * @return
	 */
	IPSDEField getPSDEField();
	

	/**
	 * 获取实体行为
	 * 
	 * @return
	 */
	IPSDEAction getPSDEAction();

	/**
	 * 获取值类型，值参考 SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionParam.VALUETYPE_XXX 定义
	 * 
	 * @return
	 */
	String getValueType();

	
	/**
	 * 获取值
	 * @return
	 */
	String getValue();
}
