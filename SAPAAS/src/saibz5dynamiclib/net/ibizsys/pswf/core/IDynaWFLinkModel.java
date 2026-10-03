package net.ibizsys.pswf.core;

import net.ibizsys.paas.core.IDynaModel;
import net.ibizsys.paas.core.IDynaModelJsonLoader;

/**
 * 动态工作流连接模型接口对象
 * @author Administrator
 *
 */
public interface IDynaWFLinkModel  extends IWFLinkModel,IDynaModel,IDynaModelJsonLoader {

	/**
	 * 流程连接条件集合
	 */
	public final static String ATTR_WFLINKCONDS = "wflinkconds";
	
	/**
	 * 流程连接角色集合
	 */
	public final static String ATTR_WFLINKROLES = "wflinkroles";
	
	
	/**
	 * 源处理标识
	 */
	public final static String ATTR_FROMWFPROCID = "fromwfprocid";
	
	/**
	 * 源处理标识
	 */
	public final static String ATTR_TOWFPROCID = "towfprocid";
	
	
	/**
	 * 逻辑名称
	 */
	public final static String ATTR_LOGICNAME = "logicname";
	
	
	/**
	 * 下一步条件
	 */
	public final static String ATTR_NEXTCOND = "nextcond";
	
	
	/**
	 * 模型标识
	 */
	public final static String ATTR_MODELID = "modelid";
	
	
	/**
	 * 初始化
	 * @param iDynaWFVersionModel
	 * @param modelObject
	 * @throws Exception
	 */
	void init(IDynaWFVersionModel iDynaWFVersionModel,Object modelObject) throws Exception;

}
