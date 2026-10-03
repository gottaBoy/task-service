package net.ibizsys.model.wf;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.pswf.core.IWFDEActionProcessParamModel;


/**
 * 工作流处理参数对象接口
 * 
 * @author lionlau
 *
 */
public interface IPSWFProcessParam extends IPSModelObject, IWFDEActionProcessParamModel {
	/**
	 * 参数值类型：用户全局对象
	 */
	public final static String SRCVALUETYPE_SESSION = "SESSION";

	/**
	 * 参数值类型：系统全局对象
	 */
	public final static String SRCVALUETYPE_APPLICATION = "APPLICATION";

	/**
	 * 参数值类型：唯一编码
	 */
	public final static String SRCVALUETYPE_UNIQUEID = "UNIQUEID";

	/**
	 * 参数值类型：网页请求
	 */
	public final static String SRCVALUETYPE_CONTEXT = "CONTEXT";

	/**
	 * 参数值类型：当前操作用户(编号)
	 */
	public final static String SRCVALUETYPE_OPERATOR = "OPERATOR";

	/**
	 * 参数值类型：当前操作用户(名称)
	 */
	public final static String SRCVALUETYPE_OPERATORNAME = "OPERATORNAME";

	/**
	 * 参数值类型：当前时间
	 */
	public final static String SRCVALUETYPE_CURTIME = "CURTIME";


	
	/**
	 * 获取工作流处理对象
	 * @return
	 */
	IPSWFProcess getPSWFProcess();
	
	/**
	 * 获取目标属性名称
	 * 
	 * @return
	 * @throws Exception
	 */
	String getDstField() throws Exception;

	/**
	 * 获取参数值
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
	 * 获取源值类型，值参考 SA.SRFDA.PS.Core.WF.IPSWFProcessParam.SRCVALUETYPE_XXX 定义
	 * 
	 * @return
	 */
	String getSrcValueType();

}
