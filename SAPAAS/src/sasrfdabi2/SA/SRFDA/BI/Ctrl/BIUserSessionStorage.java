/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.BI.Ctrl.IBICubeCache
 *  SA.SRFDA.BI.Ctrl.IBICubeHelper
 *  SA.SRFDA.BI.Ctrl.IBIUserSessionStorage
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.BICubeDB2Cache;
import SA.SRFDA.BI.Ctrl.IBICubeCache;
import SA.SRFDA.BI.Ctrl.IBICubeHelper;
import SA.SRFDA.BI.Ctrl.IBIUserSessionStorage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.Hashtable;

public class BIUserSessionStorage
implements IBIUserSessionStorage {
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    protected String strPersonId = null;
    protected Hashtable<String, IBICubeCache> biCubeCacheMap = new Hashtable();

    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, String strPersonId) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.strPersonId = strPersonId;
        this.OnInit();
    }

    protected void OnInit() throws Exception {
    }

    public IBICubeCache GetBICubeCache(IBICubeHelper iBICubeHelper, String strBIFilter, String strMode) throws Exception {
        String strBICubeCacheId = StringHelper.Format((String)"%1$s|%2$s|%3$s", (Object)iBICubeHelper.getId(), (Object)strBIFilter, (Object)strMode);
        if (this.biCubeCacheMap.containsKey(strBICubeCacheId)) {
            return this.biCubeCacheMap.get(strBICubeCacheId);
        }
        IBICubeCache iBICubeCache = this.OnCreateBICubeCache();
        iBICubeCache.Init(this.iDAGlobalHelper, iBICubeHelper, strBIFilter, strMode, this.strPersonId);
        this.biCubeCacheMap.put(strBICubeCacheId, iBICubeCache);
        return iBICubeCache;
    }

    protected IBICubeCache OnCreateBICubeCache() throws Exception {
        String strBICubeCache = this.iDAGlobalHelper.getWebExConfig().GetValue("SRFBI", "CUBECACHE", "");
        if (StringHelper.IsNullOrEmpty((String)strBICubeCache)) {
            return new BICubeDB2Cache();
        }
        Object objBICubeCache = ObjectHelper.Create((String)strBICubeCache);
        if (objBICubeCache == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u5206\u6790\u7acb\u65b9\u4f53\u7f13\u5b58\u5bf9\u8c61[%1$s]", (Object)strBICubeCache));
        }
        if (!(objBICubeCache instanceof IBICubeCache)) {
            throw new Exception(StringHelper.Format((String)"\u5206\u6790\u7acb\u65b9\u4f53\u7f13\u5b58\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strBICubeCache));
        }
        return (IBICubeCache)objBICubeCache;
    }
}

