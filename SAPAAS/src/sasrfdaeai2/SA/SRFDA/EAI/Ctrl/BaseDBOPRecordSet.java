/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 */
package SA.SRFDA.EAI.Ctrl;

import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.EAI.Ctrl.IDBOPPKGContext;
import SA.SRFDA.EAI.Ctrl.IDBOPRecordSet;
import SA.SRFDA.EAI.Data.DBRS;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Enumeration;
import java.util.Properties;
import java.util.TreeMap;

public class BaseDBOPRecordSet
implements IDBOPRecordSet {
    protected IDBOPPKGContext context = null;
    protected DBRS recordSet = null;
    protected String strQueryCode = "";
    protected String strQueryCond = "";
    protected TreeMap<String, String> recordSetFieldMap = new TreeMap();

    @Override
    public void Init(IDBOPPKGContext context, DBRS recordSet) throws Exception {
        this.context = context;
        this.recordSet = recordSet;
        if (StringHelper.Compare((String)this.recordSet.getRSTYPE(), (String)"QUERY", (boolean)true) == 0) {
            this.strQueryCode = this.context.ParseMacro(recordSet.getQUERYCMD());
        } else if (!StringHelper.IsNullOrEmpty((String)this.recordSet.getDEID())) {
            IDEHelper iDEHelper = context.getDAGlobalHelper().getDAModelStorage().FindDEHelper(this.recordSet.getDEID());
            if (iDEHelper == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)this.recordSet.getDEID()));
            }
            this.strQueryCode = StringHelper.Format((String)"%1$s.%2$s", (Object)iDEHelper.GetDBSchema(), (Object)iDEHelper.GetMainTable());
        }
        this.strQueryCond = this.context.ParseMacro(recordSet.getQUERYCOND());
        this.OnInit();
    }

    protected void OnInit() throws Exception {
        String strFieldMap = this.recordSet.getFIELDALIAS();
        Properties fieldMap = PropertiesHelper.Load((String)strFieldMap);
        Enumeration<Object> en = fieldMap.keys();
        while (en.hasMoreElements()) {
            String strInsertField = (String)en.nextElement();
            String strInsertValue = PropertiesHelper.GetProperty((Properties)fieldMap, (String)strInsertField);
            this.recordSetFieldMap.put(strInsertField, strInsertValue);
        }
    }

    @Override
    public String ParseMacro(String strCode) throws Exception {
        if (this.recordSetFieldMap.containsKey(strCode)) {
            return this.recordSetFieldMap.get(strCode);
        }
        return strCode;
    }

    @Override
    public String getQueryCode() {
        return this.strQueryCode;
    }

    @Override
    public String getQueryCond() {
        return this.strQueryCond;
    }
}

