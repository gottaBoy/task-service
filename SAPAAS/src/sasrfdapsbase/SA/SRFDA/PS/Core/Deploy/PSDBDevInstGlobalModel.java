/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDBDevInst;
import SA.SRFDA.PS.Core.Deploy.PSDBDevInstImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSDBDevInst;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDBDevInstGlobalModel
extends PSGlobalModelBase<String, PSDBDevInst, IPSDBDevInst> {
    private static final Log log = LogFactory.getLog(PSDBDevInstGlobalModel.class);

    @Override
    protected PSDBDevInst GetObject(String strPSDBDevInstId) {
        PSDBDevInst psDBDevInst = new PSDBDevInst();
        CallResult callResult = this.iPSModelHelper.getPSDBDevInst(strPSDBDevInstId, psDBDevInst);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5f00\u53d1\u6570\u636e\u5e93\u5b9e\u4f8b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDBDevInstId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psDBDevInst;
    }

    @Override
    protected IPSDBDevInst OnCreateModelHelper(PSDBDevInst vt) throws Exception {
        PSDBDevInstImpl iPSDBDevInst = new PSDBDevInstImpl();
        iPSDBDevInst.init(this.iDAGlobalHelper, vt);
        return iPSDBDevInst;
    }

    @Override
    protected Boolean TestObjectRenew(PSDBDevInst obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSDBDevInst vt) {
        return vt.getPSDBDEVINSTID();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void close(long nTime) {
        long nCurTime = System.currentTimeMillis();
        HashMap<String, IPSDBDevInst> psDBDevInstMap = new HashMap<String, IPSDBDevInst>();
        HashMap hashMap = this.objMap;
        synchronized (hashMap) {
            for (Map.Entry entry : this.objHelperMap.entrySet()) {
                if (entry.getValue() == null || ((IPSDBDevInst)entry.getValue()).getLastActiveTime() + nTime >= nCurTime || ((IPSDBDevInst)entry.getValue()).isClose()) continue;
                psDBDevInstMap.put((String)entry.getKey(), (IPSDBDevInst)entry.getValue());
            }
        }
        int nCount = 0;
        for (Map.Entry entry : psDBDevInstMap.entrySet()) {
            if (entry.getValue() == null || ((IPSDBDevInst)entry.getValue()).getLastActiveTime() + nTime >= nCurTime || ((IPSDBDevInst)entry.getValue()).isClose()) continue;
            ((IPSDBDevInst)entry.getValue()).close();
        }
        if (nCount > 0) {
            HashMap hashMap2 = this.objMap;
            synchronized (hashMap2) {
                log.debug((Object)StringHelper.Format((String)"\u5173\u95ed\u5168\u5c40\u5f00\u53d1\u6570\u636e\u5e93\u7a7a\u95f2\u6a21\u578b[%1$s]\uff0c\u5f53\u524d\u6570\u91cf[%2$s]", (Object)nCount, (Object)this.objHelperMap.size()));
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void remove(long nTime) {
        long nCurTime = System.currentTimeMillis();
        HashMap<String, IPSDBDevInst> psDBDevInstMap = new HashMap<String, IPSDBDevInst>();
        HashMap hashMap = this.objMap;
        synchronized (hashMap) {
            for (Map.Entry entry : this.objHelperMap.entrySet()) {
                if (entry.getValue() == null || ((IPSDBDevInst)entry.getValue()).getLastActiveTime() + nTime >= nCurTime || !((IPSDBDevInst)entry.getValue()).isClose()) continue;
                psDBDevInstMap.put((String)entry.getKey(), (IPSDBDevInst)entry.getValue());
            }
        }
        int nCount = 0;
        for (Map.Entry entry : psDBDevInstMap.entrySet()) {
            if (entry.getValue() == null || ((IPSDBDevInst)entry.getValue()).getLastActiveTime() + nTime >= nCurTime) continue;
            this.ResetModel((String)entry.getKey());
            if (!((IPSDBDevInst)entry.getValue()).isClose()) {
                ((IPSDBDevInst)entry.getValue()).close();
            }
            ++nCount;
        }
        if (nCount > 0) {
            HashMap hashMap2 = this.objMap;
            synchronized (hashMap2) {
                log.debug((Object)StringHelper.Format((String)"\u6e05\u9664\u5168\u5c40\u5f00\u53d1\u6570\u636e\u5e93\u7a7a\u95f2\u6a21\u578b[%1$s]\uff0c\u5f53\u524d\u6570\u91cf[%2$s]", (Object)nCount, (Object)this.objHelperMap.size()));
            }
        }
    }

    public void active(String strPSDBDevInstId) {
        IPSDBDevInst iPSDBDevInst = (IPSDBDevInst)this.InternalGetModelHelper(strPSDBDevInstId);
        if (iPSDBDevInst != null) {
            iPSDBDevInst.active();
        }
    }

    @Override
    public void ResetModel(String objObjectId) {
        IPSDBDevInst iPSDBDevInst = (IPSDBDevInst)this.InternalGetModelHelper(objObjectId);
        super.ResetModel(objObjectId);
        if (iPSDBDevInst != null) {
            iPSDBDevInst.close();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void ResetAll() {
        HashMap hashMap = this.objMap;
        synchronized (hashMap) {
            for (Map.Entry entry : this.objHelperMap.entrySet()) {
                if (((IPSDBDevInst)entry.getValue()).isClose()) continue;
                ((IPSDBDevInst)entry.getValue()).close();
            }
        }
        super.ResetAll();
    }
}

