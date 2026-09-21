/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.DataEntity.PSDataEntityGlobalModelBase;
import SA.SRFDA.PS.Core.Database.IPSDEDBTable;
import SA.SRFDA.PS.Core.Database.PSDEDBTableImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEDBTable;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDEDBTableGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEDBTable, IPSDEDBTable> {
    private static final Log log = LogFactory.getLog(PSDEDBTableGlobalModel.class);

    @Override
    protected PSDEDBTable GetObject(String strPSDEDBTableId) {
        return null;
    }

    @Override
    protected IPSDEDBTable OnCreateModelHelper(PSDEDBTable vt) throws Exception {
        PSDEDBTableImpl iPSDEDBTable = new PSDEDBTableImpl();
        iPSDEDBTable.init(this.iDAGlobalHelper, this.getPSDataEntity(), vt);
        return iPSDEDBTable;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEDBTable obj) {
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
    protected Vector<PSDEDBTable> getAllModels() throws Exception {
        Vector<PSDEDBTable> psDEDBTableList = new Vector<PSDEDBTable>();
        CallResult callResult = this.iPSModelHelper.getPSDEDBTables(this.getPSDataEntity().getId(), psDEDBTableList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5168\u90e8\u6570\u636e\u8868\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEDBTableList;
    }

    @Override
    protected IPSDEDBTable registerModel(PSDEDBTable vt) throws Exception {
        IPSDEDBTable iPSDEDBTable = (IPSDEDBTable)this.InternalGetModelHelper(vt.getPSDETABLEID());
        if (iPSDEDBTable != null) {
            return iPSDEDBTable;
        }
        this.setModel(vt.getPSDETABLEID(), vt, null);
        iPSDEDBTable = (IPSDEDBTable)this.FindModelHelper(vt.getPSDETABLEID());
        return iPSDEDBTable;
    }

    @Override
    protected String getObjectId(PSDEDBTable vt) {
        return vt.getPSDETABLEID();
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSDEDBTable vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getPSDETABLENAME())) {
            return new String[]{vt.getPSDETABLENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }

    @Override
    protected String getModelInfo() {
        return StringHelper.Format((String)"%1$s[%2$s]", (Object)super.getModelInfo(), (Object)this.getPSDataEntity().getName());
    }
}

