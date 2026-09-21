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

import SA.SRFDA.PS.Core.BA.IPSSysBDTable;
import SA.SRFDA.PS.Core.BA.PSSysBDSchemeGlobalModelBase;
import SA.SRFDA.PS.Core.BA.PSSysBDTableImpl;
import SA.SRFDA.PS.Data.PSSysBDTable;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysBDTableGlobalModel
extends PSSysBDSchemeGlobalModelBase<String, PSSysBDTable, IPSSysBDTable> {
    private static final Log log = LogFactory.getLog(PSSysBDTableGlobalModel.class);

    @Override
    protected PSSysBDTable GetObject(String strPSSysBDTableId) {
        return null;
    }

    @Override
    protected IPSSysBDTable OnCreateModelHelper(PSSysBDTable vt) throws Exception {
        PSSysBDTableImpl iPSSysBDTable = new PSSysBDTableImpl();
        iPSSysBDTable.init(this.iDAGlobalHelper, this.getPSSysBDScheme(), vt);
        return iPSSysBDTable;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysBDTable obj) {
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
    protected IPSSysBDTable registerModel(PSSysBDTable vt) throws Exception {
        IPSSysBDTable iPSSysBDTable = (IPSSysBDTable)this.InternalGetModelHelper(vt.getPSSYSBDTABLEID());
        if (iPSSysBDTable != null) {
            return iPSSysBDTable;
        }
        this.setModel(vt.getPSSYSBDTABLEID(), vt, null);
        iPSSysBDTable = (IPSSysBDTable)this.FindModelHelper(vt.getPSSYSBDTABLEID());
        if (vt.getBDTABLETYPE() == 1 || vt.getBDTABLETYPE() == 9 || vt.getBDTABLETYPE() == 2) {
            this.setModel(vt.getPSDENAME(), vt, iPSSysBDTable);
        }
        return iPSSysBDTable;
    }

    @Override
    protected Vector<PSSysBDTable> getAllModels() throws Exception {
        Vector<PSSysBDTable> list = new Vector<PSSysBDTable>();
        CallResult callResult = this.iPSModelHelper.getPSSysBDTables(this.iPSSysBDScheme.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5927\u6570\u636e\u67b6\u6784\u5168\u90e8\u5927\u6570\u636e\u8868\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysBDTable vt) {
        return vt.getPSSYSBDTABLEID();
    }
}

