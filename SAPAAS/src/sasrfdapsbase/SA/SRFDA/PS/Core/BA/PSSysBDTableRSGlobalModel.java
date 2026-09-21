/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.BA;

import SA.SRFDA.PS.Core.BA.IPSSysBDTableRS;
import SA.SRFDA.PS.Core.BA.PSSysBDSchemeGlobalModelBase;
import SA.SRFDA.PS.Core.BA.PSSysBDTableRSImpl;
import SA.SRFDA.PS.Data.PSSysBDTableRS;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysBDTableRSGlobalModel
extends PSSysBDSchemeGlobalModelBase<String, PSSysBDTableRS, IPSSysBDTableRS> {
    private static final Log log = LogFactory.getLog(PSSysBDTableRSGlobalModel.class);

    @Override
    protected PSSysBDTableRS GetObject(String strPSSysBDTableRSId) {
        return null;
    }

    @Override
    protected IPSSysBDTableRS OnCreateModelHelper(PSSysBDTableRS vt) throws Exception {
        PSSysBDTableRSImpl iPSSysBDTableRS = new PSSysBDTableRSImpl();
        iPSSysBDTableRS.init(this.iDAGlobalHelper, this.getPSSysBDScheme(), vt);
        return iPSSysBDTableRS;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysBDTableRS obj) {
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
    protected IPSSysBDTableRS registerModel(PSSysBDTableRS vt) throws Exception {
        IPSSysBDTableRS iPSSysBDTableRS = (IPSSysBDTableRS)this.InternalGetModelHelper(vt.getPSSYSBDTABLERSID());
        if (iPSSysBDTableRS != null) {
            return iPSSysBDTableRS;
        }
        this.setModel(vt.getPSSYSBDTABLERSID(), vt, null);
        return (IPSSysBDTableRS)this.FindModelHelper(vt.getPSSYSBDTABLERSID());
    }

    @Override
    protected Vector<PSSysBDTableRS> getAllModels() throws Exception {
        Vector<PSSysBDTableRS> list = new Vector<PSSysBDTableRS>();
        CallResult callResult = this.iPSModelHelper.getPSSysBDTableRSes(this.iPSSysBDScheme.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5927\u6570\u636e\u67b6\u6784\u5168\u90e8\u6570\u636e\u8868\u5173\u7cfb\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysBDTableRS vt) {
        return vt.getPSSYSBDTABLERSID();
    }
}

