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

import SA.SRFDA.PS.Core.Deploy.IPSDepSlnSysDB;
import SA.SRFDA.PS.Core.Deploy.PSDepSlnGlobalModelBase;
import SA.SRFDA.PS.Core.Deploy.PSDepSlnSysDBImpl;
import SA.SRFDA.PS.Data.PSDepSlnSysDB;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDepSlnSysDBGlobalModel
extends PSDepSlnGlobalModelBase<String, PSDepSlnSysDB, IPSDepSlnSysDB> {
    private static final Log log = LogFactory.getLog(PSDepSlnSysDBGlobalModel.class);

    @Override
    protected PSDepSlnSysDB GetObject(String strPSDepSlnSysDBId) {
        return null;
    }

    @Override
    protected IPSDepSlnSysDB OnCreateModelHelper(PSDepSlnSysDB vt) throws Exception {
        PSDepSlnSysDBImpl iPSDepSlnSysDB = new PSDepSlnSysDBImpl();
        iPSDepSlnSysDB.init(this.iDAGlobalHelper, this.getPSDepSln(), vt);
        return iPSDepSlnSysDB;
    }

    @Override
    protected Boolean TestObjectRenew(PSDepSlnSysDB obj) {
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
    protected IPSDepSlnSysDB registerModel(PSDepSlnSysDB vt) throws Exception {
        IPSDepSlnSysDB iPSDepSlnSysDB = (IPSDepSlnSysDB)this.InternalGetModelHelper(vt.getPSDEPSLNSYSDBID());
        if (iPSDepSlnSysDB != null) {
            return iPSDepSlnSysDB;
        }
        this.setModel(vt.getPSDEPSLNSYSDBID(), vt, null);
        return (IPSDepSlnSysDB)this.FindModelHelper(vt.getPSDEPSLNSYSDBID());
    }

    @Override
    protected Vector<PSDepSlnSysDB> getAllModels() throws Exception {
        Vector<PSDepSlnSysDB> list = new Vector<PSDepSlnSysDB>();
        CallResult callResult = this.iPSModelHelper.getAllPSDepSlnSysDBs(this.iPSDepSln.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u90e8\u7f72\u65b9\u6848\u5168\u90e8\u7cfb\u7edf\u6570\u636e\u5e93\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSDepSlnSysDB vt) {
        return vt.getPSDEPSLNSYSDBID();
    }
}

