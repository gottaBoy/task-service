package net.ibizsys.model.wf;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.pswf.core.IWFLinkModel;


/**
 * 工作流处理连接对象接口
 * 
 * @author lionlau
 *
 */
public interface IPSWFLink extends IPSModelObject, IWFLinkModel {
	/**
	 * 工作流连接类型：超时连接
	 */
	public final static String WFLINKTYPE_TIMEOUT = "TIMEOUT";

	/**
	 * 工作流连接类型：交互连接
	 */
	public final static String WFLINKTYPE_IAACTION = "IAACTION";

	/**
	 * 工作流连接类型：常规连接
	 */
	public final static String WFLINKTYPE_ROUTE = "ROUTE";

	

	/**
	 * 获取连接条件对象
	 * 
	 * @return
	 */
	IPSWFLinkGroupCond getPSWFLinkGroupCond();

	/**
	 * 获取目标处理对象
	 * 
	 * @return
	 * @throws Exception
	 */
	IPSWFProcess getToPSWFProcess() throws Exception;

	/**
	 * 获取源处理对象
	 * 
	 * @return
	 * @throws Exception
	 */
	IPSWFProcess getFromPSWFProcess() throws Exception;

	/**
	 * 获取工作流版本对象
	 */
	IPSWFVersion getPSWFVersion();

	/**
	 * 获取连接类型，值参考 SA.SRFDA.PS.Core.WF.IPSWFLink.WFLINKTYPE_XXX 定义
	 * 
	 * @return
	 */
	String getWFLinkType();

	/**
	 * 获取连接的逻辑名称
	 * 
	 * @return
	 */
	String getLogicName();

	/**
	 * 处理意见字段
	 * 
	 * @return
	 */
	String getMemoField();

	/**
	 * 获取逻辑名称语言资源对象
	 * 
	 * @return
	 */
	IPSLanguageRes getLNPSLanguageRes();
	
	
	
	/**
	 * 是否启用自定义条件
	 * @return
	 */
	boolean isEnableCustomCond();
	
	
	
	/**
	 * 获取自定义条件
	 * @return
	 */
	String getCustomCond();
}
