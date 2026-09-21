/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.security;

import java.util.HashMap;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.security.IUserPrivilegeMgr;
import net.ibizsys.paas.security.IUserRoleMgr;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UserPrivilegeMgr
implements IUserPrivilegeMgr {
    private static final Log log = LogFactory.getLog(UserPrivilegeMgr.class);
    public static final int MAXUNITCOUNT = 2000;
    protected HashMap<String, Boolean> resourceMap = new HashMap();
    protected HashMap<String, Integer> columnMap = new HashMap();
    protected HashMap<String, Integer> deDataCacheMap = new HashMap();

    @Override
    public void reset(IWebContext webContext) {
        this.reset();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void reset() {
        HashMap<String, Comparable<Boolean>> hashMap = this.resourceMap;
        synchronized (hashMap) {
            this.resourceMap.clear();
        }
        hashMap = this.columnMap;
        synchronized (hashMap) {
            this.columnMap.clear();
        }
        hashMap = this.deDataCacheMap;
        synchronized (hashMap) {
            this.deDataCacheMap.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean test(IWebContext webContext, String strResourceId) throws Exception {
        if (StringHelper.length(webContext.getCurUserId()) == 0) {
            return false;
        }
        strResourceId = strResourceId.toUpperCase();
        Boolean bRet = null;
        HashMap<String, Boolean> hashMap = this.resourceMap;
        synchronized (hashMap) {
            bRet = this.resourceMap.get(strResourceId);
        }
        if (bRet != null) {
            return bRet;
        }
        bRet = this.internalTest(webContext, strResourceId);
        hashMap = this.resourceMap;
        synchronized (hashMap) {
            if (this.resourceMap.size() >= 2000) {
                this.resourceMap.clear();
            }
            this.resourceMap.put(strResourceId, bRet);
        }
        return bRet;
    }

    protected boolean internalTest(IWebContext webContext, String strResourceId) throws Exception {
        if (StringHelper.compare("NONE", strResourceId, true) == 0) {
            return true;
        }
        if (webContext.isSuperUser()) {
            return true;
        }
        IUserRoleMgr iUserRoleMgr = webContext.getUserRoleMgr();
        String[] parts = strResourceId.split("[:]");
        if (parts.length == 1) {
            return iUserRoleMgr.testUserRoleUniRes("CUSTOM", strResourceId);
        }
        if (parts.length == 3) {
            String strResType = parts[0];
            if (StringHelper.compare(strResType, "DEDATA", true) == 0) {
                return iUserRoleMgr.testUserRoleDataAction(parts[1], null, parts[2]);
            }
            return false;
        }
        return false;
    }

    protected int internalTestDEField(IWebContext webContext, String strResourceId) throws Exception {
        if (webContext.isSuperUser()) {
            return 3;
        }
        IUserRoleMgr iUserRoleMgr = webContext.getUserRoleMgr();
        String[] parts = strResourceId.split("[|]");
        if (parts.length == 2) {
            return iUserRoleMgr.testUserRoleDEField(parts[0], parts[1]);
        }
        log.error((Object)StringHelper.format("\u65e0\u6cd5\u8bc6\u522b\u7684\u5b9e\u4f53\u5c5e\u6027\u8d44\u6e90\u6807\u8bc6[%1$s]", strResourceId));
        return 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int testDEField(IWebContext webContext, String strResourceId) throws Exception {
        if (StringHelper.isNullOrEmpty(strResourceId)) {
            return 3;
        }
        strResourceId = strResourceId.toUpperCase();
        Integer nRet = null;
        HashMap<String, Integer> hashMap = this.columnMap;
        synchronized (hashMap) {
            nRet = this.columnMap.get(strResourceId);
        }
        if (nRet != null) {
            return nRet;
        }
        nRet = this.internalTestDEField(webContext, strResourceId);
        hashMap = this.columnMap;
        synchronized (hashMap) {
            if (this.columnMap.size() >= 2000) {
                this.columnMap.clear();
            }
            this.columnMap.put(strResourceId, nRet);
        }
        return nRet;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public CallResult testDataAccessAction(IWebContext webContext, IDataEntityModel iDataEntityModel, Object objKey, String strDataAccessAction) throws Exception {
        if (StringHelper.isNullOrEmpty(strDataAccessAction) || StringHelper.compare(strDataAccessAction, "NONE", true) == 0) {
            return new CallResult();
        }
        if (StringHelper.compare(strDataAccessAction, "DENY", true) == 0) {
            CallResult callResult = new CallResult();
            callResult.setRetCode(2);
            return callResult;
        }
        String strKey = StringHelper.format("%1$s|%2$s|%3$s", iDataEntityModel.getName(), objKey, strDataAccessAction);
        Integer nRet = null;
        HashMap<String, Integer> hashMap = this.deDataCacheMap;
        synchronized (hashMap) {
            nRet = this.deDataCacheMap.get(strKey);
        }
        if (nRet != null) {
            CallResult callResult = new CallResult();
            callResult.setRetCode(nRet);
            return callResult;
        }
        CallResult callResult = iDataEntityModel.getDEDataAccMgr().test(webContext, objKey, strDataAccessAction);
        if (objKey == null || callResult != null && callResult.getUserObject() != null && StringHelper.compare(DataObject.getStringValue(callResult.getUserObject()), "CACHE", true) == 0) {
            hashMap = this.deDataCacheMap;
            synchronized (hashMap) {
                if (this.deDataCacheMap.size() >= 2000) {
                    this.deDataCacheMap.clear();
                }
                this.deDataCacheMap.put(strKey, callResult.getRetCode());
            }
        }
        return callResult;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public CallResult testDataAccessAction(IWebContext webContext, IDataEntityModel iDataEntityModel, IEntity iEntity, String strDataAccessAction) throws Exception {
        if (StringHelper.isNullOrEmpty(strDataAccessAction) || StringHelper.compare(strDataAccessAction, "NONE", true) == 0) {
            return new CallResult();
        }
        if (StringHelper.compare(strDataAccessAction, "DENY", true) == 0) {
            CallResult callResult = new CallResult();
            callResult.setRetCode(2);
            return callResult;
        }
        Object objKey = null;
        if (iEntity != null) {
            objKey = iEntity.get(iDataEntityModel.getKeyDEField().getName());
        }
        String strKey = null;
        if (objKey != null) {
            strKey = StringHelper.format("%1$s|%2$s|%3$s", iDataEntityModel.getName(), objKey, strDataAccessAction);
            Integer nRet = null;
            HashMap<String, Integer> hashMap = this.deDataCacheMap;
            synchronized (hashMap) {
                nRet = this.deDataCacheMap.get(strKey);
            }
            if (nRet != null) {
                CallResult callResult = new CallResult();
                callResult.setRetCode(nRet);
                return callResult;
            }
        }
        CallResult callResult = iDataEntityModel.getDEDataAccMgr().test(webContext, iEntity, strDataAccessAction);
        if (strKey != null && callResult != null && callResult.getUserObject() != null && StringHelper.compare(DataObject.getStringValue(callResult.getUserObject()), "CACHE", true) == 0) {
            HashMap<String, Integer> hashMap = this.deDataCacheMap;
            synchronized (hashMap) {
                if (this.deDataCacheMap.size() >= 2000) {
                    this.deDataCacheMap.clear();
                }
                this.deDataCacheMap.put(strKey, callResult.getRetCode());
            }
        }
        return callResult;
    }
}

