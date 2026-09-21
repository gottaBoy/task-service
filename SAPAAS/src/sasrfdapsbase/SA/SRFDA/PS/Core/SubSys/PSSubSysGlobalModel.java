/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.SubSys;

import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Core.SubSys.IPSSubSys;
import SA.SRFDA.PS.Core.SubSys.PSSubSysImpl;
import SA.SRFDA.PS.Data.PSSubSys;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSubSysGlobalModel
extends PSGlobalModelBase<String, PSSubSys, IPSSubSys> {
    private static final Log log = LogFactory.getLog(PSSubSysGlobalModel.class);

    @Override
    protected PSSubSys GetObject(String strPSSubSysId) {
        PSSubSys psSubSys = new PSSubSys();
        CallResult callResult = this.iPSModelHelper.getPSSubSys(strPSSubSysId, psSubSys);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b50\u7cfb\u7edf[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSubSysId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSubSys;
    }

    @Override
    protected IPSSubSys OnCreateModelHelper(PSSubSys vt) throws Exception {
        PSSubSysImpl iPSSubSys = new PSSubSysImpl();
        iPSSubSys.init(this.iDAGlobalHelper, vt);
        return iPSSubSys;
    }

    @Override
    protected Boolean TestObjectRenew(PSSubSys obj) {
        return false;
    }

    @Override
    protected IPSSubSys registerModel(PSSubSys vt) throws Exception {
        IPSSubSys iPSSubSys = (IPSSubSys)this.InternalGetModelHelper(vt.getPSSUBSYSID());
        if (iPSSubSys != null) {
            return iPSSubSys;
        }
        this.setModel(vt.getPSSUBSYSID(), vt, null);
        iPSSubSys = (IPSSubSys)this.FindModelHelper(vt.getPSSUBSYSID());
        if (!iPSSubSys.isLoadAll()) {
            iPSSubSys.loadAll();
        }
        return iPSSubSys;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSSubSys vt) {
        return vt.getPSSUBSYSID();
    }
}

