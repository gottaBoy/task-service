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

import SA.SRFDA.PS.Core.Database.IPSSysDBColumn;
import SA.SRFDA.PS.Core.Database.PSSysDBColumnImpl;
import SA.SRFDA.PS.Core.Database.PSSysDBTableGlobalModelBase;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSSysDBColumn;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSSysDBColumnGlobalModel
extends PSSysDBTableGlobalModelBase<String, PSSysDBColumn, IPSSysDBColumn> {
    private static final Log log = LogFactory.getLog(PSSysDBColumnGlobalModel.class);

    @Override
    protected PSSysDBColumn GetObject(String strPSSysDBColumnId) {
        return null;
    }

    @Override
    protected IPSSysDBColumn OnCreateModelHelper(PSSysDBColumn vt) throws Exception {
        PSSysDBColumnImpl iPSSysDBColumn = new PSSysDBColumnImpl();
        iPSSysDBColumn.init(this.iDAGlobalHelper, this.getPSSysDBTable(), vt);
        return iPSSysDBColumn;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysDBColumn obj) {
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
    protected IPSSysDBColumn registerModel(PSSysDBColumn vt) throws Exception {
        IPSSysDBColumn iPSSysDBColumn = (IPSSysDBColumn)this.InternalGetModelHelper(vt.getPSSYSDBCOLUMNID());
        if (iPSSysDBColumn != null) {
            return iPSSysDBColumn;
        }
        this.setModel(vt.getPSSYSDBCOLUMNID(), vt, null);
        return (IPSSysDBColumn)this.FindModelHelper(vt.getPSSYSDBCOLUMNID());
    }

    @Override
    protected Vector<PSSysDBColumn> getAllModels() throws Exception {
        Vector<PSSysDBColumn> list = new Vector<PSSysDBColumn>();
        CallResult callResult = this.iPSModelHelper.getPSSysDBColumns(this.iPSSysDBTable.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5173\u7cfb\u6570\u636e\u5e93\u8868\u5168\u90e8\u6570\u636e\u5217\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysDBColumn vt) {
        return vt.getPSSYSDBCOLUMNID();
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSSysDBColumn vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getPSSYSDBCOLUMNNAME())) {
            return new String[]{vt.getPSSYSDBCOLUMNNAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

