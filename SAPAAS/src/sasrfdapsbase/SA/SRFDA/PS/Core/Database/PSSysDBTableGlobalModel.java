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

import SA.SRFDA.PS.Core.Database.IPSSysDBTable;
import SA.SRFDA.PS.Core.Database.PSSysDBSchemeGlobalModelBase;
import SA.SRFDA.PS.Core.Database.PSSysDBTableImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSSysDBTable;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSSysDBTableGlobalModel
extends PSSysDBSchemeGlobalModelBase<String, PSSysDBTable, IPSSysDBTable> {
    private static final Log log = LogFactory.getLog(PSSysDBTableGlobalModel.class);

    @Override
    protected PSSysDBTable GetObject(String strPSSysDBTableId) {
        return null;
    }

    @Override
    protected IPSSysDBTable OnCreateModelHelper(PSSysDBTable vt) throws Exception {
        PSSysDBTableImpl iPSSysDBTable = new PSSysDBTableImpl();
        iPSSysDBTable.init(this.iDAGlobalHelper, this.getPSSysDBScheme(), vt);
        return iPSSysDBTable;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysDBTable obj) {
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
    protected IPSSysDBTable registerModel(PSSysDBTable vt) throws Exception {
        IPSSysDBTable iPSSysDBTable = (IPSSysDBTable)this.InternalGetModelHelper(vt.getPSSYSDBTABLEID());
        if (iPSSysDBTable != null) {
            return iPSSysDBTable;
        }
        this.setModel(vt.getPSSYSDBTABLEID(), vt, null);
        return (IPSSysDBTable)this.FindModelHelper(vt.getPSSYSDBTABLEID());
    }

    @Override
    protected Vector<PSSysDBTable> getAllModels() throws Exception {
        Vector<PSSysDBTable> list = new Vector<PSSysDBTable>();
        CallResult callResult = this.iPSModelHelper.getPSSysDBTables(this.iPSSysDBScheme.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5173\u7cfb\u6570\u636e\u5e93\u67b6\u6784\u5168\u90e8\u6570\u636e\u8868\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysDBTable vt) {
        return vt.getPSSYSDBTABLEID();
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSSysDBTable vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getPSSYSDBTABLENAME())) {
            return new String[]{vt.getPSSYSDBTABLENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

