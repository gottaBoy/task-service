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

import SA.SRFDA.PS.Core.BA.IPSSysBDTableDER;
import SA.SRFDA.PS.Core.BA.PSSysBDTableDERImpl;
import SA.SRFDA.PS.Core.BA.PSSysBDTableGlobalModelBase;
import SA.SRFDA.PS.Data.PSSysBDTableDER;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysBDTableDERGlobalModel
extends PSSysBDTableGlobalModelBase<String, PSSysBDTableDER, IPSSysBDTableDER> {
    private static final Log log = LogFactory.getLog(PSSysBDTableDERGlobalModel.class);

    @Override
    protected PSSysBDTableDER GetObject(String strPSSysBDTableDEId) {
        return null;
    }

    @Override
    protected IPSSysBDTableDER OnCreateModelHelper(PSSysBDTableDER vt) throws Exception {
        PSSysBDTableDERImpl iPSSysBDTableDER = new PSSysBDTableDERImpl();
        iPSSysBDTableDER.init(this.iDAGlobalHelper, this.getPSSysBDTable(), vt);
        return iPSSysBDTableDER;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysBDTableDER obj) {
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
    protected IPSSysBDTableDER registerModel(PSSysBDTableDER vt) throws Exception {
        IPSSysBDTableDER iPSSysBDTableDER = (IPSSysBDTableDER)this.InternalGetModelHelper(vt.getPSSYSBDTABLEDERID());
        if (iPSSysBDTableDER != null) {
            return iPSSysBDTableDER;
        }
        this.setModel(vt.getPSSYSBDTABLEDERID(), vt, null);
        return (IPSSysBDTableDER)this.FindModelHelper(vt.getPSSYSBDTABLEDERID());
    }

    @Override
    protected Vector<PSSysBDTableDER> getAllModels() throws Exception {
        Vector<PSSysBDTableDER> list = new Vector<PSSysBDTableDER>();
        CallResult callResult = this.iPSModelHelper.getPSSysBDTableDERs(this.iPSSysBDTable.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5927\u6570\u636e\u8868\u5168\u90e8\u6570\u636e\u8868\u5b9e\u4f53\u5173\u7cfb\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysBDTableDER vt) {
        return vt.getPSSYSBDTABLEDERID();
    }
}

