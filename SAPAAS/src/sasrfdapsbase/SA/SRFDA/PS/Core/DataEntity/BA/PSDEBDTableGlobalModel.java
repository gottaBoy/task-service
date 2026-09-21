/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.BA;

import SA.SRFDA.PS.Core.DataEntity.BA.IPSDEBDTable;
import SA.SRFDA.PS.Core.DataEntity.BA.PSDEBDTableImpl;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityGlobalModelBase;
import SA.SRFDA.PS.Data.PSSysBDTableDE;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEBDTableGlobalModel
extends PSDataEntityGlobalModelBase<String, PSSysBDTableDE, IPSDEBDTable> {
    private static final Log log = LogFactory.getLog(PSDEBDTableGlobalModel.class);

    @Override
    protected PSSysBDTableDE GetObject(String strPSSysBDTableDEId) {
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5927\u6570\u636e\u8868\u914d\u7f6e[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysBDTableDEId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEBDTable OnCreateModelHelper(PSSysBDTableDE vt) throws Exception {
        PSDEBDTableImpl iPSSysBDTableDE = new PSDEBDTableImpl();
        iPSSysBDTableDE.init(this.iDAGlobalHelper, this.getPSDataEntity(), vt);
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
    protected Vector<PSSysBDTableDE> getAllModels() throws Exception {
        Vector<PSSysBDTableDE> psSysBDTableDEList = new Vector<PSSysBDTableDE>();
        CallResult callResult = this.iPSModelHelper.getPSDEBDTables(this.getPSDataEntity().getId(), psSysBDTableDEList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5168\u90e8\u5b9e\u4f53\u5927\u6570\u636e\u8868\u914d\u7f6e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psSysBDTableDEList;
    }

    @Override
    protected IPSDEBDTable registerModel(PSSysBDTableDE vt) throws Exception {
        IPSDEBDTable iPSDEBDTable = (IPSDEBDTable)this.InternalGetModelHelper(vt.getPSSYSBDTABLEDEID());
        if (iPSDEBDTable != null) {
            return iPSDEBDTable;
        }
        this.setModel(vt.getPSSYSBDTABLEDEID(), vt, null);
        return (IPSDEBDTable)this.FindModelHelper(vt.getPSSYSBDTABLEDEID());
    }

    @Override
    protected String getObjectId(PSSysBDTableDE vt) {
        return vt.getPSSYSBDTABLEDEID();
    }
}

