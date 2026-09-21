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

import SA.SRFDA.PS.Core.Deploy.IPSDepSlnDBInst;
import SA.SRFDA.PS.Core.Deploy.PSDepSlnDBInstImpl;
import SA.SRFDA.PS.Core.Deploy.PSDepSlnGlobalModelBase;
import SA.SRFDA.PS.Data.PSDepSlnDBInst;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDepSlnDBInstGlobalModel
extends PSDepSlnGlobalModelBase<String, PSDepSlnDBInst, IPSDepSlnDBInst> {
    private static final Log log = LogFactory.getLog(PSDepSlnDBInstGlobalModel.class);

    @Override
    protected PSDepSlnDBInst GetObject(String strPSDepSlnDBInstId) {
        return null;
    }

    @Override
    protected IPSDepSlnDBInst OnCreateModelHelper(PSDepSlnDBInst vt) throws Exception {
        PSDepSlnDBInstImpl iPSDepSlnDBInst = new PSDepSlnDBInstImpl();
        iPSDepSlnDBInst.init(this.iDAGlobalHelper, this.getPSDepSln(), vt);
        return iPSDepSlnDBInst;
    }

    @Override
    protected Boolean TestObjectRenew(PSDepSlnDBInst obj) {
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
    protected IPSDepSlnDBInst registerModel(PSDepSlnDBInst vt) throws Exception {
        IPSDepSlnDBInst iPSDepSlnDBInst = (IPSDepSlnDBInst)this.InternalGetModelHelper(vt.getPSDEPSLNDBINSTID());
        if (iPSDepSlnDBInst != null) {
            return iPSDepSlnDBInst;
        }
        this.setModel(vt.getPSDEPSLNDBINSTID(), vt, null);
        return (IPSDepSlnDBInst)this.FindModelHelper(vt.getPSDEPSLNDBINSTID());
    }

    @Override
    protected Vector<PSDepSlnDBInst> getAllModels() throws Exception {
        Vector<PSDepSlnDBInst> list = new Vector<PSDepSlnDBInst>();
        CallResult callResult = this.iPSModelHelper.getAllPSDepSlnDBInsts(this.iPSDepSln.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u90e8\u7f72\u65b9\u6848\u5168\u90e8\u6570\u636e\u5e93\u5b9e\u4f8b\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSDepSlnDBInst vt) {
        return vt.getPSDEPSLNDBINSTID();
    }
}

