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

import SA.SRFDA.PS.Core.Deploy.IPSDepSlnAS;
import SA.SRFDA.PS.Core.Deploy.PSDepSlnASImpl;
import SA.SRFDA.PS.Core.Deploy.PSDepSlnGlobalModelBase;
import SA.SRFDA.PS.Data.PSDepSlnAS;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDepSlnASGlobalModel
extends PSDepSlnGlobalModelBase<String, PSDepSlnAS, IPSDepSlnAS> {
    private static final Log log = LogFactory.getLog(PSDepSlnASGlobalModel.class);

    @Override
    protected PSDepSlnAS GetObject(String strPSDepSlnASId) {
        return null;
    }

    @Override
    protected IPSDepSlnAS OnCreateModelHelper(PSDepSlnAS vt) throws Exception {
        PSDepSlnASImpl iPSDepSlnAS = new PSDepSlnASImpl();
        iPSDepSlnAS.init(this.iDAGlobalHelper, this.getPSDepSln(), vt);
        return iPSDepSlnAS;
    }

    @Override
    protected Boolean TestObjectRenew(PSDepSlnAS obj) {
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
    protected IPSDepSlnAS registerModel(PSDepSlnAS vt) throws Exception {
        IPSDepSlnAS iPSDepSlnAS = (IPSDepSlnAS)this.InternalGetModelHelper(vt.getPSDEPSLNASID());
        if (iPSDepSlnAS != null) {
            return iPSDepSlnAS;
        }
        this.setModel(vt.getPSDEPSLNASID(), vt, null);
        return (IPSDepSlnAS)this.FindModelHelper(vt.getPSDEPSLNASID());
    }

    @Override
    protected Vector<PSDepSlnAS> getAllModels() throws Exception {
        Vector<PSDepSlnAS> list = new Vector<PSDepSlnAS>();
        CallResult callResult = this.iPSModelHelper.getAllPSDepSlnASes(this.iPSDepSln.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u90e8\u7f72\u65b9\u6848\u5168\u90e8\u5e94\u7528\u5bb9\u5668\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSDepSlnAS vt) {
        return vt.getPSDEPSLNASID();
    }
}

