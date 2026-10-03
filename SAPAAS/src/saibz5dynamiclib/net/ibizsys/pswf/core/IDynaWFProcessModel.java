package net.ibizsys.pswf.core;

import net.ibizsys.paas.core.IDynaModel;
import net.ibizsys.paas.core.IDynaModelJsonLoader;


/**
 * 动态工作流处理模型对象接口
 * @author Administrator
 *
 */
public interface IDynaWFProcessModel extends IWFProcessModel,IDynaModel,IDynaModelJsonLoader {

	/**
	 * 流程处理子流程集合
	 */
	public final static String ATTR_WFPROCSUBWFS = "wfprocsubwfs";
	
	/**
	 * 流程处理角色集合
	 */
	public final static String ATTR_WFPROCROLES = "wfprocroles";
	
	/**
	 * 流程处理参数集合
	 */
	public final static String ATTR_WFPROCPARAMS = "wfprocparams";
	
	
	/**
	 * 左侧位置
	 */
	public final static String ATTR_LEFTPOS = "leftpos";
	
	/**
	 * 上方位置
	 */
	public final static String ATTR_TOPPOS = "toppos";
	
	/**
	 * 流程步骤值
	 */
	public final static String ATTR_WFSTEPVALUE = "wfstepvalue";
	
	/**
	 * 异步处理模式
	 */
	public final static String ATTR_ASYNCMODE = "asyncmode";
	
	/**
	 * 支持编辑
	 */
	public final static String ATTR_EDITABLE = "editable";
	
	/**
	 * 备注字段
	 */
	public final static String ATTR_MEMOFIELD = "memofield";
	
	/**
	 * 用户数据
	 */
	public final static String ATTR_USERDATA = "userdata";
	
	/**
	 * 用户数据2
	 */
	public final static String ATTR_USERDATA2 = "userdata2";
	
	/**
	 * 发送通知
	 */
	public final static String ATTR_SENDINFORM = "sendinform";
	
	
	/**
	 * 消息类型
	 */
	public final static String ATTR_MSGTYPE = "msgtype";
	
	/**
	 * 系统消息模板标识
	 */
	public final static String ATTR_SYSMSGTEMPLID = "sysmsgtemplid";
	
	
	/**
	 * 模型标识
	 */
	public final static String ATTR_MODELID = "modelid";
	
	/**
	 * 实体行为
	 */
	public final static String ATTR_DEACTIONNAME = "deactionname";
	
	
	/**
	 * 初始化
	 * @param iDynaWFVersionModel
	 * @param modelObject
	 * @throws Exception
	 */
	void init(IDynaWFVersionModel iDynaWFVersionModel,Object modelObject) throws Exception;
	
}
