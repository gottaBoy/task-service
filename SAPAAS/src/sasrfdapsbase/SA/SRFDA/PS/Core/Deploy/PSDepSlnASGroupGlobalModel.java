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

import SA.SRFDA.PS.Core.Deploy.IPSDepSlnASGroup;
import SA.SRFDA.PS.Core.Deploy.PSDepSlnASGroupImpl;
import SA.SRFDA.PS.Core.Deploy.PSDepSlnGlobalModelBase;
import SA.SRFDA.PS.Data.PSDepSlnASGrp;
import SA.SRFDA.PS.Data.PSDepSlnASItem;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDepSlnASGroupGlobalModel
extends PSDepSlnGlobalModelBase<String, PSDepSlnASGrp, IPSDepSlnASGroup> {
    private static final Log log = LogFactory.getLog(PSDepSlnASGroupGlobalModel.class);

    @Override
    protected PSDepSlnASGrp GetObject(String strPSDepSlnASId) {
        return null;
    }

    @Override
    protected IPSDepSlnASGroup OnCreateModelHelper(PSDepSlnASGrp vt) throws Exception {
        PSDepSlnASGroupImpl iPSDepSlnASGroup = new PSDepSlnASGroupImpl();
        iPSDepSlnASGroup.init(this.iDAGlobalHelper, this.getPSDepSln(), vt);
        return iPSDepSlnASGroup;
    }

    @Override
    protected Boolean TestObjectRenew(PSDepSlnASGrp obj) {
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
    protected IPSDepSlnASGroup registerModel(PSDepSlnASGrp vt) throws Exception {
        IPSDepSlnASGroup iPSDepSlnASGrp = (IPSDepSlnASGroup)this.InternalGetModelHelper(vt.getPSDEPSLNASGRPID());
        if (iPSDepSlnASGrp != null) {
            return iPSDepSlnASGrp;
        }
        this.setModel(vt.getPSDEPSLNASGRPID(), vt, null);
        return (IPSDepSlnASGroup)this.FindModelHelper(vt.getPSDEPSLNASGRPID());
    }

    @Override
    protected Vector<PSDepSlnASGrp> getAllModels() throws Exception {
        Vector<PSDepSlnASGrp> list = new Vector<PSDepSlnASGrp>();
        CallResult callResult = this.iPSModelHelper.getAllPSDepSlnASGroups(this.iPSDepSln.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u90e8\u7f72\u65b9\u6848\u5168\u90e8\u5e94\u7528\u5bb9\u5668\u7ec4\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        Vector<PSDepSlnASItem> list2 = new Vector<PSDepSlnASItem>();
        callResult = this.iPSModelHelper.getAllPSDepSlnASGroupItems(this.iPSDepSln.getId(), list2);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u90e8\u7f72\u65b9\u6848\u5168\u90e8\u5e94\u7528\u5bb9\u5668\u6210\u5458\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSDepSlnASGrp> psDepSlnASGrpMap = new HashMap<String, PSDepSlnASGrp>();
        for (PSDepSlnASGrp psDepSlnASGrp : list) {
            psDepSlnASGrpMap.put(psDepSlnASGrp.getPSDEPSLNASGRPID(), psDepSlnASGrp);
        }
        for (PSDepSlnASItem psDepSlnASItem : list2) {
            PSDepSlnASGrp psDepSlnASGrp = (PSDepSlnASGrp)((Object)psDepSlnASGrpMap.get(psDepSlnASItem.getPSDEPSLNASGRPID()));
            if (psDepSlnASGrp == null) continue;
            psDepSlnASGrp.getPSDepSlnASItems(true).add(psDepSlnASItem);
        }
        return list;
    }

    @Override
    protected String getObjectId(PSDepSlnASGrp vt) {
        return vt.getPSDEPSLNASGRPID();
    }
}

