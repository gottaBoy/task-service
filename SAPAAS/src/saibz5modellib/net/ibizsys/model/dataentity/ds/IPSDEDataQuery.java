package net.ibizsys.model.dataentity.ds;

import net.ibizsys.model.dataentity.IPSDataEntityObject;
import net.ibizsys.paas.core.IDEDataQuery;


/**
 * 实体数据查询对象接口
 * 
 * @author Administrator
 *
 */
public interface IPSDEDataQuery extends IPSDataEntityObject, IDEDataQuery {
	
//	/**
//	 * 获取代码名称
//	 * 
//	 * @return
//	 */
//	String getCodeName();
//
//	/**
//	 * 获取主查询对象
//	 * 
//	 * @return
//	 */
//	IPSDEDQMain getPSDEDQMain();
//
//	/**
//	 * 是否为自定义代码
//	 * 
//	 * @return
//	 */
//	boolean isCustomCode();

	/**
	 * 获取数据查询代码
	 * 
	 * @param strDBType
	 * @return
	 * @throws Exception
	 */
	IPSDEDataQueryCode getPSDEDataQueryCode(String strDBType) throws Exception;

	/**
	 * 获取全部查询代码
	 * 
	 * @return
	 */
	java.util.Iterator<IPSDEDataQueryCode> getAllPSDEDataQueryCodes() throws Exception;

	
//
//
//	/**
//	 * 获取逻辑名称
//	 * 
//	 * @return
//	 */
//	String getLogicName();
//	
//	/**
//	 * 获取是否默认发布服务接口
//	 * @return
//	 */
//	boolean isPubServiceDefault();
//	
//	
//	
//	/**
//	 * 获取RESTful接口设置
//	 * @return
//	 */
//	IPSRESTfulAPI getPSRESTfulAPI();
//	
//	
//	
//	/**
//	 * 获取实体查询全部连接集合
//	 * @return
//	 */
//	java.util.Iterator<IPSDEDQJoin> getAllPSDEDQJoins();
//	
//	
//	
//	
//	/**
//	 * 获取实体插件全部连接条件集合
//	 * @return
//	 */
//	java.util.Iterator<IPSDEDQCondition> getAllPSDEDQConditions();
//	
//	
//	
//	/**
//	 * 是否从视图查询
//	 * @return
//	 */
//	boolean isQueryFromView();
}
