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

import SA.SRFDA.PS.Core.BA.IPSSysBDTableDE;
import SA.SRFDA.PS.Core.BA.PSSysBDTableDEImpl;
import SA.SRFDA.PS.Core.BA.PSSysBDTableGlobalModelBase;
import SA.SRFDA.PS.Data.PSSysBDTableDE;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysBDTableDEGlobalModel
extends PSSysBDTableGlobalModelBase<String, PSSysBDTableDE, IPSSysBDTableDE> {
    private static final Log log = LogFactory.getLog(PSSysBDTableDEGlobalModel.class);

    @Override
    protected PSSysBDTableDE GetObject(String strPSSysBDTableDEId) {
        return null;
    }

    @Override
    protected IPSSysBDTableDE OnCreateModelHelper(PSSysBDTableDE vt) throws Exception {
        PSSysBDTableDEImpl iPSSysBDTableDE = new PSSysBDTableDEImpl();
        iPSSysBDTableDE.init(this.iDAGlobalHelper, this.getPSSysBDTable(), vt);
        return iPSSysBDTableDE;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysBDTableDE obj) {
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
    protected IPSSysBDTableDE registerModel(PSSysBDTableDE vt) throws Exception {
        IPSSysBDTableDE iPSSysBDTableDE = (IPSSysBDTableDE)this.InternalGetModelHelper(vt.getPSSYSBDTABLEDEID());
        if (iPSSysBDTableDE != null) {
            return iPSSysBDTableDE;
        }
        this.setModel(vt.getPSSYSBDTABLEDEID(), vt, null);
        return (IPSSysBDTableDE)this.FindModelHelper(vt.getPSSYSBDTABLEDEID());
    }

    @Override
    protected Vector<PSSysBDTableDE> getAllModels() throws Exception {
        Vector<PSSysBDTableDE> list = new Vector<PSSysBDTableDE>();
        CallResult callResult = this.iPSModelHelper.getPSSysBDTableDEs(this.iPSSysBDTable.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5927\u6570\u636e\u8868\u5168\u90e8\u6570\u636e\u8868\u5b9e\u4f53\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysBDTableDE vt) {
        return vt.getPSSYSBDTABLEDEID();
    }
}

