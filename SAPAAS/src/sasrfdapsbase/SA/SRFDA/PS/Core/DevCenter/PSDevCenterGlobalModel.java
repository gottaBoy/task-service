/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DevCenter;

import SA.SRFDA.PS.Core.DevCenter.IPSDevCenter;
import SA.SRFDA.PS.Core.DevCenter.PSDevCenterImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSDevCenter;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDevCenterGlobalModel
extends PSGlobalModelBase<String, PSDevCenter, IPSDevCenter> {
    private static final Log log = LogFactory.getLog(PSDevCenterGlobalModel.class);

    @Override
    protected PSDevCenter GetObject(String strPSDevCenterId) {
        PSDevCenter PSDevCenter2 = new PSDevCenter();
        CallResult callResult = this.iPSModelHelper.getPSDevCenter(strPSDevCenterId, PSDevCenter2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u4e2d\u5fc3[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDevCenterId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSDevCenter2;
    }

    @Override
    protected IPSDevCenter OnCreateModelHelper(PSDevCenter vt) throws Exception {
        PSDevCenterImpl iPSDevCenter = new PSDevCenterImpl();
        iPSDevCenter.init(this.iDAGlobalHelper, vt);
        return iPSDevCenter;
    }

    @Override
    protected Boolean TestObjectRenew(PSDevCenter obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSDevCenter vt) {
        return vt.getPSDEVCENTERID();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String[] remove(long nTime) {
        long nCurTime = System.currentTimeMillis();
        HashMap<String, IPSDevCenter> psDevCenterMap = new HashMap<String, IPSDevCenter>();
        HashMap hashMap = this.objMap;
        synchronized (hashMap) {
            for (Map.Entry entry : this.objHelperMap.entrySet()) {
                if (entry.getValue() == null || ((IPSDevCenter)entry.getValue()).getLastActiveTime() + nTime >= nCurTime) continue;
                psDevCenterMap.put((String)entry.getKey(), (IPSDevCenter)entry.getValue());
            }
        }
        int nCount = 0;
        String[] ids = null;
        if (psDevCenterMap.size() > 0) {
            ArrayList<String> list = new ArrayList<String>();
            for (Map.Entry entry : psDevCenterMap.entrySet()) {
                if (entry.getValue() == null || ((IPSDevCenter)entry.getValue()).getLastActiveTime() + nTime >= nCurTime) continue;
                this.ResetModel((String)entry.getKey());
                list.add((String)entry.getKey());
                ++nCount;
            }
            if (list.size() > 0) {
                ids = list.toArray(new String[list.size()]);
            }
        }
        if (nCount > 0) {
            HashMap hashMap2 = this.objMap;
            synchronized (hashMap2) {
                log.debug((Object)StringHelper.Format((String)"\u6e05\u9664\u5168\u5c40\u7a7a\u95f2\u5e94\u7528\u4e2d\u5fc3\u6a21\u578b[%1$s]\uff0c\u5f53\u524d\u6570\u91cf[%2$s]", (Object)nCount, (Object)this.objHelperMap.size()));
            }
        }
        return ids;
    }
}

