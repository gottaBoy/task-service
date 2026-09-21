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

import SA.SRFDA.PS.Core.BA.IPSSysBDColumn;
import SA.SRFDA.PS.Core.BA.PSSysBDColumnImpl;
import SA.SRFDA.PS.Core.BA.PSSysBDTableGlobalModelBase;
import SA.SRFDA.PS.Data.PSSysBDColumn;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysBDColumnGlobalModel
extends PSSysBDTableGlobalModelBase<String, PSSysBDColumn, IPSSysBDColumn> {
    private static final Log log = LogFactory.getLog(PSSysBDColumnGlobalModel.class);

    @Override
    protected PSSysBDColumn GetObject(String strPSSysBDColumnId) {
        return null;
    }

    @Override
    protected IPSSysBDColumn OnCreateModelHelper(PSSysBDColumn vt) throws Exception {
        PSSysBDColumnImpl iPSSysBDColumn = new PSSysBDColumnImpl();
        iPSSysBDColumn.init(this.iDAGlobalHelper, this.getPSSysBDTable(), vt);
        return iPSSysBDColumn;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysBDColumn obj) {
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
    protected IPSSysBDColumn registerModel(PSSysBDColumn vt) throws Exception {
        IPSSysBDColumn iPSSysBDColumn = (IPSSysBDColumn)this.InternalGetModelHelper(vt.getPSSYSBDCOLUMNID());
        if (iPSSysBDColumn != null) {
            return iPSSysBDColumn;
        }
        this.setModel(vt.getPSSYSBDCOLUMNID(), vt, null);
        return (IPSSysBDColumn)this.FindModelHelper(vt.getPSSYSBDCOLUMNID());
    }

    @Override
    protected Vector<PSSysBDColumn> getAllModels() throws Exception {
        Vector<PSSysBDColumn> list = new Vector<PSSysBDColumn>();
        CallResult callResult = this.iPSModelHelper.getPSSysBDColumns(this.iPSSysBDTable.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5927\u6570\u636e\u8868\u5168\u90e8\u6570\u636e\u5217\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysBDColumn vt) {
        return vt.getPSSYSBDCOLUMNID();
    }
}

