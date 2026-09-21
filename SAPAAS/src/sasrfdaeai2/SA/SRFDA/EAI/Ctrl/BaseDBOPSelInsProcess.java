/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 */
package SA.SRFDA.EAI.Ctrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.EAI.Ctrl.BaseDBOPProcess;
import SA.SRFDA.EAI.Ctrl.IDBOPDataObject;
import SA.SRFDA.EAI.Ctrl.IDBOPRecordSet;
import SA.SRFDA.EAI.Data.DBSelIns;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Enumeration;
import java.util.Properties;
import java.util.TreeMap;

public abstract class BaseDBOPSelInsProcess
extends BaseDBOPProcess {
    protected DBSelIns dbSelIns = null;
    protected IDBOPDataObject iDataObject = null;
    protected IDBOPRecordSet iRecordSet = null;
    protected TreeMap<String, String> insertFieldMap = new TreeMap();
    protected String strQueryCond = "";

    public BaseDBOPSelInsProcess() {
        this.bLogDetailDefault = true;
    }

    @Override
    protected void OnInit() throws Exception {
        super.OnInit();
        this.dbSelIns = new DBSelIns();
        this.dbSelIns.setEAIDBSELINSID(this.dbOPProc.GetParamStringValue("EAIDBOPPROCID", ""));
        IDEDataCtrl iDEDataCtrl = this.context.FindDEDataCtrl("EAI0061");
        CallResult callResult = iDEDataCtrl.Get((BaseDataEntity)this.dbSelIns);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6570\u636e\u5e93\u64cd\u4f5c\u5904\u7406[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)this.dbSelIns.getEAIDBSELINSID(), (Object)callResult.getErrorInfo()));
        }
        this.iDataObject = this.context.FindDBDataObject(this.dbSelIns.getEAIDBDOID());
        this.iRecordSet = this.context.FindDBRecordSet(this.dbSelIns.getEAIDBRSID());
        String strFieldMap = this.dbSelIns.getFIELDMAP();
        StringHelper.Compare((String)this.iDataObject.getDBDOType(), (String)"DATAENTITY", (boolean)true);
        Properties fieldMap = PropertiesHelper.Load((String)strFieldMap);
        Enumeration<Object> en = fieldMap.keys();
        while (en.hasMoreElements()) {
            String strInsertField = (String)en.nextElement();
            String strInsertValue = PropertiesHelper.GetProperty((Properties)fieldMap, (String)strInsertField);
            strInsertField = this.iDataObject.ParseMacro(strInsertField);
            strInsertValue = this.context.ParseMacro(strInsertValue);
            strInsertValue = this.iRecordSet.ParseMacro(strInsertValue);
            strInsertValue = this.iDataObject.ParseMacro(strInsertValue);
            this.insertFieldMap.put(strInsertField, strInsertValue);
        }
        this.strQueryCond = this.context.ParseMacro(this.dbSelIns.getQUERYCOND());
    }
}

