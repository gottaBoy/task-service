/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.SF.IPSSFStylePrj;
import SA.SRFDA.PS.Core.SF.PSSFStyleGlobalModelBase;
import SA.SRFDA.PS.Core.SF.PSSFStylePrjImpl;
import SA.SRFDA.PS.Data.PSSFStylePrj;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFStylePrjGlobalModel
extends PSSFStyleGlobalModelBase<String, PSSFStylePrj, IPSSFStylePrj> {
    private static final Log log = LogFactory.getLog(PSSFStylePrjGlobalModel.class);

    @Override
    protected PSSFStylePrj GetObject(String strPSSFStylePrjId) {
        return null;
    }

    @Override
    protected IPSSFStylePrj OnCreateModelHelper(PSSFStylePrj vt) throws Exception {
        PSSFStylePrjImpl iPSSFStylePrj = new PSSFStylePrjImpl();
        iPSSFStylePrj.init(this.iDAGlobalHelper, this.getPSSFStyle(), vt);
        return iPSSFStylePrj;
    }

    @Override
    protected Boolean TestObjectRenew(PSSFStylePrj obj) {
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
    protected IPSSFStylePrj registerModel(PSSFStylePrj vt) throws Exception {
        IPSSFStylePrj iPSSFStylePrj = (IPSSFStylePrj)this.InternalGetModelHelper(vt.getPSSFSTYLEPRJID());
        if (iPSSFStylePrj != null) {
            return iPSSFStylePrj;
        }
        this.setModel(vt.getPSSFSTYLEPRJID(), vt, null);
        return (IPSSFStylePrj)this.FindModelHelper(vt.getPSSFSTYLEPRJID());
    }

    @Override
    protected Vector<PSSFStylePrj> getAllModels() throws Exception {
        Vector<PSSFStylePrj> list = new Vector<PSSFStylePrj>();
        CallResult callResult = this.iPSModelHelper.getPSSFStylePrjs(this.getPSSFStyle().getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u540e\u53f0\u670d\u52a1\u6837\u5f0f\u9879\u76ee\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSFStylePrj psPFStylePrj : list) {
            this.setModel(psPFStylePrj.getPSSFSTYLEPRJID(), psPFStylePrj, null);
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSFStylePrj vt) {
        return vt.getPSSFSTYLEPRJID();
    }
}

