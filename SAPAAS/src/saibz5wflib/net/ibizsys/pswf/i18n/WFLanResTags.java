package net.ibizsys.pswf.i18n;

/**
 * 工作流语言资源标记
 * @author Administrator
 *
 */
public class WFLanResTags {
	
	
	/*
	 * StringHelper.format("数据[%1$s]流程已经存在",iEntity.get("srfdatainfo"))
	 */
	public final static String MSG_E_000001 = "CTRL.WFSERVICE.ERR000001"; //
	/*
	 * StringHelper.format("数据[%1$s]流程启动检查失败", iEntity.get("srfdatainfo"))
	 */
	public final static String MSG_E_000002 = "CTRL.WFSERVICE.ERR000002"; //
	/*
	 * StringHelper.format("指定工作流实例[%1$s]已经关闭，无法进行交互处理", wfActionParam.getUserData())
	 */
	public final static String MSG_E_000003 = "CTRL.WFSERVICE.ERR000003"; //
	/*
	 * StringHelper.format("提交实例[%1$s]处理步骤[%2$s]与当前步骤[%3$s]不一致", wfActionParam.getUserData(), wfActionParam.getStepId(), wfInstance.getActiveStepName())
	 */
	public final static String MSG_E_000004 = "CTRL.WFSERVICE.ERR000004"; //
	/*
	 * StringHelper.format("当前用户不在指定的代办用户范围")
	 */
	public final static String MSG_E_000005 = "CTRL.WFSERVICE.ERR000005"; //
	/*
	 * StringHelper.format("当前用户不能为工作用户代办指定事项")
	 */
	public final static String MSG_E_000006 = "CTRL.WFSERVICE.ERR000006"; //
	/*
	 * StringHelper.format("没有找到任何交互操作")
	 */
	public final static String MSG_E_000007 = "CTRL.WFSERVICE.ERR000007"; //
	/*
	 * StringHelper.format("指定工作流实例[%1$s]已经关闭，无法进行撤回处理", wfActionParam.getUserData())
	 */
	public final static String MSG_E_000008 = "CTRL.WFSERVICE.ERR000008"; //
	/*
	 * StringHelper.format("指定工作流实例[%1$s]已经关闭，无法进行标记已读操作", wfActionParam.getUserData())
	 */
	public final static String MSG_E_000009 = "CTRL.WFSERVICE.ERR000009"; //
	/*
	 * StringHelper.format("指定工作流实例[%1$s]已经关闭，无法进行超时处理", wfActionParam.getUserData())
	 */
	public final static String MSG_E_000010 = "CTRL.WFSERVICE.ERR000010"; //
	/*
	 * StringHelper.format("指定工作流实例[%1$s]已经关闭，无法进行工作转移", wfActionParam.getUserData())
	 */
	public final static String MSG_E_000011 = "CTRL.WFSERVICE.ERR000011"; //
	/*
	 * "没有找到流程开始节点"
	 */
	public final static String MSG_E_000012 = "CTRL.WFSERVICE.ERR000012"; //
	/*
	 * StringHelper.format("[%1$s][%2$s]执行后，没有指定后续节点", iWFProcessModel.getLogicName(), iWFProcessModel.getName())
	 */
	public final static String MSG_E_000013 = "CTRL.WFSERVICE.ERR000013"; //
	/*
	 * StringHelper.format("处理已经超过[%1$s]次，系统中断", wfActionContext.getMaxLoopCount())
	 */
	public final static String MSG_E_000014 = "CTRL.WFSERVICE.ERR000014"; //
	/*
	 * "当前处理步骤无效"
	 */
	public final static String MSG_E_000015 = "CTRL.WFSERVICE.ERR000015";
	/*
	 * StringHelper.format("[%1$s]执行后，没有指定后续节点", iWFProcessModel.getName())
	 */
	public final static String MSG_E_000016 = "CTRL.WFSERVICE.ERR000016";
	/*
	 * StringHelper.format("指定工作流实例[%1$s]已经关闭，无法进行提交处理", wfActionParam.getInstanceId())
	 */
	public final static String MSG_E_000017 = "CTRL.WFSERVICE.ERR000017";
	/*
	 * StringHelper.format("没有指定用户数据属性")
	 */
	public final static String MSG_E_000018 = "CTRL.WFSERVICE.ERR000018";
	/*
	 * StringHelper.format("暂时不支持自定义连接")
	 */
	public final static String MSG_E_000019 = "CTRL.WFSERVICE.ERR000019";
	/*
	 * StringHelper.format("指定工作流实例[%1$s]已经关闭，无法再次关闭", wfActionParam.getUserData()
	 */
	public final static String MSG_E_000020 = "CTRL.WFSERVICE.ERR000020";
	/*
	 * StringHelper.format("数据[%1$s]流程不允许关闭", wfActionParam.getUserData())
	 */
	public final static String MSG_E_000021 = "CTRL.WFSERVICE.ERR000021";
	/*
	 * StringHelper.format("数据[%1$s]流程不允许重启", wfActionParam.getUserData())
	 */
	public final static String MSG_E_000022 = "CTRL.WFSERVICE.ERR000022";
	/*
	 * StringHelper.format("当前处理后续为结束处理，不存在交互操作处理")
	 */
	public final static String MSG_E_000023 = "CTRL.WFSERVICE.ERR000023";
	/*
	 * StringHelper.format("无法计算当前处理后续的交互处理")
	 */
	public final static String MSG_E_000024 = "CTRL.WFSERVICE.ERR000024";
	/*
	 * StringHelper.format("无法获取当前处理后续的交互处理")
	 */
	public final static String MSG_E_000025 = "CTRL.WFSERVICE.ERR000025";
	/*
	 * StringHelper.format("当前用户不是工作流最后一次操作者，无法进行撤回处理")
	 */
	public final static String MSG_E_000026 = "CTRL.WFSERVICE.ERR000026";
	/*
	 * StringHelper.format("无法对撤回处理进行再撤回")
	 */
	public final static String MSG_E_000027 = "CTRL.WFSERVICE.ERR000027";
	/*
	 * StringHelper.format("无法对超时处理进行撤回")
	 */
	public final static String MSG_E_000028 = "CTRL.WFSERVICE.ERR000028";
	/*
	 * StringHelper.format("没有指定工作流上一个步骤")
	 */
	public final static String MSG_E_000029 = "CTRL.WFSERVICE.ERR000029";
	/*
	 * StringHelper.format("工作流上一个步骤有多个操作者，无法进行撤回处理")
	 */
	public final static String MSG_E_000030 = "CTRL.WFSERVICE.ERR000030";
	/*
	 * StringHelper.format("指定处理[%1$s]不支持超时处理", wfInstance.getActiveStepName())
	 */
	public final static String MSG_E_000031 = "CTRL.WFSERVICE.ERR000031";
	/*
	 * StringHelper.format("指定处理[%1$s]没有定义超时路径", wfInstance.getActiveStepName())
	 */
	public final static String MSG_E_000032 = "CTRL.WFSERVICE.ERR000032";
	
