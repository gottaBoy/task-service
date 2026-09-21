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
import SA.SRFDA.EAI.Ctrl.IDBOPPublishContext;
import SA.SRFDA.EAI.Data.DBCustom;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Enumeration;
import java.util.Properties;
import java.util.TreeMap;

public class BaseDBOPCustomProcess
extends BaseDBOPProcess {
    protected DBCustom dbCustom = null;
    protected TreeMap<String, String> fieldAliasMap = new TreeMap();

    @Override
    protected void OnInit() throws Exception {
        super.OnInit();
        this.bLogDetailDefault = true;
        this.dbCustom = new DBCustom();
        this.dbCustom.setEAIDBCUSTOMID(this.dbOPProc.GetParamStringValue("EAIDBOPPROCID", ""));
        IDEDataCtrl iDEDataCtrl = this.context.FindDEDataCtrl("EAI0066");
        CallResult callResult = iDEDataCtrl.Get((BaseDataEntity)this.dbCustom);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6570\u636e\u5e93\u64cd\u4f5c\u5904\u7406[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)this.dbCustom.getEAIDBCUSTOMID(), (Object)callResult.getErrorInfo()));
        }
        String strFieldMap = this.dbCustom.getFIELDALIAS();
        Properties fieldMap = PropertiesHelper.Load((String)strFieldMap);
        Enumeration<Object> en = fieldMap.keys();
        while (en.hasMoreElements()) {
            String strKey = (String)en.nextElement();
            String strField = PropertiesHelper.GetProperty((Properties)fieldMap, (String)strKey);
            this.fieldAliasMap.put(strKey, strField);
        }
    }

    @Override
    protected void OnPublish(IDBOPPublishContext context) throws Exception {
        String strCode = this.context.ParseMacro(this.templMethodMap, this.dbCustom.getRAWCODE());
        for (String strAlias : this.fieldAliasMap.keySet()) {
            String strField = this.fieldAliasMap.get(strAlias);
            strCode = strCode.replaceAll(strAlias, strField);
        }
        context.AppendCodeLine(strCode);
    }
}

