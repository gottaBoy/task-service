package net.ibizsys.model.dataentity.logic;

import net.ibizsys.model.dataentity.IPSDataEntityObject;
import net.ibizsys.paas.core.IDELogic;


/**
 * 实体逻辑对象接口
 * @author Administrator
 *
 */
public interface IPSDELogic extends IPSDataEntityObject,IDELogic
{
	
	/**
	 * 获取逻辑类型
	 * @return
	 */
	String getLogicType();
	
	
	/**
	 *  获取代码名称
	 * @return
	 */
	String getCodeName();
	

	
	
	/**
	 * 获取逻辑名称
	 * @return
	 */
	String getLogicName();
	
	
	
	
	/**
	 * 获取逻辑开始节点
	 * @return
	 */
	IPSDELogicNode getStartPSDELogicNode();
	
	
	
	/**
	 * 获取逻辑处理节点集合
	 * @return
	 */
	java.util.Iterator<IPSDELogicNode> getPSDELogicNodes();
	
	
	/**
	 * 获取逻辑参数集合
	 * @return
	 */
	java.util.Iterator<IPSDELogicParam> getPSDELogicParams();
	

	/**
	 * 获取指定参数对象
	 * @param strPSDELogicParamId
	 * @return
	 * @throws Exception
	 */
	IPSDELogicParam getPSDELogicParam(String strPSDELogicParamId) throws Exception;
	
	
	
	
	/**
	 * 获取指定节点对象
	 * @param strPSDELogicNodeId
	 * @return
	 * @throws Exception
	 */
	IPSDELogicNode getPSDELogicNode(String strPSDELogicNodeId) throws Exception;
	

	
	
	/**
	 * 获取逻辑处理连接集合
	 * @return
	 */
	java.util.Iterator<IPSDELogicLink> getPSDELogicLinks();
	
	
	/**
	 * 获取扩展模式，值参考 SA.SRFDA.PS.Core.DataEntity.IPSDataEntity.EXTENDMODE_XXX 定义
	 * 
	 * @return
	 */
	int getExtendMode();
}