	/*
	 * StringHelper.format("工作流用户[%1$s]没有启用", wfUser.getWFUserName())
	 */
	public final static String MSG_E_000033 = "CTRL.WFSERVICE.ERR000033";

	/*
	 * StringHelper.format("找不到指定工作流用户[%1$s]", wfUser.getWFUserId())
	 */
	public final static String MSG_E_000034 = "CTRL.WFSERVICE.ERR000034";
	
	/*
	 * StringHelper.format("工作流用户[%1$s]不接收工作，但没有指定待办用户", wfUser.getWFUserId())
	 */
	public final static String MSG_E_000035 = "CTRL.WFSERVICE.ERR000035";

	/*
	 * StringHelper.format("指定工作流实例[%1$s]已经关闭，无法进行操作")
	 */
	public final static String MSG_E_000036 = "CTRL.WFSERVICE.ERR000036";
	

	/*
	 * StringHelper.format("指定工作流实例[%1$s]不存在")
	 */
	public final static String MSG_E_000037 = "CTRL.WFSERVICE.ERR000037";
	
	/*
	 * StringHelper.format("没有匹配的下一环节处理人")
	 */
	public final static String MSG_E_000038 = "CTRL.WFSERVICE.ERR000038";
	
	
	/*
	 * StringHelper.format("指定工作流实例[%1$s]已经挂起，无法进行交互处理", wfActionParam.getUserData())
	 */
	public final static String MSG_E_000039 = "CTRL.WFSERVICE.ERR000039"; //
	
	
	/*
	 * StringHelper.format("指定工作流实例[%1$s]已经关闭，无法进行继续操作", wfActionParam.getUserData())
	 */
	public final static String MSG_E_000040 = "CTRL.WFSERVICE.ERR000040"; //
	
	
	/*
	 * StringHelper.format("指定工作流实例[%1$s]没有被挂起，无法进行继续操作", wfActionParam.getUserData())
	 */
	public final static String MSG_E_000041 = "CTRL.WFSERVICE.ERR000041"; //
	
	
	/*
	 * 流程系统步骤：启动
	 */
	public final static String MSG_STEP_START = "CTRL.WFSERVICE.STEP.START";
	
	
	/*
	 * 流程系统步骤：撤回上一步操作
	 */
	public final static String MSG_STEP_ROLLBACK = "CTRL.WFSERVICE.STEP.ROLLBACK";
	
	
	/*
	 * 流程系统步骤：重新启动
	 */
	public final static String MSG_STEP_RESTART = "CTRL.WFSERVICE.STEP.RESTART";
	
	
	/*
	 * 流程系统步骤：超时处理
	 */
	public final static String MSG_STEP_TIMEOUT = "CTRL.WFSERVICE.STEP.TIMEOUT";
	
	
	/*
	 * 流程系统步骤：系统跳转
	 */
	public final static String MSG_STEP_GOTO = "CTRL.WFSERVICE.STEP.GOTO";
	
	/*
	 * 流程系统步骤：工作转移
	 */
	public final static String MSG_STEP_RESUBMIT = "CTRL.WFSERVICE.STEP.RESUBMIT";
	
	
	/*
	 * 流程系统步骤：流程挂起
	 */
	public final static String MSG_STEP_SUSPEND = "CTRL.WFSERVICE.STEP.SUSPEND";
	
	
	/*
	 * 流程系统步骤：流程继续
	 */
	public final static String MSG_STEP_RESUME = "CTRL.WFSERVICE.STEP.RESUME";
}
