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

import SA.SRFDA.PS.Core.Deploy.IPSDepSlnSys;
import SA.SRFDA.PS.Core.Deploy.PSDepSlnGlobalModelBase;
import SA.SRFDA.PS.Core.Deploy.PSDepSlnSysImpl;
import SA.SRFDA.PS.Data.PSDepSlnSys;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDepSlnSysGlobalModel
extends PSDepSlnGlobalModelBase<String, PSDepSlnSys, IPSDepSlnSys> {
    private static final Log log = LogFactory.getLog(PSDepSlnSysGlobalModel.class);

    @Override
    protected PSDepSlnSys GetObject(String strPSDepSlnSysId) {
        return null;
    }

    @Override
    protected IPSDepSlnSys OnCreateModelHelper(PSDepSlnSys vt) throws Exception {
        PSDepSlnSysImpl iPSDepSlnSys = new PSDepSlnSysImpl();
        iPSDepSlnSys.init(this.iDAGlobalHelper, this.getPSDepSln(), vt);
        return iPSDepSlnSys;
    }

    @Override
    protected Boolean TestObjectRenew(PSDepSlnSys obj) {
        return false;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        try {
            this.getAllModelHelpers();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    protected IPSDepSlnSys registerModel(PSDepSlnSys vt) throws Exception {
        IPSDepSlnSys iPSDepSlnSys = (IPSDepSlnSys)this.InternalGetModelHelper(vt.getPSDEPSLNSYSID());
        if (iPSDepSlnSys != null) {
            return iPSDepSlnSys;
        }
        this.setModel(vt.getPSDEPSLNSYSID(), vt, null);
        return (IPSDepSlnSys)this.FindModelHelper(vt.getPSDEPSLNSYSID());
    }

    @Override
    protected Vector<PSDepSlnSys> getAllModels() throws Exception {
        Vector<PSDepSlnSys> list = new Vector<PSDepSlnSys>();
        CallResult callResult = this.iPSModelHelper.getAllPSDepSlnSyses(this.iPSDepSln.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u90e8\u7f72\u65b9\u6848\u5168\u90e8\u7cfb\u7edf\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSDepSlnSys vt) {
        return vt.getPSDEPSLNSYSID();
    }
}

