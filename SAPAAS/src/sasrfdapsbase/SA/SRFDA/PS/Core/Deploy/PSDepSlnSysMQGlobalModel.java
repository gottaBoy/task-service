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

import SA.SRFDA.PS.Core.Deploy.IPSDepSlnSysMQ;
import SA.SRFDA.PS.Core.Deploy.PSDepSlnGlobalModelBase;
import SA.SRFDA.PS.Core.Deploy.PSDepSlnSysMQImpl;
import SA.SRFDA.PS.Data.PSDepSlnSysMQ;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDepSlnSysMQGlobalModel
extends PSDepSlnGlobalModelBase<String, PSDepSlnSysMQ, IPSDepSlnSysMQ> {
    private static final Log log = LogFactory.getLog(PSDepSlnSysMQGlobalModel.class);

    @Override
    protected PSDepSlnSysMQ GetObject(String strPSDepSlnSysMQId) {
        return null;
    }

    @Override
    protected IPSDepSlnSysMQ OnCreateModelHelper(PSDepSlnSysMQ vt) throws Exception {
        PSDepSlnSysMQImpl iPSDepSlnSysMQ = new PSDepSlnSysMQImpl();
        iPSDepSlnSysMQ.init(this.iDAGlobalHelper, this.getPSDepSln(), vt);
        return iPSDepSlnSysMQ;
    }

    @Override
    protected Boolean TestObjectRenew(PSDepSlnSysMQ obj) {
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
    protected IPSDepSlnSysMQ registerModel(PSDepSlnSysMQ vt) throws Exception {
        IPSDepSlnSysMQ iPSDepSlnSysMQ = (IPSDepSlnSysMQ)this.InternalGetModelHelper(vt.getPSDEPSLNSYSMQID());
        if (iPSDepSlnSysMQ != null) {
            return iPSDepSlnSysMQ;
        }
        this.setModel(vt.getPSDEPSLNSYSMQID(), vt, null);
        return (IPSDepSlnSysMQ)this.FindModelHelper(vt.getPSDEPSLNSYSMQID());
    }

    @Override
    protected Vector<PSDepSlnSysMQ> getAllModels() throws Exception {
        Vector<PSDepSlnSysMQ> list = new Vector<PSDepSlnSysMQ>();
        CallResult callResult = this.iPSModelHelper.getAllPSDepSlnSysMQs(this.iPSDepSln.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u90e8\u7f72\u65b9\u6848\u5168\u90e8\u7cfb\u7edfMQ\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSDepSlnSysMQ vt) {
        return vt.getPSDEPSLNSYSMQID();
    }
}

