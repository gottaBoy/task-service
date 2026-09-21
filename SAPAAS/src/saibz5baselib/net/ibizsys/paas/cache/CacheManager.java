/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.cache;

import java.util.concurrent.ConcurrentHashMap;
import net.ibizsys.paas.cache.ICacheItem;
import net.ibizsys.paas.cache.ICacheManager;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;

public class CacheManager
implements ICacheManager {
    public static final String PARAM_USERCACHEMANAGER = "SRFUSERCACHEMANAGER";
    private ConcurrentHashMap<String, CacheItem> cacheItemMap = new ConcurrentHashMap();
    private int nMaxItemCount = 20000;
    private int nDefaultTimeout = -1;
    private static final CacheManager globalCacheManager = new CacheManager();
    private static final ConcurrentHashMap<String, CacheManager> orgCacheManagerMap = new ConcurrentHashMap();

    public static ICacheManager getInstance(int nCacheScope) throws Exception {
        switch (nCacheScope) {
            case 1: {
                return globalCacheManager;
            }
            case 2: {
                String strOrgId = null;
                if (WebContext.getCurrent() != null) {
                    strOrgId = WebContext.getCurrent().getCurOrgId();
                }
                if (!StringHelper.isNullOrEmpty(strOrgId)) {
                    CacheManager orgCacheManager = orgCacheManagerMap.get(strOrgId);
                    if (orgCacheManager == null) {
                        orgCacheManager = new CacheManager();
                        orgCacheManagerMap.put(strOrgId, orgCacheManager);
                    }
                    return orgCacheManager;
                }
                throw new Exception("\u65e0\u6cd5\u8ba1\u7b97\u5f53\u524d\u7ec4\u7ec7\u673a\u6784\u6807\u8bc6");
            }
            case 3: {
                IWebContext iWebContext = WebContext.getCurrent();
                if (iWebContext != null) {
                    return CacheManager.getUserCacheManager(iWebContext);
                }
                throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u5f53\u524d\u7528\u6237\u4e0a\u4e0b\u6587\u8bbf\u95ee\u5bf9\u8c61");
            }
        }
        throw new Exception(StringHelper.format("\u65e0\u6cd5\u8bc6\u522b\u7684\u7f13\u5b58\u8303\u56f4\u503c[%1$s]", nCacheScope));
    }

    public static ICacheManager getUserCacheManager(IWebContext iWebContext) throws Exception {
        Object objCacheManager = iWebContext.getSessionValue(PARAM_USERCACHEMANAGER, false);
        if (objCacheManager == null) {
            objCacheManager = new CacheManager();
            iWebContext.setSessionValue(PARAM_USERCACHEMANAGER, objCacheManager, false);
        }
        return (ICacheManager)objCacheManager;
    }

    public static void reset(int nCacheScope) throws Exception {
        CacheManager.reset(nCacheScope, null);
    }

    public static void reset(int nCacheScope, String strCacheScopeTag) throws Exception {
        switch (nCacheScope) {
            case 1: {
                globalCacheManager.removeAll();
                return;
            }
            case 2: {
                if (!StringHelper.isNullOrEmpty(strCacheScopeTag)) {
                    orgCacheManagerMap.remove(strCacheScopeTag);
                } else {
                    orgCacheManagerMap.clear();
                }
            }
            case 3: {
                IWebContext iWebContext = WebContext.getCurrent();
                if (iWebContext != null) {
                    CacheManager.getUserCacheManager(iWebContext).removeAll();
                }
                throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u5f53\u524d\u7528\u6237\u4e0a\u4e0b\u6587\u8bbf\u95ee\u5bf9\u8c61");
            }
        }
        throw new Exception(StringHelper.format("\u65e0\u6cd5\u8bc6\u522b\u7684\u7f13\u5b58\u8303\u56f4\u503c[%1$s]", nCacheScope));
    }

    @Override
    public Object getData(String strCacheTag, Object objState) throws Exception {
        CacheItem cacheItem = this.cacheItemMap.get(strCacheTag);
        if (cacheItem != null) {
            if ((cacheItem.getExpiredTime() == -1L || cacheItem.getExpiredTime() >= System.currentTimeMillis()) && this.testState(cacheItem.getState(), objState)) {
                return cacheItem.getData();
            }
            return null;
        }
        return null;
    }

    @Override
    public ICacheItem updateData(String strCacheTag, Object objState, Object objData) throws Exception {
        return this.updateData(strCacheTag, objState, objData, this.getDefaultTimeout());
    }

    @Override
    public ICacheItem updateData(String strCacheTag, Object objState, Object objData, long nTimeout) throws Exception {
        CacheItem cacheItem = this.cacheItemMap.get(strCacheTag);
        boolean bNew = false;
        if (cacheItem == null) {
            cacheItem = new CacheItem();
            cacheItem.setUniqueTag(strCacheTag);
            bNew = true;
        }
        cacheItem.setData(objData);
        cacheItem.setState(objState);
        if (nTimeout > 0L) {
            cacheItem.setExpiredTime(System.currentTimeMillis() + nTimeout);
        } else {
            cacheItem.setExpiredTime(-1L);
        }
        if (bNew) {
            if (this.cacheItemMap.size() > this.nMaxItemCount) {
                this.cacheItemMap.clear();
            }
            this.cacheItemMap.put(strCacheTag, cacheItem);
        }
        return cacheItem;
    }

    @Override
    public ICacheItem removeData(String strCacheTag) throws Exception {
        return this.cacheItemMap.remove(strCacheTag);
    }

    @Override
    public ICacheItem getCacheItem(String strCacheTag) {
        return this.cacheItemMap.get(strCacheTag);
    }

    protected boolean testState(Object objState, Object objState2) {
        if (objState == null && objState2 == null) {
            return true;
        }
        if (objState == null || objState2 == null) {
            return false;
        }
        return objState.equals(objState2);
    }

    public void setMaxItemCount(int nMaxItemCount) {
        this.nMaxItemCount = nMaxItemCount;
    }

    public void setDefaultTimeout(int nDefaultTimeout) {
        this.nDefaultTimeout = nDefaultTimeout;
    }

    public int getMaxItemCount() {
        return this.nMaxItemCount;
    }

    public int getDefaultTimeout() {
        return this.nDefaultTimeout;
    }

    @Override
    public void removeAll() {
        this.cacheItemMap.clear();
    }

    protected class CacheItem
    implements ICacheItem {
        private Object objData = null;
        private long nExpiredTime = -1L;
        private String strUniqueTag = null;
        private Object objState = null;

        protected CacheItem() {
        }

        @Override
        public Object getData() {
            return this.objData;
        }

        @Override
        public long getExpiredTime() {
            return this.nExpiredTime;
        }

        @Override
        public String getUniqueTag() {
            return this.strUniqueTag;
        }

        @Override
        public Object getState() {
            return this.objState;
        }

        public void setData(Object objData) {
            this.objData = objData;
        }

        public void setExpiredTime(long nExpiredTime) {
            this.nExpiredTime = nExpiredTime;
        }

        public void setUniqueTag(String strUniqueTag) {
            this.strUniqueTag = strUniqueTag;
        }

        public void setState(Object objState) {
            this.objState = objState;
        }
    }
}

