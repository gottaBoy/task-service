package net.ibizsys.paas.security;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;

/**
 * 用户权限管理对象实现
 * 
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class UserPrivilegeMgr implements IUserPrivilegeMgr {
	private static final Log log = LogFactory.getLog(UserPrivilegeMgr.class);

	public final static int MAXUNITCOUNT = 2000;

	protected HashMap<String, Boolean> resourceMap = new HashMap<String, Boolean>();

	protected HashMap<String, Integer> columnMap = new HashMap<String, Integer>();

	protected HashMap<String, Integer> deDataCacheMap = new HashMap<String, Integer>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.security.IUserPrivilegeMgr#reset(net.ibizsys.paas.web.IWebContext)
	 */
	@Override
	public void reset(IWebContext webContext) {
		reset();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.security.IUserPrivilegeMgr#reset(net.ibizsys.paas.web.IWebContext)
	 */
	@Override
	public void reset() {
		synchronized (resourceMap) {
			resourceMap.clear();
		}

		synchronized (columnMap) {
			columnMap.clear();
		}

		synchronized (deDataCacheMap) {
			deDataCacheMap.clear();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.security.IUserPrivilegeMgr#test(net.ibizsys.paas.web.IWebContext, java.lang.String)
	 */
	@Override
	public boolean test(IWebContext webContext, String strResourceId) throws Exception {
		if (StringHelper.length(webContext.getCurUserId()) == 0) return false;

		strResourceId = strResourceId.toUpperCase();
		// 判断是否允许的列表中
		Boolean bRet = null;
		synchronized (resourceMap) {
			bRet = resourceMap.get(strResourceId);
		}
		if (bRet != null) return bRet;

		bRet = internalTest(webContext, strResourceId);
		synchronized (resourceMap) {
			if (resourceMap.size() >= MAXUNITCOUNT) {
				resourceMap.clear();
			}
			resourceMap.put(strResourceId, bRet);
		}
		return bRet;
	}

	/**
	 * 判断是否允许访问指定资源
	 * 
	 * @param webContext
	 * @param strResourceId
	 * @return
	 * @throws Exception
	 */
	protected boolean internalTest(IWebContext webContext, String strResourceId) throws Exception {
		if (StringHelper.compare(UniResTypes.NONE, strResourceId, true) == 0) return true;

		if (webContext.isSuperUser()) return true;

		IUserRoleMgr iUserRoleMgr = webContext.getUserRoleMgr();

		String[] parts = strResourceId.split("[:]");
		if (parts.length == 1) {
			// 常规资源编号
			return iUserRoleMgr.testUserRoleUniRes(UniResTypes.CUSTOM, strResourceId);
		}

		if (parts.length == 3) {
			String strResType = parts[0];
			if (StringHelper.compare(strResType, UniResTypes.DEDATA, true) == 0) {
				return iUserRoleMgr.testUserRoleDataAction(parts[1], null, parts[2]);
			}
			return false;
		}

		return false;
	}

	/**
	 * 判断访问实体字段能力
	 * 
	 * @param webContext
	 * @param strResourceId
	 * @return
	 * @throws Exception
	 */
	protected int internalTestDEField(IWebContext webContext, String strResourceId) throws Exception {
		if (webContext.isSuperUser()) return PrivilegeAbilities.UPDATE;

		IUserRoleMgr iUserRoleMgr = webContext.getUserRoleMgr();

		String[] parts = strResourceId.split("[|]");
		if (parts.length == 2) {
			return iUserRoleMgr.testUserRoleDEField(parts[0], parts[1]);
		}
		log.error(StringHelper.format("无法识别的实体属性资源标识[%1$s]", strResourceId));
		return PrivilegeAbilities.NONE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.security.IUserPrivilegeMgr#testDEField(net.ibizsys.paas.web.IWebContext, java.lang.String)
	 */
	@Override
	public int testDEField(IWebContext webContext, String strResourceId) throws Exception {
		if (StringHelper.isNullOrEmpty(strResourceId)) return PrivilegeAbilities.UPDATE;

		// String strOriginResourceId = strResourceId;
		strResourceId = strResourceId.toUpperCase();
		// 判断是否允许的列表中
		Integer nRet = null;
		synchronized (columnMap) {
			nRet = columnMap.get(strResourceId);
		}
		if (nRet != null) return nRet;

		nRet = internalTestDEField(webContext, strResourceId);
		synchronized (columnMap) {
			if (columnMap.size() >= MAXUNITCOUNT) {
				columnMap.clear();
			}
			columnMap.put(strResourceId, nRet);
		}

		return nRet;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.security.IUserPrivilegeMgr#testDataAccessAction(net.ibizsys.paas.web.IWebContext, net.ibizsys.paas.demodel.IDataEntityModel, java.lang.Object, java.lang.String)
	 */
	@Override
	public CallResult testDataAccessAction(IWebContext webContext, IDataEntityModel iDataEntityModel, Object objKey, String strDataAccessAction) throws Exception {
		if (StringHelper.isNullOrEmpty(strDataAccessAction) || (StringHelper.compare(strDataAccessAction, DataAccessActions.NONE, true) == 0)){
			return new CallResult();
		}
		
		if (StringHelper.compare(strDataAccessAction, DataAccessActions.DENY, true) == 0){
			CallResult callResult = new CallResult();
			callResult.setRetCode(Errors.ACCESSDENY);
			return callResult;
		}

		CallResult callResult;
		String strKey = StringHelper.format("%1$s|%2$s|%3$s", iDataEntityModel.getName(), objKey, strDataAccessAction);
		Integer nRet = null;
		synchronized (deDataCacheMap) {
			nRet = deDataCacheMap.get(strKey);
		}
		if (nRet != null) {
			callResult = new CallResult();
			callResult.setRetCode(nRet);
			return callResult;
		}

		callResult = iDataEntityModel.getDEDataAccMgr().test(webContext, objKey, strDataAccessAction);
		if (objKey == null || (callResult != null && callResult.getUserObject() != null && StringHelper.compare(DataObject.getStringValue(callResult.getUserObject()), TESTRESULT_CACHE, true) == 0)) {
			synchronized (deDataCacheMap) {
				if (deDataCacheMap.size() >= MAXUNITCOUNT) {
					deDataCacheMap.clear();
				}
				deDataCacheMap.put(strKey, callResult.getRetCode());
			}

		}
		return callResult;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.security.IUserPrivilegeMgr#testDataAccessAction(net.ibizsys.paas.web.IWebContext, net.ibizsys.paas.demodel.IDataEntityModel, net.ibizsys.paas.entity.IEntity, java.lang.String)
	 */
	@Override
	public CallResult testDataAccessAction(IWebContext webContext, IDataEntityModel iDataEntityModel, IEntity iEntity, String strDataAccessAction) throws Exception {
		if (StringHelper.isNullOrEmpty(strDataAccessAction) || (StringHelper.compare(strDataAccessAction, DataAccessActions.NONE, true) == 0)){
			return new CallResult();
		}
		
		if (StringHelper.compare(strDataAccessAction, DataAccessActions.DENY, true) == 0){
			CallResult callResult = new CallResult();
			callResult.setRetCode(Errors.ACCESSDENY);
			return callResult;
		}

		CallResult callResult;
		Object objKey = null;
		if (iEntity != null) {
			objKey = iEntity.get(iDataEntityModel.getKeyDEField().getName());
		}

		String strKey = null;
		if (objKey != null) {
			strKey = StringHelper.format("%1$s|%2$s|%3$s", iDataEntityModel.getName(), objKey, strDataAccessAction);
			Integer nRet = null;
			synchronized (deDataCacheMap) {
				nRet = deDataCacheMap.get(strKey);
			}
			if (nRet != null) {
				callResult = new CallResult();
				callResult.setRetCode(nRet);
				return callResult;
			}
		}

		callResult = iDataEntityModel.getDEDataAccMgr().test(webContext, iEntity, strDataAccessAction);

		if (strKey != null && callResult != null && callResult.getUserObject() != null && StringHelper.compare(DataObject.getStringValue(callResult.getUserObject()), TESTRESULT_CACHE, true) == 0) {
			synchronized (deDataCacheMap) {
				if (deDataCacheMap.size() >= MAXUNITCOUNT) {
					deDataCacheMap.clear();
				}
				deDataCacheMap.put(strKey, callResult.getRetCode());
			}
		}

		return callResult;
	}

}
