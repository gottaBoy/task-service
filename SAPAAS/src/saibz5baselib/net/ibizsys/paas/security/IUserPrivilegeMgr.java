package net.ibizsys.paas.security;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.web.IWebContext;

/**
 * 用户权限管理器接口
 * 
 * @author Administrator
 *
 */
public interface IUserPrivilegeMgr extends java.io.Serializable {
	/**
	 * 对测试结果进行缓冲
	 */
	final static String TESTRESULT_CACHE = "CACHE";

	/**
	 * 重置用户的权限
	 * 
	 * @param webContext
	 */
	void reset(IWebContext webContext);

	/**
	 * 重置用户的权限
	 * 
	 * @param webContext
	 */
	void reset();

	/**
	 * 测试对指定资源是否具备能力
	 * 
	 * @param webContext 网页上下文对象
	 * @param strResourceId 资源编号
	 * @return
	 */
	boolean test(IWebContext webContext, String strResourceId) throws Exception;

	/**
	 * 测试属性权限
	 * 
	 * @param webContext
	 * @param strResourceId
	 * @return
	 * @throws Exception
	 */
	int testDEField(IWebContext webContext, String strResourceId) throws Exception;

	/**
	 * 测试数据权限
	 * 
	 * @param webContext
	 * @param iDEModel
	 * @param iEntity
	 * @param strDataAccessAction
	 * @return
	 * @throws Exception
	 */
	CallResult testDataAccessAction(IWebContext webContext, IDataEntityModel iDEModel, IEntity iEntity, String strDataAccessAction) throws Exception;

	/**
	 * 测试数据权限
	 * 
	 * @param webContext
	 * @param iDEModel
	 * @param objKey
	 * @param strDataAccessAction
	 * @return
	 * @throws Exception
	 */
	CallResult testDataAccessAction(IWebContext webContext, IDataEntityModel iDEModel, Object objKey, String strDataAccessAction) throws Exception;

}
