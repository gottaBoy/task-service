package net.ibizsys.model.dataentity.logic;

import net.ibizsys.model.core.IPSModelObject;



/**
 * 实体逻辑处理参数对象接口
 * 
 * @author lionlau
 *
 */
public interface IPSDELogicNodeParam extends IPSModelObject {

	// 定义参数类型代码表

	/**
	 * 参数类型：设置变量
	 */
	public final static String PARAMTYPE_SETPARAMVALUE = "SETPARAMVALUE";

	/**
	 * 参数类型：重置变量
	 */
	public final static String PARAMTYPE_RESETPARAM = "RESETPARAM";

	/**
	 * 参数类型：拷贝变量
	 */
	public final static String PARAMTYPE_COPYPARAM = "COPYPARAM";

	/**
	 * 参数类型：SQL调用变量
	 */
	public final static String PARAMTYPE_SQLPARAM = "SQLPARAM";

	// 定义源值类型代码表

	/**
	 * 原值类型：源逻辑参数
	 */
	public final static String SRCVALUETYPE_SRCDLPARAM = "SRCDLPARAM";

	/**
	 * 原值类型：网页请求上下文
	 */
	public final static String SRCVALUETYPE_WEBCONTEXT = "WEBCONTEXT";

	/**
	 * 原值类型：无值（NONE）
	 */
	public final static String SRCVALUETYPE_NONEVALUE = "NONEVALUE";

	/**
	 * 原值类型：空值（NULL）
	 */
	public final static String SRCVALUETYPE_NULLVALUE = "NULLVALUE";


	
	/**
	 * 获取实体逻辑节点对象
	 * @return
	 */
	IPSDELogicNode getPSDELogicNode();
	
	/**
	 * 获取参数类型，值参考 SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNodeParam.PARAMTYPE_XXX 定义。
	 * 
	 * @return
	 */
	String getLogicNodeParamType();

	/**
	 * 获取目标逻辑参数对象
	 * 
	 * @return
	 * @throws Exception
	 */
	IPSDELogicParam getDstPSDELogicParam() throws Exception;

	/**
	 * 获取目标属性名称
	 * 
	 * @return
	 * @throws Exception
	 */
	String getDstFieldName() throws Exception;

	/**
	 * 获取源逻辑参数对象
	 * 
	 * @return
	 * @throws Exception
	 */
	IPSDELogicParam getSrcPSDELogicParam() throws Exception;

	/**
	 * 获取源属性名称
	 * 
	 * @return
	 * @throws Exception
	 */
	String getSrcFieldName() throws Exception;

	/**
	 * 获取原值
	 * 
	 * @return
	 */
	String getSrcValue();

	/**
	 * 获取直接的代码
	 * 
	 * @return
	 */
	String getDirectCode();

	/**
	 * 获取源值类型，具体参考
	 * SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNodeParam.SRCVALUETYPE_XXX 定义
	 * 
	 * @return
	 */
	String getSrcValueType();

}
