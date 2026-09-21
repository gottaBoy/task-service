/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.EAI.Ctrl;

import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.EAI.Ctrl.IDBOPDataObject;
import SA.SRFDA.EAI.Ctrl.IDBOPPKGContext;
import SA.SRFDA.EAI.Ctrl.IDBOPTmpTable;
import SA.SRFDA.EAI.Data.DBDO;
import SA.SRFramework.Utility.StringHelper;

public class BaseDBOPDataObject
implements IDBOPDataObject {
    protected DBDO dataObject = null;
    protected IDBOPPKGContext context = null;
    protected boolean bTmpTable = false;
    protected IDBOPTmpTable iDBOPTmpTable = null;
    protected IDEHelper iDEHelper = null;
    protected String strDataObjectName = "";

    @Override
    public void Init(IDBOPPKGContext context, DBDO dataObject) throws Exception {
        this.context = context;
        this.dataObject = dataObject;
        if (StringHelper.Compare((String)this.dataObject.getDOTYPE(), (String)"TMPTABLE", (boolean)true) == 0) {
            this.bTmpTable = true;
            this.iDBOPTmpTable = context.FindDBOPTmpTable(dataObject.getEAIDBTMPTABID());
            this.strDataObjectName = this.iDBOPTmpTable.getTmpTableName();
        }
        if (StringHelper.Compare((String)this.dataObject.getDOTYPE(), (String)"DATAENTITY", (boolean)true) == 0) {
            this.iDEHelper = context.getDAGlobalHelper().getDAModelStorage().FindDEHelper(dataObject.getDEID());
            if (this.iDEHelper == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)dataObject.getDEID()));
            }
            this.strDataObjectName = StringHelper.Format((String)"%1$s.%2$s", (Object)this.iDEHelper.GetDBSchema(), (Object)this.iDEHelper.GetMainTable());
        }
        this.OnInit();
    }

    protected void OnInit() throws Exception {
    }

    @Override
    public String ParseMacro(String strCode) throws Exception {
        return strCode;
    }

    @Override
    public boolean isTmpTable() {
        return this.bTmpTable;
    }

    @Override
    public String getDataObjectName() {
        return this.strDataObjectName;
    }

    @Override
    public String getDBDOType() {
        if (this.dataObject != null) {
            return this.dataObject.getDOTYPE();
        }
        return "";
    }
}

