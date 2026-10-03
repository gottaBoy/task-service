package net.ibizsys.pswf.core;



/**
 * 流程错误吗定义
 * @author Administrator
 *
 */
public class WFErrors
{
	/*
	 * StringHelper.format("数据[%1$s]流程已经存在",iEntity.get("srfdatainfo"))
	 */
	public final static int E_000001 = 1; //
	/*
	 * StringHelper.format("数据[%1$s]流程启动检查失败", iEntity.get("srfdatainfo"))
	 */
	public final static int E_000002 = 2; //
	/*
	 * StringHelper.format("指定工作流实例[%1$s]已经关闭，无法进行交互处理", wfActionParam.getUserData())
	 */
	public final static int E_000003 = 3; //
	/*
	 * StringHelper.format("提交实例[%1$s]处理步骤[%2$s]与当前步骤[%3$s]不一致", wfActionParam.getUserData(), wfActionParam.getStepId(), wfInstance.getActiveStepName())
	 */
	public final static int E_000004 = 4; //
	/*
	 * StringHelper.format("当前用户不在指定的代办用户范围")
	 */
	public final static int E_000005 = 5; //
	/*
	 * StringHelper.format("当前用户不能为工作用户代办指定事项")
	 */
	public final static int E_000006 = 6; //
	/*
	 * StringHelper.format("没有找到任何交互操作")
	 */
	public final static int E_000007 = 7; //
	/*
	 * StringHelper.format("指定工作流实例[%1$s]已经关闭，无法进行撤回处理", wfActionParam.getUserData())
	 */
	public final static int E_000008 = 8; //
	/*
	 * StringHelper.format("指定工作流实例[%1$s]已经关闭，无法进行标记已读操作", wfActionParam.getUserData())
	 */
	public final static int E_000009 = 9; //
	/*
	 * StringHelper.format("指定工作流实例[%1$s]已经关闭，无法进行超时处理", wfActionParam.getUserData())
	 */
	public final static int E_000010 = 10; //
	/*
	 * StringHelper.format("指定工作流实例[%1$s]已经关闭，无法进行工作转移", wfActionParam.getUserData())
	 */
	public final static int E_000011 = 11; //
	/*
	 * "没有找到流程开始节点"
	 */
	public final static int E_000012 = 12; //
	/*
	 * StringHelper.format("[%1$s][%2$s]执行后，没有指定后续节点", iWFProcessModel.getLogicName(), iWFProcessModel.getName())
	 */
	public final static int E_000013 = 13; //
	/*
	 * StringHelper.format("处理已经超过[%1$s]次，系统中断", wfActionContext.getMaxLoopCount())
	 */
	public final static int E_000014 = 14; //
	/*
	 * "当前处理步骤无效"
	 */
	public final static int E_000015 = 15;
	/*
	 * StringHelper.format("[%1$s]执行后，没有指定后续节点", iWFProcessModel.getName())
	 */
	public final static int E_000016 = 16;
	/*
	 * StringHelper.format("指定工作流实例[%1$s]已经关闭，无法进行提交处理", wfActionParam.getInstanceId())
	 */
	public final static int E_000017 = 17;
	/*
	 * StringHelper.format("没有指定用户数据属性")
	 */
	public final static int E_000018 = 18;
	/*
	 * StringHelper.format("暂时不支持自定义连接")
	 */
	public final static int E_000019 = 19;
	/*
	 * StringHelper.format("指定工作流实例[%1$s]已经关闭，无法再次关闭", wfActionParam.getUserData()
	 */
	public final static int E_000020 = 20;
	/*
	 * StringHelper.format("数据[%1$s]流程不允许关闭", wfActionParam.getUserData())
	 */
	public final static int E_000021 = 21;
	/*
	 * StringHelper.format("数据[%1$s]流程不允许重启", wfActionParam.getUserData())
	 */
	public final static int E_000022 = 22;
	/*
	 * StringHelper.format("当前处理后续为结束处理，不存在交互操作处理")
	 */
	public final static int E_000023 = 23;
	/*
	 * StringHelper.format("无法计算当前处理后续的交互处理")
	 */
	public final static int E_000024 = 24;
	/*
	 * StringHelper.format("无法获取当前处理后续的交互处理")
	 */
	public final static int E_000025 = 25;
	/*
	 * StringHelper.format("当前用户不是工作流最后一次操作者，无法进行撤回处理")
	 */
	public final static int E_000026 = 26;
	/*
	 * StringHelper.format("无法对撤回处理进行再撤回")
	 */
	public final static int E_000027 = 27;
	/*
	 * StringHelper.format("无法对超时处理进行撤回")
	 */
	public final static int E_000028 = 28;
	/*
	 * StringHelper.format("没有指定工作流上一个步骤")
	 */
	public final static int E_000029 = 29;
	/*
	 * StringHelper.format("工作流上一个步骤有多个操作者，无法进行撤回处理")
	 */
	public final static int E_000030 = 30;
	/*
	 * StringHelper.format("指定处理[%1$s]不支持超时处理", wfInstance.getActiveStepName())
	 */
	public final static int E_000031 = 31;
	/*
	 * StringHelper.format("指定处理[%1$s]没有定义超时路径", wfInstance.getActiveStepName())
	 */
	public final static int E_000032 = 32;
	
	/*
	 * StringHelper.format("工作流用户[%1$s]没有启用", wfUser.getWFUserName())
	 */
	public final static int E_000033 = 33;

	/*
	 * StringHelper.format("找不到指定工作流用户[%1$s]", wfUser.getWFUserId())
	 */
	public final static int E_000034 = 34;
	
	/*
	 * StringHelper.format("工作流用户[%1$s]不接收工作，但没有指定待办用户", wfUser.getWFUserId())
	 */
	public final static int E_000035 = 35;

	/*
	 * StringHelper.format("指定工作流实例[%1$s]已经关闭，无法进行操作")
	 */
	public final static int E_000036 = 36;
	

	/*
	 * StringHelper.format("指定工作流实例[%1$s]不存在")
	 */
	public final static int E_000037 = 37;
	
	/*
	 * StringHelper.format("没有匹配的下一环节处理人")
	 */
	public final static int E_000038 = 38;
	
	
	/*
	 * StringHelper.format("指定工作流实例[%1$s]已经挂起，无法进行交互处理", wfActionParam.getUserData())
	 */
	public final static int E_000039 = 39; 
	
	
	/*
	 * StringHelper.format("指定工作流实例[%1$s]已经关闭，无法进行继续操作", wfActionParam.getUserData())
	 */
	public final static int E_000040 = 40;
	
	
	/*
	 * StringHelper.format("指定工作流实例[%1$s]没有被挂起，无法进行继续操作", wfActionParam.getUserData())
	 */
	public final static int E_000041 = 41;
	
	
	
	
	/*
	 * 流程内部错误
	 */
	public final static int E_999999 = 999999;

}
