package net.ibizsys.paas.security;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.web.IWebContext;

/**
 * 数据访问管理对象接口
 * 
 * @author Administrator
 *
 */
public interface IDEDataAccMgr {
	/**
	 * 初始化数据访问辅助对象
	 * 
	 * @param iDEModel
	 */
	void init(IDataEntityModel iDEModel) throws Exception;

	/**
	 * 测试当前用户对指定数据的是否具备指定的操作能力
	 * 
	 * @param webContext
	 * @param objKey
	 * @param strAction
	 * @return
	 * @throws Exception
	 */
	CallResult test(IWebContext webContext, Object objKey, String strAction) throws Exception;

	/**
	 * 测试当前用户对指定数据的是否具备指定的操作能力
	 * 
	 * @param webContext
	 * @param dataEntity
	 * @param strAction
	 * @return
	 * @throws Exception
	 */
	CallResult test(IWebContext webContext, IEntity dataEntity, String strAction) throws Exception;

	/**
	 * 测试当前用户对指定数据的是否具备指定的操作能力
	 * 
	 * @param webContext
	 * @param objKey
	 * @param strAction
	 * @param bCache 在当前的上下文请求中缓存
	 * @return
	 * @throws Exception
	 */
	CallResult test(IWebContext webContext, Object objKey, String strAction, boolean bCache) throws Exception;

	/**
	 * 测试当前用户对指定数据的是否具备指定的操作能力
	 * 
	 * @param webContext
	 * @param dataEntity
	 * @param strAction
	 * @param bCache 在当前的上下文请求中缓存
	 * @return
	 * @throws Exception
	 */
	CallResult test(IWebContext webContext, IEntity dataEntity, String strAction, boolean bCache) throws Exception;

	/**
	 * 数据审计
	 * 
	 * @param strAuditInfo
	 * @param webContext
	 * @param dataEntity
	 * @param lastDataEntity
	 * @param strAction
	 * @throws Exception
	 */
	void audit(String strAuditInfo, IWebContext webContext, IEntity dataEntity, IEntity lastDataEntity, String strAction) throws Exception;

	/**
	 * 数据审计
	 * 
	 * @param strAuditInfo
	 * @param strOpPersonId
	 * @param strOpPersonName
	 * @param strFromIpAddress
	 * @param dataEntity
	 * @param lastDataEntity
	 * @param strAction
	 * @throws Exception
	 */
	void audit(String strAuditInfo, String strOpPersonId, String strOpPersonName, String strFromIpAddress, IEntity dataEntity, IEntity lastDataEntity, String strAction) throws Exception;

	// /**
	// * 获取实体定义的数据操作标识
	// * @return
	// */
	// String getDataActions();
	//
	//
	//
	// /**
	// * 查找数据的字段控制
	// * @param dataEntity
	// * @return
	// */
	// DEDSCtrl findFieldCtrl( IEntity dataEntity);
}
