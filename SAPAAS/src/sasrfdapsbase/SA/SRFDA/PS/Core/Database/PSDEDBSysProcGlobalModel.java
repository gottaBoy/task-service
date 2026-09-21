/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.DataEntity.PSDataEntityGlobalModelBase;
import SA.SRFDA.PS.Core.Database.IPSDEDBSysProc;
import SA.SRFDA.PS.Core.Database.PSDEDBSysProcImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEDBSysProc;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDEDBSysProcGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEDBSysProc, IPSDEDBSysProc> {
    private static final Log log = LogFactory.getLog(PSDEDBSysProcGlobalModel.class);

    @Override
    protected PSDEDBSysProc GetObject(String strPSDEDBSysProcId) {
        PSDEDBSysProc psDEDBSysProc = new PSDEDBSysProc();
        CallResult callResult = this.iPSModelHelper.getPSDEDBSysProc(this.getPSDataEntity().getId(), strPSDEDBSysProcId, psDEDBSysProc);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5b9e\u4f53\u7cfb\u7edf\u5b58\u50a8\u8fc7\u7a0b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEDBSysProcId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psDEDBSysProc;
    }

    @Override
    protected IPSDEDBSysProc OnCreateModelHelper(PSDEDBSysProc vt) throws Exception {
        PSDEDBSysProcImpl iPSDEDBSysProc = new PSDEDBSysProcImpl();
        iPSDEDBSysProc.init(this.iDAGlobalHelper, this.getPSDataEntity(), vt);
        return iPSDEDBSysProc;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEDBSysProc obj) {
        return false;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        Vector<PSDEDBSysProc> psDEDBSysProcList = new Vector<PSDEDBSysProc>();
        CallResult callResult = this.iPSModelHelper.getPSDEDBSysProcs(this.getPSDataEntity().getId(), psDEDBSysProcList);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u7cfb\u7edf\u5b58\u50a8\u8fc7\u7a0b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return;
        }
        for (PSDEDBSysProc psDEDBSysProc : psDEDBSysProcList) {
            this.setModel(psDEDBSysProc.getPSDESYSPROCID(), psDEDBSysProc, null);
        }
    }

    @Override
    protected IPSDEDBSysProc registerModel(PSDEDBSysProc vt) throws Exception {
        return (IPSDEDBSysProc)this.FindModelHelper(vt.getPSDESYSPROCID(), vt);
    }

    @Override
    protected Vector<PSDEDBSysProc> getAllModels() throws Exception {
        Vector<PSDEDBSysProc> psDEDBSysProcList = new Vector<PSDEDBSysProc>();
        CallResult callResult = this.iPSModelHelper.getPSDEDBSysProcs(this.getPSDataEntity().getId(), psDEDBSysProcList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5168\u90e8\u7cfb\u7edf\u5b58\u50a8\u8fc7\u7a0b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEDBSysProcList;
    }

    @Override
    protected String getObjectId(PSDEDBSysProc vt) {
        return vt.getPSDESYSPROCID();
    }
}

