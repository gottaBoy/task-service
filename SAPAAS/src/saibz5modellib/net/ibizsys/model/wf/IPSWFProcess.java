package net.ibizsys.model.wf;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.pswf.core.IWFProcessModel;


/**
 * 工作流处理对象接口
 * 
 * @author lionlau
 *
 */
public interface IPSWFProcess extends IWFProcessModel,IPSModelObject {
	// 定义流程处理类型代码表

	/**
	 * 流程处理类型：开始
	 */
	public final static String WFPROCESSTYPE_START = "START";

	/**
	 * 流程处理类型：结束
	 */
	public final static String WFPROCESSTYPE_END = "END";

	/**
	 * 流程处理类型：常规处理
	 */
	public final static String WFPROCESSTYPE_PROCESS = "PROCESS";

	/**
	 * 流程处理类型：交互处理
	 */
	public final static String WFPROCESSTYPE_INTERACTIVE = "INTERACTIVE";

	/**
	 * 流程处理类型：并行子流程
	 */
	public final static String WFPROCESSTYPE_PARALLEL = "PARALLEL";

	/**
	 * 流程处理类型：嵌套子流程
	 */
	public final static String WFPROCESSTYPE_EMBED = "EMBED";

	// 定义超时类型代码表

	/**
	 * 超时类型：分钟
	 */
	public final static String TIMEOUTTYPE_MINUTE = "MINUTE";

	/**
	 * 超时类型：小时
	 */
	public final static String TIMEOUTTYPE_HOUR = "HOUR";

	/**
	 * 超时类型：天
	 */
	public final static String TIMEOUTTYPE_DAY = "DAY";

	/**
	 * 超时类型：工作日
	 */
	public final static String TIMEOUTTYPE_WORKDAY = "WORKDAY";

	

	/**
	 * 获取处理连接集合
	 * 
	 * @return
	 */
	java.util.Iterator<IPSWFLink> getPSWFLinks();

	/**
	 * 获取逻辑处理节点参数集合
	 * 
	 * @return
	 */
	java.util.Iterator<IPSWFProcessParam> getPSWFProcessParams();

	/**
	 * 获取工作流处理类型，值参考 SA.SRFDA.PS.Core.WF.IPSWFProcess.WFPROCESSTYPE_XXX 定义
	 * @return
	 */
	String getWFProcessType();

	/**
	 * 获取工作流版本对象
	 * 
	 * @return
	 */
	IPSWFVersion getPSWFVersion();

	/**
	 * 获取代码名称
	 * 
	 * @return
	 */
	String getCodeName();

	/**
	 * 是否为并行输出
	 * 
	 * @return
	 */
	boolean isParallelOutput();

	/**
	 * 获取流程步骤值
	 * 
	 * @return
	 */
	String getWFStepValue();

	/**
	 * 获取处理名称语言资源对象
	 * 
	 * @return
	 */
	IPSLanguageRes getNamePSLanguageRes();

	
	/**
	 * 获取业务条线名称语言资源对象
	 * 
	 * @return
	 */
	IPSLanguageRes getTSNPSLanguageRes();
}
