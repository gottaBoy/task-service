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

import SA.SRFDA.PS.Core.Deploy.IPSDepSlnHost;
import SA.SRFDA.PS.Core.Deploy.PSDepSlnGlobalModelBase;
import SA.SRFDA.PS.Core.Deploy.PSDepSlnHostImpl;
import SA.SRFDA.PS.Data.PSDepSlnHost;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDepSlnHostGlobalModel
extends PSDepSlnGlobalModelBase<String, PSDepSlnHost, IPSDepSlnHost> {
    private static final Log log = LogFactory.getLog(PSDepSlnHostGlobalModel.class);

    @Override
    protected PSDepSlnHost GetObject(String strPSDepSlnHostId) {
        return null;
    }

    @Override
    protected IPSDepSlnHost OnCreateModelHelper(PSDepSlnHost vt) throws Exception {
        PSDepSlnHostImpl iPSDepSlnHost = new PSDepSlnHostImpl();
        iPSDepSlnHost.init(this.iDAGlobalHelper, this.getPSDepSln(), vt);
        return iPSDepSlnHost;
    }

    @Override
    protected Boolean TestObjectRenew(PSDepSlnHost obj) {
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
    protected IPSDepSlnHost registerModel(PSDepSlnHost vt) throws Exception {
        IPSDepSlnHost iPSDepSlnHost = (IPSDepSlnHost)this.InternalGetModelHelper(vt.getPSDEPSLNHOSTID());
        if (iPSDepSlnHost != null) {
            return iPSDepSlnHost;
        }
        this.setModel(vt.getPSDEPSLNHOSTID(), vt, null);
        return (IPSDepSlnHost)this.FindModelHelper(vt.getPSDEPSLNHOSTID());
    }

    @Override
    protected Vector<PSDepSlnHost> getAllModels() throws Exception {
        Vector<PSDepSlnHost> list = new Vector<PSDepSlnHost>();
        CallResult callResult = this.iPSModelHelper.getAllPSDepSlnHosts(this.iPSDepSln.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u90e8\u7f72\u65b9\u6848\u5168\u90e8\u4e3b\u673a\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSDepSlnHost vt) {
        return vt.getPSDEPSLNHOSTID();
    }
}

