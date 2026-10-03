package net.ibizsys.pswf.core;

import net.ibizsys.paas.core.IDynaModel;
import net.ibizsys.paas.core.IDynaModelJsonLoader;
import net.ibizsys.paas.entity.IEntity;

/**
 * 动态工作流版本对象模型接口
 * @author Administrator
 *
 */
public interface IDynaWFVersionModel extends IWFVersionModel,IDynaModel,IDynaModelJsonLoader {

	/**
	 * 模型属性：工作流版本处理集合节点
	 */
	public final static String ATTR_WFPROCESSES = "wfprocesses";
	
	
	/**
	 * 模型属性：工作流版本连接集合节点
	 */
	public final static String ATTR_WFLINKS = "wflinks";
	
	
	
	/**
	 * 模型属性：流程模式
	 */
	public final static String ATTR_WFMODE = "wfmode";
	
	
	
	/**
	 * 模型属性：标准业务流程模型
	 */
	public final static String ATTR_BPMNMODEL = "bpmnmodel";
	

	
	
	/**
	 * 初始化
	 * @param iDynaWFModel
	 * @param iEntity
	 * @throws Exception
	 */
	void init(IDynaWFModel iDynaWFModel,IEntity iEntity)throws Exception;
	
	
	
	/**
	 * 获取动态实例标识
	 * @return
	 */
	String getDynaInstId();
	
	
	
}
