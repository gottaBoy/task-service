/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPFStylePkg;
import SA.SRFDA.PS.Core.PF.PSPFStyleGlobalModelBase;
import SA.SRFDA.PS.Core.PF.PSPFStylePkgImpl;
import SA.SRFDA.PS.Data.PSPFStylePkg;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFStylePkgGlobalModel
extends PSPFStyleGlobalModelBase<String, PSPFStylePkg, IPSPFStylePkg> {
    private static final Log log = LogFactory.getLog(PSPFStylePkgGlobalModel.class);

    @Override
    protected PSPFStylePkg GetObject(String strPSPFStylePkgId) {
        return null;
    }

    @Override
    protected IPSPFStylePkg OnCreateModelHelper(PSPFStylePkg vt) throws Exception {
        PSPFStylePkgImpl iPSPFStylePkg = new PSPFStylePkgImpl();
        iPSPFStylePkg.init(this.iDAGlobalHelper, this.getPSPFStyle(), vt);
        return iPSPFStylePkg;
    }

    @Override
    protected Boolean TestObjectRenew(PSPFStylePkg obj) {
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
    protected IPSPFStylePkg registerModel(PSPFStylePkg vt) throws Exception {
        IPSPFStylePkg iPSPFStylePkg = (IPSPFStylePkg)this.InternalGetModelHelper(vt.getPSPFSTYLEPKGID());
        if (iPSPFStylePkg != null) {
            return iPSPFStylePkg;
        }
        this.setModel(vt.getPSPFSTYLEPKGID(), vt, null);
        return (IPSPFStylePkg)this.FindModelHelper(vt.getPSPFSTYLEPKGID());
    }

    @Override
    protected Vector<PSPFStylePkg> getAllModels() throws Exception {
        Vector<PSPFStylePkg> list = new Vector<PSPFStylePkg>();
        CallResult callResult = this.iPSModelHelper.getPSPFStylePkgs(this.getPSPFStyle().getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u6837\u5f0f\u9700\u6c42\u7ec4\u4ef6\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSPFStylePkg psPFStylePkg : list) {
            this.setModel(psPFStylePkg.getPSPFSTYLEPKGID(), psPFStylePkg, null);
        }
        return list;
    }

    @Override
    protected String getObjectId(PSPFStylePkg vt) {
        return vt.getPSPFSTYLEPKGID();
    }
}

