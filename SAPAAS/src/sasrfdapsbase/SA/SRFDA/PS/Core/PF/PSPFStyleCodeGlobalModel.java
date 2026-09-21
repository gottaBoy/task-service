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

import SA.SRFDA.PS.Core.PF.IPSPFStyleCode;
import SA.SRFDA.PS.Core.PF.PSPFStyleCodeImpl;
import SA.SRFDA.PS.Core.PF.PSPFStyleGlobalModelBase;
import SA.SRFDA.PS.Data.PSPFStyleCode;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFStyleCodeGlobalModel
extends PSPFStyleGlobalModelBase<String, PSPFStyleCode, IPSPFStyleCode> {
    private static final Log log = LogFactory.getLog(PSPFStyleCodeGlobalModel.class);

    @Override
    protected PSPFStyleCode GetObject(String strPSPFStyleCodeId) {
        return null;
    }

    @Override
    protected IPSPFStyleCode OnCreateModelHelper(PSPFStyleCode vt) throws Exception {
        PSPFStyleCodeImpl iPSPFStyleCode = new PSPFStyleCodeImpl();
        iPSPFStyleCode.init(this.iDAGlobalHelper, this.getPSPFStyle(), vt);
        return iPSPFStyleCode;
    }

    @Override
    protected Boolean TestObjectRenew(PSPFStyleCode obj) {
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
    protected IPSPFStyleCode registerModel(PSPFStyleCode vt) throws Exception {
        IPSPFStyleCode iPSPFStyleCode = (IPSPFStyleCode)this.InternalGetModelHelper(vt.getPSPFSTYLECODEID());
        if (iPSPFStyleCode != null) {
            return iPSPFStyleCode;
        }
        this.setModel(vt.getPSPFSTYLECODEID(), vt, null);
        return (IPSPFStyleCode)this.FindModelHelper(vt.getPSPFSTYLECODEID());
    }

    @Override
    protected Vector<PSPFStyleCode> getAllModels() throws Exception {
        Vector<PSPFStyleCode> list = new Vector<PSPFStyleCode>();
        CallResult callResult = this.iPSModelHelper.getPSPFStyleCodes(this.getPSPFStyle().getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u4e91\u5e94\u7528\u6837\u5f0f\u5b8f\u4ee3\u7801\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSPFStyleCode psPFStyleCode : list) {
            this.setModel(psPFStyleCode.getPSPFSTYLECODEID(), psPFStyleCode, null);
        }
        return list;
    }

    @Override
    protected String getObjectId(PSPFStyleCode vt) {
        return vt.getPSPFSTYLECODEID();
    }
}

