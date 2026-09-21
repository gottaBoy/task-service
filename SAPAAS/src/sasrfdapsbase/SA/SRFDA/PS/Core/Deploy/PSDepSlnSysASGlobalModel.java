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

import SA.SRFDA.PS.Core.Deploy.IPSDepSlnSysAS;
import SA.SRFDA.PS.Core.Deploy.PSDepSlnGlobalModelBase;
import SA.SRFDA.PS.Core.Deploy.PSDepSlnSysASImpl;
import SA.SRFDA.PS.Data.PSDepSlnSysAS;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDepSlnSysASGlobalModel
extends PSDepSlnGlobalModelBase<String, PSDepSlnSysAS, IPSDepSlnSysAS> {
    private static final Log log = LogFactory.getLog(PSDepSlnSysASGlobalModel.class);

    @Override
    protected PSDepSlnSysAS GetObject(String strPSDepSlnSysASId) {
        return null;
    }

    @Override
    protected IPSDepSlnSysAS OnCreateModelHelper(PSDepSlnSysAS vt) throws Exception {
        PSDepSlnSysASImpl iPSDepSlnSysAS = new PSDepSlnSysASImpl();
        iPSDepSlnSysAS.init(this.iDAGlobalHelper, this.getPSDepSln(), vt);
        return iPSDepSlnSysAS;
    }

    @Override
    protected Boolean TestObjectRenew(PSDepSlnSysAS obj) {
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
    protected IPSDepSlnSysAS registerModel(PSDepSlnSysAS vt) throws Exception {
        IPSDepSlnSysAS iPSDepSlnSysAS = (IPSDepSlnSysAS)this.InternalGetModelHelper(vt.getPSDEPSLNSYSASID());
        if (iPSDepSlnSysAS != null) {
            return iPSDepSlnSysAS;
        }
        this.setModel(vt.getPSDEPSLNSYSASID(), vt, null);
        return (IPSDepSlnSysAS)this.FindModelHelper(vt.getPSDEPSLNSYSASID());
    }

    @Override
    protected Vector<PSDepSlnSysAS> getAllModels() throws Exception {
        Vector<PSDepSlnSysAS> list = new Vector<PSDepSlnSysAS>();
        CallResult callResult = this.iPSModelHelper.getAllPSDepSlnSysASes(this.iPSDepSln.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u90e8\u7f72\u65b9\u6848\u5168\u90e8\u7cfb\u7edf\u5e94\u7528\u90e8\u7f72\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSDepSlnSysAS vt) {
        return vt.getPSDEPSLNSYSASID();
    }
}

