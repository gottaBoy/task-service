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

import SA.SRFDA.PS.Core.Deploy.IPSDepSlnMQInst;
import SA.SRFDA.PS.Core.Deploy.PSDepSlnGlobalModelBase;
import SA.SRFDA.PS.Core.Deploy.PSDepSlnMQInstImpl;
import SA.SRFDA.PS.Data.PSDepSlnMQInst;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDepSlnMQInstGlobalModel
extends PSDepSlnGlobalModelBase<String, PSDepSlnMQInst, IPSDepSlnMQInst> {
    private static final Log log = LogFactory.getLog(PSDepSlnMQInstGlobalModel.class);

    @Override
    protected PSDepSlnMQInst GetObject(String strPSDepSlnMQInstId) {
        return null;
    }

    @Override
    protected IPSDepSlnMQInst OnCreateModelHelper(PSDepSlnMQInst vt) throws Exception {
        PSDepSlnMQInstImpl iPSDepSlnMQInst = new PSDepSlnMQInstImpl();
        iPSDepSlnMQInst.init(this.iDAGlobalHelper, this.getPSDepSln(), vt);
        return iPSDepSlnMQInst;
    }

    @Override
    protected Boolean TestObjectRenew(PSDepSlnMQInst obj) {
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
    protected IPSDepSlnMQInst registerModel(PSDepSlnMQInst vt) throws Exception {
        IPSDepSlnMQInst iPSDepSlnMQInst = (IPSDepSlnMQInst)this.InternalGetModelHelper(vt.getPSDEPSLNMQINSTID());
        if (iPSDepSlnMQInst != null) {
            return iPSDepSlnMQInst;
        }
        this.setModel(vt.getPSDEPSLNMQINSTID(), vt, null);
        return (IPSDepSlnMQInst)this.FindModelHelper(vt.getPSDEPSLNMQINSTID());
    }

    @Override
    protected Vector<PSDepSlnMQInst> getAllModels() throws Exception {
        Vector<PSDepSlnMQInst> list = new Vector<PSDepSlnMQInst>();
        CallResult callResult = this.iPSModelHelper.getAllPSDepSlnMQInsts(this.iPSDepSln.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u90e8\u7f72\u65b9\u6848\u5168\u90e8MQ\u5b9e\u4f8b\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSDepSlnMQInst vt) {
        return vt.getPSDEPSLNMQINSTID();
    }
}

