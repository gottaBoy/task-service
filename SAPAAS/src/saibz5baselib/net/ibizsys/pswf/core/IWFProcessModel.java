package net.ibizsys.pswf.core;

/**
 * 流程处理模型接口
 * 
 * @author lionlau
 *
 */
public interface IWFProcessModel {
	/**
	 * 开始
	 */
	public final static String Start = "START";

	/**
	 * 结束
	 */
	public final static String End = "END";

	/**
	 * 常规处理
	 */
	public final static String Process = "PROCESS";

	/**
	 * 交互处理
	 */
	public final static String Interactive = "INTERACTIVE";

	/**
	 * 并行子流程
	 */
	public final static String Parallel = "PARALLEL";

	/**
	 * 嵌套子流程
	 */
	public final static String Embed = "EMBED";

	/**
	 * 排它网关
	 */
	public final static String ExclusiveGateway = "EXCLUSIVEGATEWAY";

	/**
	 * 包容网关
	 */
	public final static String InclusiveGateway = "INCLUSIVEGATEWAY";

	/**
	 * 并行网关
	 */
	public final static String ParallelGateway = "PARALLELGATEWAY";

	/**
	 * 时间事件触发处理
	 */
	public final static String TimerEvent = "TIMEREVENT";

	/**
	 * 超时类型：分钟
	 */
	final static String TIMEOUTTYPE_MINUTE = "MINUTE";

	/**
	 * 超时类型：小时
	 */
	final static String TIMEOUTTYPE_HOUR = "HOUR";

	/**
	 * 超时类型：天
	 */
	final static String TIMEOUTTYPE_DAY = "DAY";

	/**
	 * 超时类型：工作日
	 */
	final static String TIMEOUTTYPE_WORKDAY = "WORKDAY";

	/**
	 * 超时类型：初始化
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
	 * 获取版本模型
	 * 
	 * @return
	 */
	IWFVersionModel getWFVersionModel();

	/**
	 * 获取流程处理类型
	 * 
	 * @return
	 */
	String getWFProcessType();

	/**
	 * 是否为异步处理
	 * 
	 * @return
	 */
	boolean isAsynchronousProcess();

	/**
	 * 判断是否为挂起处理
	 * 
	 * @return
	 */
	boolean isSuspendProcess();

	/**
	 * 是否为结束处理
	 * 
	 * @return
	 */
	boolean isTerminalProcess();

	/**
	 * 是否为开始处理
	 * 
	 * @return
	 */
	boolean isStartProcess();

	/**
	 * 获取流程步骤值
	 * 
	 * @return
	 */
	String getWFStepValue();

	/**
	 * 获取流程处理对象
	 * 
	 * @return
	 */
	IWFProcess getWFProcess();

	/**
	 * 是否支持超时
	 * 
	 * @return
	 */
	boolean isEnableTimeout();

	/**
	 * 获取超时连接目标对象
	 * 
	 * @return
	 */
	String getTimeoutNext();

	/**
	 * 获取超时时长（毫秒）
	 * 
	 * @return
	 */
	int getTimeout();

	/**
	 * 获取超时时长属性
	 * 
	 * @return
	 */
	String getTimeoutField();

	/**
	 * 获取超时类型，值参考 net.ibizsys.pswf.core.IWFProcessModel.TIMEOUTTYPE_XXX 定义
	 * 
	 * @return
	 */
	String getTimeoutType();

	/**
	 * 获取工作时间类型
	 * 
	 * @return
	 */
	String getWorkTimeType();

	/**
	 * 获取工作时间类型
	 * 
	 * @return
	 */
	@Deprecated
	String getWorktimeType();

	/**
	 * 注册连接模型
	 * 
	 * @param iWFLinkModel
	 * @throws Exception
	 */
	void registerWFLinkModel(IWFLinkModel iWFLinkModel) throws Exception;

	/**
	 * 获取处理的连接集合
	 * 
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IWFLinkModel> getWFLinkModels() throws Exception;

	/**
	 * 获取指定流程连接模型对象
	 * 
	 * @param strWFLinkModelId
	 * @return
	 * @throws Exception
	 */
	IWFLinkModel getWFLinkModel(String strWFLinkModelId) throws Exception;

	/**
	 * 获取图例左侧位置
	 * 
	 * @return
	 */
	int getLeftPos();

	/**
	 * 获取图例上方位置
	 * 
	 * @return
	 */
	int getTopPos();

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
	 * 获取流程主线标识
	 * 
	 * @return
	 */
	int getThreadSN();

	/**
	 * 获取流程主线节点显示名称
	 * 
	 * @return
	 */
	String getThreadShowName();

	/**
	 * 获取处理名称语言标记
	 * 
	 * @return
	 */
	String getNameLanResTag();

	/**
	 * 获取流程主线节点显示名称语言标记
	 * 
	 * @return
	 */
	String getTSNLanResTag();

	/**
	 * 获取标准业务流程模型标识
	 * 
	 * @return
	 */
	String getBPMNModelId();
}
