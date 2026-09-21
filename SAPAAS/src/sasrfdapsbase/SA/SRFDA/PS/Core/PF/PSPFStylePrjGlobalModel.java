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

import SA.SRFDA.PS.Core.PF.IPSPFStylePrj;
import SA.SRFDA.PS.Core.PF.PSPFStyleGlobalModelBase;
import SA.SRFDA.PS.Core.PF.PSPFStylePrjImpl;
import SA.SRFDA.PS.Data.PSPFStylePrj;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFStylePrjGlobalModel
extends PSPFStyleGlobalModelBase<String, PSPFStylePrj, IPSPFStylePrj> {
    private static final Log log = LogFactory.getLog(PSPFStylePrjGlobalModel.class);

    @Override
    protected PSPFStylePrj GetObject(String strPSPFStylePrjId) {
        return null;
    }

    @Override
    protected IPSPFStylePrj OnCreateModelHelper(PSPFStylePrj vt) throws Exception {
        PSPFStylePrjImpl iPSPFStylePrj = new PSPFStylePrjImpl();
        iPSPFStylePrj.init(this.iDAGlobalHelper, this.getPSPFStyle(), vt);
        return iPSPFStylePrj;
    }

    @Override
    protected Boolean TestObjectRenew(PSPFStylePrj obj) {
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
    protected IPSPFStylePrj registerModel(PSPFStylePrj vt) throws Exception {
        IPSPFStylePrj iPSPFStylePrj = (IPSPFStylePrj)this.InternalGetModelHelper(vt.getPSPFSTYLEPRJID());
        if (iPSPFStylePrj != null) {
            return iPSPFStylePrj;
        }
        this.setModel(vt.getPSPFSTYLEPRJID(), vt, null);
        return (IPSPFStylePrj)this.FindModelHelper(vt.getPSPFSTYLEPRJID());
    }

    @Override
    protected Vector<PSPFStylePrj> getAllModels() throws Exception {
        Vector<PSPFStylePrj> list = new Vector<PSPFStylePrj>();
        CallResult callResult = this.iPSModelHelper.getPSPFStylePrjs(this.getPSPFStyle().getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u4e91\u5e94\u7528\u6837\u5f0f\u9879\u76ee\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSPFStylePrj psPFStylePrj : list) {
            this.setModel(psPFStylePrj.getPSPFSTYLEPRJID(), psPFStylePrj, null);
        }
        return list;
    }

    @Override
    protected String getObjectId(PSPFStylePrj vt) {
        return vt.getPSPFSTYLEPRJID();
    }
}

