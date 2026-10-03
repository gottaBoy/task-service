package net.ibizsys.pswf.core;

/**
 * 流程连接模型
 * 
 * @author lionlau
 *
 */
public interface IWFLinkModel {

	/**
	 * 超时连接
	 */
	public final static String Timeout = "TIMEOUT";

	/**
	 * 交互连接
	 */
	public final static String IAAction = "IAACTION";

	/**
	 * 常规连接
	 */
	public final static String Route = "ROUTE";

	/**
	 * 嵌入流程提交
	 */
	public final static String WFReturn = "WFRETURN";

	/**
	 * 业务连接模式：无
	 */
	final int THREADLINKMODE_NONE = 0;

	/**
	 * 业务连接模式：主线
	 */
	final int THREADLINKMODE_MAJOR = 1;

	/**
	 * 业务连接模式：从线
	 */
	final int THREADLINKMODE_MINOR = 2;

	/**
	 * 初始化
	 * 
	 * @param iWFVersionModel
	 * @throws Exception
	 */
	void init(IWFVersionModel iWFVersionModel) throws Exception;

	/**
	 * 获取标识
	 * 
	 * @return
	 */
	String getId();

	/**
	 * 获取名称
	 * 
	 * @return
	 */
	String getName();

	/**
	 * 获取逻辑名称
	 * 
	 * @return
	 */
	String getLogicName();

	/**
	 * 获取逻辑名称的语言资源标记
	 * 
	 * @return
	 */
	String getLNLanResTag();

	/**
	 * 获取版本模型对象
	 * 
	 * @return
	 */
	IWFVersionModel getWFVersionModel();

	/**
	 * 获取连接到目标标识
	 * 
	 * @return
	 */
	String getNext();

	/**
	 * 获取源点
	 * 
	 * @return
	 */
	String getFrom();

	/**
	 * 获取源端点
	 * 
	 * @return
	 */
	String getSrcEndPoint();

	/**
	 * 获取目标端点
	 * 
	 * @return
	 */
	String getDstEndPoint();

	/**
	 * 获取用户数据
	 * 
	 * @return
	 */
	String getUserData();

	/**
	 * 获取用户数据2
	 * 
	 * @return
	 */
	String getUserData2();

	/**
	 * 获取流程主线节点显示名称
	 * 
	 * @return
	 */
	String getThreadShowName();

	/**
	 * 是否为业务流程主线
	 * 
	 * @return
	 */
	int getThreadLinkMode();

	/**
	 * 获取标准业务流程模型标识
	 * 
	 * @return
	 */
	String getBPMNModelId();

	/**
	 * 获取下一步的条件
	 * 
	 * @return
	 */
	String getNextCondition();
}
